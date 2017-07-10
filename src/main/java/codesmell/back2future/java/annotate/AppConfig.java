package codesmell.back2future.java.annotate;

import codesmell.back2future.bean.car.AutowiredDelorean;
import codesmell.back2future.bean.car.Car;
import codesmell.back2future.bean.engine.Engine;
import codesmell.back2future.bean.engine.FluxCapacitor;
import codesmell.back2future.bean.engine.MrFusionWithFluxCapacitor;
import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean(name="delorean")
    public Car buildDelorean() {
        // will fail because there is no
        // Engine with the name "twin"
        return new AutowiredDelorean();
    }

    @Bean(name="flux")
    public Engine buildAnotherEngine() {
        return new MrFusionWithFluxCapacitor();
    }

    @Bean
    public FluxCapacitor buildFlux() {
        return new FluxCapacitor() {
            @Override
            public void engage() {
                System.out.println("McFly!");
            }
        };
    }
}
