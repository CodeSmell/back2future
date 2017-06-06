package codesmell.back2future.xml;

import codesmell.back2future.bean.car.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlAppContextMain {

    public static void main(String[] args) {
        // application context for XML
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("codesmell/back2future/xml/beans.xml");

        // ask container for the Bean that is ready to use
        Car car = appContext.getBean("dmc12", Car.class);
        car.go();

        System.out.println(car.getClass().getName());

        appContext.close();
    }

}
