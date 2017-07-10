package codesmell.back2future.java.scan.dupe;

import codesmell.back2future.bean.car.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class DuplicateJavaConfigScanAppContextMain {

    public static void main(String[] args) {
        // init spring context
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        ((AbstractApplicationContext) appContext).registerShutdownHook();

        // scan (must find class with @Configuration (ScanConfig))
        appContext.scan("codesmell.back2future.bean", "codesmell.back2future.java.scan.dupe");
        appContext.refresh();

        // ask container for the Bean that is ready to use
        Car car = appContext.getBean("dupeDelorean", Car.class);
        car.go();

        System.out.println(car.getClass().getName());

        appContext.close();
    }

}
