package codesmell.back2future.java.annotate.post;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class BackToFutureAspect {

    @Pointcut("within(@codesmell.back2future.bean.car.BackToFuture *)")
    public void beanAnnotatedWithBackToFuture() {}

    @Pointcut("execution(* codesmell.back2future.bean.car.Car.go(..))")
    public void carGoMethod() {}

    public BackToFutureAspect() {
        System.out.println("creating BackToFutureAspect");
    }

    @Around("carGoMethod() && beanAnnotatedWithBackToFuture())")
    public Object aroundGo(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("@Aspect go about to be called!");

        StopWatch timer = new StopWatch();
        timer.start();

        Object ret = jp.proceed();

        timer.stop();

        System.out.println("@Aspect go took " + timer.getTotalTimeMillis() + " ms");
        return ret;
    }

}
