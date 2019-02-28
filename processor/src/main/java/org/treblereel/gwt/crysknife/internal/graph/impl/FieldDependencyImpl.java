/*
 * Copyright (C) 2015 Red Hat, Inc. and/or its affiliates.
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

package org.treblereel.gwt.crysknife.internal.graph.impl;

import org.jboss.errai.codegen.meta.HasAnnotations;
import org.jboss.errai.codegen.meta.MetaField;
import org.jboss.errai.ioc.rebind.ioc.graph.api.DependencyGraphBuilder.DependencyType;
import org.jboss.errai.ioc.rebind.ioc.graph.api.DependencyGraphBuilder.FieldDependency;

/**
 * @see FieldDependency
 * @author Max Barkley <mbarkley@redhat.com>
 */
class FieldDependencyImpl extends BaseDependency implements FieldDependency {

  final MetaField field;

  FieldDependencyImpl(final InjectableReference abstractInjectable, final MetaField field) {
    super(abstractInjectable, DependencyType.Field);
    this.field = field;
  }

  @Override
  public MetaField getField() {
    return field;
  }

  @Override
  protected HasAnnotations getAnnotated() {
    return field;
  }

}