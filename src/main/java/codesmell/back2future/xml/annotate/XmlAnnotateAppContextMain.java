package codesmell.back2future.xml.annotate;

import codesmell.back2future.bean.car.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAnnotateAppContextMain {

    private static final String ANNOTATE_XML = "codesmell/back2future/xml/annotate/annotate.beans.xml";

    public static void main(String[] args) {
        // application context for XML
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(ANNOTATE_XML);

        // ask container for the Bean that is ready to use
        Car car = appContext.getBean("dmc12autowire", Car.class);
        car.go();

        System.out.println(car.getClass().getName());

        appContext.close();
    }

}
