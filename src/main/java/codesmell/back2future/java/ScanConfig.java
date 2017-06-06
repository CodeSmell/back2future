package codesmell.back2future.java;

import codesmell.back2future.bean.car.AnnotatedDelorean;
import codesmell.back2future.bean.car.Car;
import codesmell.back2future.bean.car.Delorean;
import codesmell.back2future.bean.engine.Engine;
import codesmell.back2future.bean.engine.PeugeotRenaultVolvo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScanConfig {

    @Bean(name="delorean")
    public Car getDelorean() {
        // will use LegendTwinTurbo engine
        // because that is what the scan will find
        // with the name "twin"
        return new AnnotatedDelorean();
    }

    @Bean(name="dmc12")
    public Car getAnotherDelorean(@Qualifier("prv") Engine e) {
        // will use PRV because we jammed it in
        Delorean d = new Delorean();
        d.setEngine(e);
        return d;
    }

    // we can override the @Component(value="twin")
    // on LegendTwinTurbo
    // by naming this bean "twin"
    @Bean(name="prv")
    public Engine getPrv() {
        return new PeugeotRenaultVolvo();
    }
}
