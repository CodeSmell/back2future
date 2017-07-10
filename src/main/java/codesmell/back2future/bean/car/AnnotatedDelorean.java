package codesmell.back2future.bean.car;

import codesmell.back2future.bean.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="dmc12")
public class AnnotatedDelorean implements Car {

    @Autowired
    @Qualifier("twin")
    // expects an Engine with the qualifier/name "twin"
    private Engine engine;

    @Override
    public void go() {
        engine.accelerate();
    }

    // look at me: DI without getters/setters methods or constructors
}
