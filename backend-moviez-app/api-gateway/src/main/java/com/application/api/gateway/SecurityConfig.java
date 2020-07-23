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
		UserBuilder builder = User.withDefaultPasswordEncoder(); // noop(plain text) | bcrypt
		
		auth.inMemoryAuthentication()
			.withUser(builder.username("admin").password("Password@123").roles("ADMIN"));
//			.withUser(builder.username("Second").password("abc").roles("ADMIN"))
//			.withUser(builder.username("Third").password("abc").roles("ADMIN"));
		
	}
	
	// core logic constraint
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.cors() 
//		.and()
//			.csrf().disable() 
//			.authorizeRequests()
//				.antMatchers("/movies-service/movies/**").hasRole("ADMIN")
//				.antMatchers("/multiplex-service/multiplex/**").hasRole("ADMIN")
//				.antMatchers("/allotment-service/allot/**").hasRole("ADMIN")
//				.antMatchers("/multiplex-service/multiplex/getall").permitAll()
//				//.antMatchers("/micro-user/**").permitAll() // all ROLES 
//			.and()
//				.httpBasic();
		
	}
	
	// configure JWT/OAuth
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
}
