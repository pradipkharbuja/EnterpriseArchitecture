package org.pradip.pet.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.pradip.pet.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class LoginAspect {

	@Autowired
	private LoginService loginService;

	@Around("execution(public * org.pradip.pet.controller.*.*(..))")
	public Object isLoggedIn(ProceedingJoinPoint joinPoint) throws Throwable {
		if (loginService.isLoggedIn()) {
			return joinPoint.proceed();
		} else {
			return "redirect:/login";
		}
	}

	@Around("execution(public * org.pradip.pet.controller.login.LoginController.login(..))"
			+ "|| execution(public * org.pradip.pet.controller.login.RegisterController.*(..))")
	public Object isAlreadyLoggedIn(ProceedingJoinPoint joinPoint) throws Throwable {
		if (loginService.isLoggedIn()) {
			return "redirect:/";
		} else {
			return joinPoint.proceed();			
		}
	}

}
