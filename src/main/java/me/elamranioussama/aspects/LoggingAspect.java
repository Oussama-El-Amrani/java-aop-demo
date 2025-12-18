package me.elamranioussama.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    private Long t1, t2;

    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));
        logger.setUseParentHandlers(false);
    }

    @Pointcut("execution(* me.elamranioussama.metier.MetierBank.*(..)) ")
    public void pc1() {}

    @Before("pc1()")
    public void beforeAdvice(JoinPoint joinPoint) {
        t1 = System.currentTimeMillis();
        System.out.println("LoggingAspect before advice executed" + joinPoint.getSignature());
    }

    @After("pc1()")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("LoggingAspect after advice executed" + joinPoint.getSignature());
        t2 = System.currentTimeMillis();
        logger.info("Duration: " + (t2 - t1) + " ms");
        System.out.println("------------------------------------------------------------");
    }
}
