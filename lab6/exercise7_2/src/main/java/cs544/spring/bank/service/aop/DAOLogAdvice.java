package cs544.spring.bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import cs544.spring.bank.logging.ILogger;

@Aspect
public class DAOLogAdvice {

	private ILogger logger;
	
	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@After("execution(* cs544.spring.bank.dao.*.*(..) )")
	public void logMethodOfDAO(JoinPoint joinPont){		
		logger.log(String.format("bank.dao.%s() method is called.", joinPont.getSignature().getName()));
	}
}
