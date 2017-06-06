package codesmell.back2future.java.dupe;

import codesmell.back2future.bean.car.Car;
import codesmell.back2future.bean.car.DuplicateAutowiredDelorean;
import codesmell.back2future.bean.engine.Engine;
import codesmell.back2future.bean.engine.LegendTwinTurbo;
import codesmell.back2future.bean.engine.PeugeotRenaultVolvo;
import org.springframework.context.annotation.Bean;

public class DuplicateAppConfig {

    @Bean(name="dupeDelorean")
    public Car buildDelorean() {
        return new DuplicateAutowiredDelorean();
    }

    @Bean(name="twin")
    public Engine buildTurbo() {
        return new LegendTwinTurbo();
    }

    @Bean(name="prv")
    public Engine buildDefault() {
        return new PeugeotRenaultVolvo();
    }
}
