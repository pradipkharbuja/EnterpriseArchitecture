package cs544.exercise7_1.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

import cs544.exercise7_1.EmailSender;

@Aspect
public class AdviceExample {

	@After("execution(public void cs544.exercise7_1.EmailSender.sendEmail(String, String))" + " && args(e, m)")
	public void sendEmailLog(JoinPoint joinPont, String e, String m) {
		System.out.println(
				new Date() + " method = " + joinPont.getSignature().getName() + " address = " + e + " message = " + m);
		System.out.println("outgoing mail server = " + ((EmailSender) joinPont.getTarget()).getOutgoingMailServer());
	}

	@Before("execution(public void cs544.exercise7_1.EmailSender.sendEmail(String, String))")
	public void beforeSendEmailLog() {
		System.out.println("Sending Email ....");
	}

	@Around("execution(public void cs544.exercise7_1.ICustomerDAO.save(..))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		
		// print the time to the console
		System.out.println("Time to execute save = " + totaltime + " ms");
		
		
		return retVal;
	}
}
