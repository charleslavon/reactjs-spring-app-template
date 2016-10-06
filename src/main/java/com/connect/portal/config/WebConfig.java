package com.connect.portal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.connect.portal.service.ConnectService;
import com.connect.portal.service.ConnectServiceImpl;
import com.connect.portal.web.HeaderInjector;

@Configuration
@EnableWebMvc
@ComponentScan("com.connect.portal")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Value("${connect.service.uri}")
	private String connectServiceUri;

	@Bean
	public HeaderInjector headerInjector() {
		return new HeaderInjector();
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:messages", "classpath:marcom");
		messageSource.setCacheSeconds(5);
		return messageSource;
	}

	@Bean
	public ConnectService connect() {

		ConnectService connectServiceImpl = new ConnectServiceImpl(connectServiceUri);
		return connectServiceImpl;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}

	// this is required to support the above config for static resource and is
	// equivalent to the <mvc:default-servlet-handler/> tag
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		configurer.mediaType("atom", MediaType.APPLICATION_ATOM_XML).mediaType("html", MediaType.TEXT_HTML)
				.mediaType("json", MediaType.APPLICATION_JSON);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		registry.jsp("/WEB-INF/", ".html");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		InterceptorRegistration registration = registry.addInterceptor(headerInjector());
		registration.addPathPatterns("/");
	}

}
