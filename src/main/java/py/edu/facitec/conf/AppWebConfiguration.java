package py.edu.facitec.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import py.edu.facitec.controller.HomeController;
import py.edu.facitec.dao.ClienteDAO;

@EnableWebMvc

//Carga los componentes según el paquete especificado
@ComponentScan(basePackageClasses = {HomeController.class,ClienteDAO.class})

public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	
	//metodo para gestionar por Spring
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/static/");
		resolver.setSuffix(".html");
		return resolver;
	}
	
	
	//Habilitar las peticiones para recursos estáticos dentro de AppWebConfiguration.
		@Override
			public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
				configurer.enable();
			}
		
		
		//paquete package org.springframework.format.datetime
		@Bean  	
		public FormattingConversionService mvcConversionService() 
		{ 
		 	DefaultFormattingConversionService conversionService =  	new DefaultFormattingConversionService(true);
		 	DateFormatterRegistrar registrar = new DateFormatterRegistrar(); 
		 	registrar.setFormatter(new DateFormatter("yyyy-MM-dd"));  
		 	registrar.registerFormatters(conversionService); 
		 	return conversionService; 
		 	} 


		

}

	

