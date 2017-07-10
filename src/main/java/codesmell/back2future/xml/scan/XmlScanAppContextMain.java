package codesmell.back2future.xml.scan;

import codesmell.back2future.bean.car.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlScanAppContextMain {

    private static final String SCAN_XML = "codesmell/back2future/xml/scan/scan.beans.xml";

    public static void main(String[] args) {
        // application context for XML
        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(SCAN_XML);

        // ask container for the Bean that is ready to use
        Car car = appContext.getBean("dmc12", Car.class);
        System.out.println(car.getClass().getName());
        car.go();

        appContext.close();
    }

}
