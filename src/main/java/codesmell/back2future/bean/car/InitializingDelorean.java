package codesmell.back2future.bean.car;

import codesmell.back2future.bean.engine.Engine;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class InitializingDelorean implements Car, InitializingBean, BeanNameAware, ApplicationContextAware {

    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void go() {
        engine.accelerate();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet: you are ready to go with Engine: " + engine.getClass().getSimpleName());
    }

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        System.out.println("appContext: " + appContext.getClass().getSimpleName());
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("beanName: Hi, my name is:" + name);
    }
}
