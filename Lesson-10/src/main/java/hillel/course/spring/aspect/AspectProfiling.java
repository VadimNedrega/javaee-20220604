package hillel.course.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AspectProfiling {
    private final Logger log = LoggerFactory.getLogger(AspectProfiling.class);

    @Pointcut("execution(* hillel.course.spring.web.controller..*.*(..))")
    public void callOurProfiling() {
    }

    @Around("callOurProfiling()")
    public Object aroundCall(ProceedingJoinPoint jp) throws Throwable {
        StopWatch clock = new StopWatch(jp.toString());
        try {
            clock.start(jp.toShortString());
            return jp.proceed(jp.getArgs());
        } finally {
            clock.stop();
            log.info("ms = " + clock.getLastTaskTimeMillis());
            if (clock.getTotalTimeSeconds() > 10) log.warn("Attention!Long time execution!");
        }
    }
}
