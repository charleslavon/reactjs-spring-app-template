package com.connect.portal.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * Configuration defining shared resources visible to all other web components, 
 * servlets etc and for cross-cutting concerns like security. e.g. like those from a root-context.xml
 */
@Configuration
@ComponentScan("com.connect.portal")
public class AppConfig {

}
