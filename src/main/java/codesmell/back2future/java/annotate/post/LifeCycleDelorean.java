package codesmell.back2future.java.annotate.post;

import codesmell.back2future.bean.car.BackToFuture;
import codesmell.back2future.bean.car.Car;
import codesmell.back2future.bean.engine.Engine;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@BackToFuture
public class LifeCycleDelorean implements Car, InitializingBean, BeanNameAware, ApplicationContextAware, DisposableBean {

    private Engine engine;

    @Override
    public void go() {
        engine.accelerate();
    }

    //
    // instantiate the Bean
    //
    public LifeCycleDelorean() {
        System.out.println("creating bean: " + this.toString());
    }

    //
    // set the dependencies
    //
    public void setEngine(Engine engine) {
        System.out.println("I have an Engine:" + engine.getClass().getSimpleName());
        this.engine = engine;
    }

    //
    // ...Aware interface methods
    //
    @Override
    public void setBeanName(String name) {
        // notice that we have the dependency already
        System.out.println("BeanNameAware: Hi, my name is:" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        System.out.println("ApplicationContextAware: " + appContext.getClass().getSimpleName());
    }

    //
    // initialization access points
    //
    @PostConstruct
    public void postConstruct() throws Exception {
        System.out.println("@PostConstruct: you are ready to go with Engine: " + engine.getClass().getSimpleName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet: you are ready to go with Engine: " + engine.getClass().getSimpleName());
    }

    public void customInit() throws Exception {
        System.out.println("customInit: you are ready to go with Engine: " + engine.getClass().getSimpleName());
    }

    //
    // destruction access points
    //
    @PreDestroy
    public void preDestroy() throws Exception {
        System.out.println("@PreDestroy: ready for the scrap heap");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean: ready for the scrap heap");
    }

    public void customDestroy() throws Exception {
        System.out.println("customDestroy: ready for the scrap heap");
    }
}
