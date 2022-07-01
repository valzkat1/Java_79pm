package org.fundacionview.ejemplo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class Configuracion {
	
	  @Bean
	    public ResourceBundleMessageSource messageSource() {

	        var source = new ResourceBundleMessageSource();
	        source.setBasenames("messages");
	        source.setUseCodeAsDefaultMessage(true);

	        return source;
	    }
	

}
