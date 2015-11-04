package cs544.spring.bank.service.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import cs544.spring.bank.logging.ILogger;

@Aspect
public class JMSLogAdvice {

	private ILogger logger;

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}
	
	@After("execution(public void cs544.spring.bank.jms.IJMSSender.sendJMSMessage(String))")
	public void logJMSMessage(){
		logger.log("JMS Message has been sent.");
	}
	
}
