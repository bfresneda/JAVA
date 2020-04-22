package com.qintess.eventos.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() { // esse metodo configura componentes externos tipo hibernate
		return new Class[] {
				HibernateConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() { // esse metodo configura o mapeamento do mvc spring
		return new Class[]{				
			WebMvcConfig.class	
		};
		
		
	}

	@Override
	protected String[] getServletMappings() { // esse metodo configura o mapeamento servlet do spring
		return new String[] {
			"/"
		};
	}
	
	

}
