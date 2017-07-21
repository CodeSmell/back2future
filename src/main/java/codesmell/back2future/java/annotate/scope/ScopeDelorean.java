package codesmell.back2future.java.annotate.scope;

import codesmell.back2future.bean.car.Car;
import codesmell.back2future.bean.engine.Engine;

public class ScopeDelorean implements Car {

    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void go() {
        // checking on the engine instance
        System.out.println("I have an Engine:" + engine.toString());
        engine.accelerate();
    }
}
