package codesmell.back2future.xml;

import codesmell.back2future.bean.car.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryMain {

    public static void main(String[] args) {
        // Default BeanFactory (Basic DI container) implementation used by Spring
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        // Using XML configuration
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("codesmell/back2future/xml/beans.xml"));

        // ask container for a Delorean Bean
        Car car = factory.getBean("dmc12", Car.class);
        car.go();

        System.out.println(car.getClass().getName());
    }

}
