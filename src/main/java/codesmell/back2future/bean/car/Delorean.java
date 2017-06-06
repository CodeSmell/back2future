package codesmell.back2future.bean.car;

import codesmell.back2future.bean.engine.Engine;

public class Delorean implements Car {

    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void go() {
        engine.accelerate();
    }
}
