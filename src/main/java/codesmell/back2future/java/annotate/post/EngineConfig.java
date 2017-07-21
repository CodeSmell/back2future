package codesmell.back2future.java.annotate.post;

import codesmell.back2future.bean.engine.Engine;
import codesmell.back2future.bean.engine.FluxCapacitor;
import codesmell.back2future.bean.engine.LegendTwinTurbo;
import codesmell.back2future.bean.engine.MrFusionWithFluxCapacitor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EngineConfig {

    @Value(value = "${backInTime}")
    private Boolean backInTime;

    @Bean(name="engine")
    public Engine buildEngine() {
        if (backInTime) {
            return new MrFusionWithFluxCapacitor();
        }
        return new LegendTwinTurbo();
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
