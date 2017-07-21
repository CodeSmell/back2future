package codesmell.back2future.java.annotate.post;

import codesmell.back2future.bean.car.Car;
import codesmell.back2future.bean.engine.Engine;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:app.properties")
@EnableAspectJAutoProxy
public class DeloreanConfig {

    @Bean(name = "delorean", initMethod = "customInit", destroyMethod = "customDestroy")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Car buildDelorean(Engine engine) {
        LifeCycleDelorean d = new LifeCycleDelorean();
        d.setEngine(engine);
        return d;
    }

    @Bean
    public BackToFuturePostProcessor beanPostProcessor() {
        return new BackToFuturePostProcessor();
    }

    @Bean
    public BackToFutureAspect beanAspect() {
        return new BackToFutureAspect();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
