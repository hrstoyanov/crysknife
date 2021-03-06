package org.treblereel.client;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.treblereel.client.inject.named.Vehicle;
import org.treblereel.gwt.crysknife.annotation.DataField;
import org.treblereel.gwt.crysknife.annotation.Templated;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 2/22/19
 */
@Singleton
@Templated("namedbeanconstructorinjectionpanel.html")
public class NamedBeanConstructorInjectionPanel implements IsElement<HTMLDivElement> {

    @Inject
    @DataField
    HTMLDivElement form;

    @DataField
    HTMLInputElement textBox;

    @DataField
    HTMLButtonElement helicopterBtn;

    @DataField
    HTMLButtonElement carBtn;

    Vehicle car;

    Vehicle helicopter;

    @Inject
    NamedBeanConstructorInjectionPanel(@Named("Helicopter") Vehicle helicopter, @Named("Car") Vehicle car) {
        this.car = car;
        this.helicopter = helicopter;
    }

    @PostConstruct
    public void init() {
        initBtn();
    }

    private void initBtn() {
        carBtn.addEventListener("click", evt -> setText(car.whoAmI()));
        helicopterBtn.addEventListener("click", evt -> setText(helicopter.whoAmI()));
    }

    private void setText(String text) {
        textBox.value = text;
    }

    @Override
    public HTMLDivElement element() {
        return form;
    }
}

