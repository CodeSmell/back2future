package codesmell.back2future.groovy;

import codesmell.back2future.bean.car.Car;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyAppContextMain {

    public static void main(String[] args) {
        // application context for Groovy Beans DSL (similar to Grails)
        // note: groovy needs to be in pom
        GenericGroovyApplicationContext appContext = new GenericGroovyApplicationContext("codesmell/back2future/groovy/beans.groovy");

        // ask container for the Bean that is ready to use
        Car car = appContext.getBean("groovyDelorean", Car.class);
        car.go();

        System.out.println(car.getClass().getName());

        appContext.close();
    }

}
