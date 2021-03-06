package org.treblereel.client;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.treblereel.client.inject.BeanOne;
import org.treblereel.gwt.crysknife.annotation.DataField;
import org.treblereel.gwt.crysknife.annotation.Templated;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 2/22/19
 */
@Singleton
@Templated("singletonbeans.html")
public class SingletonBeans implements IsElement<HTMLDivElement> {

    @Inject
    @DataField("root")
    HTMLDivElement form;

    @DataField("input")
    HTMLInputElement textBox;

    @DataField("btn")
    HTMLButtonElement checkBtn;

    @Inject
    BeanOne beanOne1Instance;

    @Inject
    BeanOne beanOne2Instance;

    @PostConstruct
    public void init() {
        initBtn();
    }

    private void initBtn() {
        checkBtn.addEventListener("click", evt -> {
            StringBuffer sb = new StringBuffer();
            sb.append("beanOne1Instance random :");
            sb.append(beanOne1Instance.getRandom());
            sb.append(", beanOne2Instance random :");
            sb.append(beanOne2Instance.getRandom());
            sb.append(", ? equal " + (beanOne1Instance.getRandom() == beanOne2Instance.getRandom()));

            setText(sb.toString());
        });
    }

    private void setText(String text) {
        textBox.value = text;
    }

    @Override
    public HTMLDivElement element() {
        return form;
    }
}