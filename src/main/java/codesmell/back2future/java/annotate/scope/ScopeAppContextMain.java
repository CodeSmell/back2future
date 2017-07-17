package codesmell.back2future.java.annotate.scope;

import codesmell.back2future.bean.car.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ScopeAppContextMain {

    public static void main(String[] args) {
        // init spring context
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        ((AbstractApplicationContext) appContext).registerShutdownHook();

        // could also use appContext constructor
        appContext.register(ScopeConfig.class);
        appContext.refresh();

        testSingletonScope(appContext);
        System.out.println("---------------------");
        testPrototypeScope(appContext);

        appContext.close();
    }

    public static void testSingletonScope(ApplicationContext appContext) {
        Car singletonDeloreanOne = appContext.getBean("singletonDelorean", Car.class);
        System.out.println("1st getBean(singletonDelorean) = " + singletonDeloreanOne.toString());
        singletonDeloreanOne.go();

        Car singletonDeloreanTwo = appContext.getBean("singletonDelorean", Car.class);
        System.out.println("2nd getBean(singletonDelorean) = " + singletonDeloreanTwo.toString());
        singletonDeloreanTwo.go();
    }

    public static void testPrototypeScope(ApplicationContext appContext) {
        Car protoDeloreanOne = appContext.getBean("protoDelorean", Car.class);
        System.out.println("1st getBean(protoDelorean) = " + protoDeloreanOne.toString());
        protoDeloreanOne.go();

        Car protoDeloreanTwo = appContext.getBean("protoDelorean", Car.class);
        System.out.println("2nd getBean(protoDelorean) = " + protoDeloreanTwo.toString());
        protoDeloreanTwo.go();
    }

}
