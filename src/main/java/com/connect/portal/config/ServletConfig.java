package com.connect.portal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebConfig.class, SecurityConfig.class})
//@ImportResource({"classpath:connect.xml"}) as example if you need to include shared xml configs into your app
public class ServletConfig {

}
