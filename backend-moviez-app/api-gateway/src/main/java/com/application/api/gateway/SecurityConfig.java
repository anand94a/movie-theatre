package com.application.api.gateway;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// TO create users
		UserBuilder builder = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(builder.username("admin").password("Password@123").roles("ADMIN"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors() 
		.and()
			.csrf().disable(); 
//			.authorizeRequests()
//				.antMatchers("/movies-service/movies/**").permitAll()
//				.antMatchers("/multiplex-service/multiplex/**").permitAll()
//				.antMatchers("/allotment-service/allot/**").permitAll()
////				.antMatchers("/multiplex-service/multiplex/getall").permitAll()
				//.antMatchers("/micro-user/**").permitAll() // all ROLES 
//			.and()
//				.httpBasic();
		
        http
        .authorizeRequests()
        .antMatchers("/api/**").permitAll()
		.antMatchers("/movies-service/movies/**").permitAll()
		.antMatchers("/multiplex-service/multiplex/**").permitAll()
		.antMatchers("/allotment-service/allot/**").permitAll()
		.antMatchers("/multiplex-service/multiplex/getall").permitAll()
        .and()
        .httpBasic();
		
	}
	
}
