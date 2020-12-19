package com.mba.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mba.beans.LoanManager;
import com.mba.config.MBAConfig;
import com.mba.security.helper.SecurityManager;

public class MbaTest {
	private final static Logger logger=LogManager.getLogger(MbaTest.class);
	public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(MBAConfig.class);
	LoanManager loanManager=context.getBean("loanManager",LoanManager.class);
	SecurityManager securityManager=context.getBean("securityManager",SecurityManager.class);
	securityManager.login("kiran", "welcome");
	boolean approved=loanManager.approveLoan(4527L);
	securityManager.logout();
	logger.info("approved loan {} ", approved);
	}

}
