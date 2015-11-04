package cs544.spring.bank.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class StopWatchAdvice {

	@Around("within(cs544.spring.bank.service.*)")
	//@Around("execution(* cs544.spring.bank.service.*.*(..))")
	public Object methodTime(ProceedingJoinPoint joinPoint) throws Throwable {
		
		StopWatch clock = new StopWatch();
		clock.start(joinPoint.toShortString());

		Object object = joinPoint.proceed();

		clock.stop();

		System.out.println("Total Time taken: " + clock.getLastTaskTimeMillis() + " ms");

		return object;
	}

}
