package codesmell.back2future.java.annotate.post;

import codesmell.back2future.bean.car.BackToFuture;
import codesmell.back2future.bean.car.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BackToFuturePostProcessor implements BeanPostProcessor {
    // can't use @Value in BPP
    // @Value(value = "${addProxy}")
    private Boolean addProxy = true;
    private Boolean backToFutureRequired = false;

    public BackToFuturePostProcessor() {
        System.out.println("creating BackToFuturePostProcessor");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(BackToFuture.class)) {
            System.out.println("BeanPostProcessor:Before:@BackToFuture: " + beanName);
        }
        return bean;
    }

    /**
     * needed to implement this in the postProcessAfterInitialization method so that the customInit method was already called the customInit method is
     * not part of the Car interface so that caused problems when implementing this in postProcessBeforeInitialization
     */
    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {
        boolean isBackToFutureAnnotated = bean.getClass().isAnnotationPresent(BackToFuture.class);

        if (isBackToFutureAnnotated) {
            System.out.println("BeanPostProcessor:After:@BackToFuture: " + beanName);
        }

        if (bean instanceof Car && addProxy  && (backToFutureRequired ? isBackToFutureAnnotated : true)) {
            return this.proxyCarTimer((Car) bean);
        } else {
            return bean;
        }
    }

    protected Object proxyCarTimer(final Car carBean) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                StringBuilder sb = new StringBuilder("PROXY:" + carBean.getClass().getName() + "." + method.getName());
                System.out.println(sb.toString() + " about to be called!");

                StopWatch timer = new StopWatch();
                timer.start();

                Object ret = method.invoke(carBean, args);

                timer.stop();

                System.out.println(sb.toString() + " took " + timer.getTotalTimeMillis() + " ms");
                return ret;
            }
        };

        Object proxyCar = Proxy.newProxyInstance(carBean.getClass().getClassLoader(), new Class[] { Car.class }, handler);

        return proxyCar;
    }
}
