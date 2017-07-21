package codesmell.back2future.java.annotate.post;

import codesmell.back2future.bean.car.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class PostProcessAppContextMain {

    public static void main(String[] args) {
        // init spring context
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        ((AbstractApplicationContext) appContext).registerShutdownHook();

        // could also use appContext constructor
        appContext.register(DeloreanConfig.class, EngineConfig.class);
        appContext.refresh();

        // get a Delorean and go
        Car car = appContext.getBean("delorean", Car.class);
        car.go();

        // get the Delorean again and go
        car = appContext.getBean("delorean", Car.class);
        car.go();

        appContext.close();
    }
}
