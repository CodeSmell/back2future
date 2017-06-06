package codesmell.back2future.java.dupe;

import codesmell.back2future.bean.car.Car;
import codesmell.back2future.bean.car.DuplicateAutowiredDelorean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DuplicateScanConfig {

    @Bean(name="dupeDelorean")
    public Car getDelorean() {
        return new DuplicateAutowiredDelorean();
    }

}
