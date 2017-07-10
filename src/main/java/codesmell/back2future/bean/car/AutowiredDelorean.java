package codesmell.back2future.bean.car;

import codesmell.back2future.bean.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * minimal annotations
 * DI without getters/setters methods or constructors
 */
public class AutowiredDelorean implements Car {

    @Autowired
    // expects an Engine with @Primary or only one to be available
    private Engine engine;

    @Override
    public void go() {
        engine.accelerate();
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        System.out.println("postConstruct: AutowiredDelorean ready to go with Engine: " + engine.getClass().getSimpleName());
    }

}
