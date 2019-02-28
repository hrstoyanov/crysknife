/*
 * Copyright (C) 2011 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.treblereel.gwt.crysknife.internal.api;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author Mike Brock <cbrock@redhat.com>
 * @author Christian Sadilek <csadilek@redhat.com>
 */
public interface HasAnnotations {
  Annotation[] getAnnotations();

  default boolean isAnnotationPresent(final Class<? extends Annotation> annotation) {
    return getAnnotation(annotation) != null;
  }

  @SuppressWarnings("unchecked")
  default <A extends Annotation> A getAnnotation(final Class<A> annotation) {
    // Please no hate or else null.
    return (A) Arrays.stream(getAnnotations())
            .filter(a -> a.annotationType().equals(annotation))
            .findFirst()
            .orElse(null);
  }
}