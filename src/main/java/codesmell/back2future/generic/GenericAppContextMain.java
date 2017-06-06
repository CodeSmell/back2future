package codesmell.back2future.generic;

import codesmell.back2future.bean.car.Car;
import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class GenericAppContextMain {

    public static void main(String[] args) {
        // application context for Groovy & XML
        GenericApplicationContext appContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(appContext).loadBeanDefinitions("codesmell/back2future/generic/beans.xml");
        new GroovyBeanDefinitionReader(appContext).loadBeanDefinitions("codesmell/back2future/generic/beans.groovy");
        appContext.refresh();

        // ask container for the Bean that is ready to use
        Car car = appContext.getBean("groovyDelorean", Car.class);
        car.go();

        System.out.println(car.getClass().getName());

        appContext.close();
    }

}
