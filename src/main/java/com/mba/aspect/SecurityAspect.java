package com.mba.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mba.security.helper.SecurityManager;

 
@Component
@Aspect
public class SecurityAspect {
	private final static Logger logger=LogManager.getLogger(SecurityAspect.class);
	
	@Autowired
	private SecurityManager securityManager;
	
	@Pointcut("target(com.mba.beans.LoanManager)")
	public void commonPointcut()
	{
		
	}
	
	@Before("commonPointcut()")
	public void audit(JoinPoint jp)
	{
		//logger.debug("called method {} ({}) by user KIRAN REDDY", methodName,args);	//dont hard code
		logger.debug("called method {} ({}) by user kiran ",jp.getSignature().getName());	
	}
	
	@Before("commonPointcut()")
	public void authenticate(JoinPoint jp) throws Exception
	{
		if(securityManager.isAuthenticated()==false)
		{
			throw new IllegalAccessException("invalid username and password");
		}
	}
}
