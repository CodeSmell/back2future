package codesmell.back2future.bean.car;

import codesmell.back2future.bean.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

/**
 * Delorean with two ways to specify an Engine
 *
 */
public class DuplicateAutowiredDelorean implements Car {

    @Autowired
    @Qualifier("twin")
    private Engine engine;

    @Autowired
    @Qualifier("prv")
    public void setEngine(Engine e) {
        engine = e;
    }

    @Override
    public void go() {
        engine.accelerate();
    }

    @PostConstruct
    public void postConstruct() throws Exception {
        System.out.println("postConstruct: DuplicateAutowiredDelorean ready to go with Engine: " + engine.getClass().getSimpleName());
    }
}
