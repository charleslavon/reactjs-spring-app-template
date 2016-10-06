package com.connect.portal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/login/**").antMatchers("/bower_components/**").antMatchers("/images/**")
				.antMatchers("/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// example security configs
		http.authorizeRequests().antMatchers("/signup", "/about", "/").permitAll().antMatchers("/**").hasRole("ADMIN")
				.antMatchers("/landing/**").authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/homePage").failureUrl("/loginPage?error").and().logout()
				.logoutSuccessUrl("/loginPage?logout").permitAll();
	}
}
