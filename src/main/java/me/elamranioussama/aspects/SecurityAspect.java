package me.elamranioussama.aspects;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SecurityAspect {
    @Pointcut("execution(* me.elamranioussama.App.main(..) ")
    public void startupPointcut() {}

    @Around("startupPointcut()")
    public void aroundAdvice() {
        System.out.println("SecurityAspect around advice executed");
    }
}
