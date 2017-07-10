package codesmell.back2future.bean.car;

import codesmell.back2future.bean.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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

}
