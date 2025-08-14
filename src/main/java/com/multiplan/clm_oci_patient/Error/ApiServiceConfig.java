package com.multiplan.clm_oci_patient.Error;

import com.multiplan.clm_oci_patient.config.DefaultApiExceptionHandler;
import org.springframework.context.annotation.Bean;


/*
 * Common Beans used by all Api Services
 */
public class ApiServiceConfig {
	
	@Bean
	public DefaultApiExceptionHandler apiServiceExceptionHandler() {
		return new DefaultApiExceptionHandler();
	}
}
