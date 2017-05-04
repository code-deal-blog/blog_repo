package org.onlineshoppingportal.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebAppInitializer implements WebApplicationInitializer {

	private static final Logger logger = Logger.getLogger(SpringWebAppInitializer.class);
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContextConfig.class);
			
		ServletRegistration.Dynamic dispatcher = servletContext
											.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		dispatcher.setInitParameter("throwExceptionIfNoHandlerFound", "true");
			
		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(appContext);
		servletContext.addListener(contextLoaderListener);
        if(logger.isInfoEnabled())
        {
        	logger.info("App context initialized.");
        	logger.info("Dispatcher servlet Initialized.");
			logger.info("Filter Initialized.");
        }
	}

}
