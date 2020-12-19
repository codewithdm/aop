package com.mba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.mba.security.helper.SecurityManager;

@Configuration
@ComponentScan(basePackages = {"com.mba.beans","com.mba.aspect"})
@EnableAspectJAutoProxy
public class MBAConfig {
	@Bean
	public SecurityManager securityManager() {
		return SecurityManager.getInstance();
	}
}
