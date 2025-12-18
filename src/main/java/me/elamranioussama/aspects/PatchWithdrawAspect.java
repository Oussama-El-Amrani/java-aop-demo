package me.elamranioussama.aspects;

import me.elamranioussama.metier.MetierBank;
import me.elamranioussama.models.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public class PatchWithdrawAspect {
    @Pointcut("execution(* me.elamranioussama.metier.MetierBank.withdraw(..)) ")
    public void pc1() {}

    @Around("pc1() && args(code, amount)")
    public Object aroundAdvice(Long code, Double amount, ProceedingJoinPoint proceedingJoinPoint, JoinPoint pointcut) throws Throwable {
        MetierBank metierBank = pointcut.getTarget() instanceof MetierBank ? (MetierBank) pointcut.getTarget() : null;
        Account account = metierBank.getAccount(code);
        if (account != null) {
            if (account.getBalance() < amount) {
                System.out.println("Insufficient funds for withdrawal of " + amount + " from account " + code);
                return null;
            } else {
                return proceedingJoinPoint.proceed();
            }
        } else {
            System.out.println("Account with code " + code + " not found.");
            return null;
        }
    }
}
