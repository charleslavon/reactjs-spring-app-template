package com.tmd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({WebConfig.class, SecurityConfig.class})
public class ServletConfig {

}
