package codesmell.back2future.java.annotate.scope;

import codesmell.back2future.bean.car.Car;
import codesmell.back2future.bean.engine.Engine;
import codesmell.back2future.bean.engine.LegendTwinTurbo;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfig {

    @Bean(name="singletonDelorean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Car singletonDelorean(Engine engine) {
        ScopeDelorean d = new ScopeDelorean();
        d.setEngine(engine);
        return d;
    }

    @Bean(name="protoDelorean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Car protoTypeDelorean(Engine engine) {
        ScopeDelorean d = new ScopeDelorean();
        d.setEngine(engine);
        return d;
    }

    @Bean(name="engine")
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Engine buildEngine() {
        return new LegendTwinTurbo();
    }
}
