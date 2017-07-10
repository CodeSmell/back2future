package codesmell.back2future.bean.car;

import codesmell.back2future.bean.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * DI without getters/setters methods or constructors
 */
@Component(value="dmc12")
public class ScannableDelorean implements Car {

    @Autowired
    @Qualifier("twin")
    // expects an Engine with the qualifier/name "twin"
    private Engine engine;

    @Override
    public void go() {
        engine.accelerate();
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        System.out.println("postConstruct: ScannableDelorean ready to go with Engine: " + engine.getClass().getSimpleName());
    }
}
