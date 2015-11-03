package cs544.exercise7_1.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

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
}
