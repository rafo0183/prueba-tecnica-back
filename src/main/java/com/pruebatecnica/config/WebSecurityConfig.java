package com.pruebatecnica.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pruebatecnica.security.JWTAuthenticationFilter;
import com.pruebatecnica.security.JWTAuthorizationFilter;
import com.pruebatecnica.services.UserServices;


@Configuration
public class WebSecurityConfig{
	private final UserDetailsService userDetailsService;
	private final JWTAuthorizationFilter jwtAutorizationFilter;
	private static final Logger log = Logger.getLogger(WebSecurityConfig.class);
	
	
	
	public WebSecurityConfig(UserDetailsService userDetailsService, JWTAuthorizationFilter jwtAutorizationFilter) {
		super();
		this.userDetailsService = userDetailsService;
		this.jwtAutorizationFilter = jwtAutorizationFilter;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {
		log.info("filterChain");
		JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
		jwtAuthenticationFilter.setAuthenticationManager(authManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/services/login/login");
		return http
				.cors()
				.and()
				.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/services/login/register")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(jwtAutorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	@Bean
	AuthenticationManager authManager(HttpSecurity http) throws Exception {
		log.info("authManager");
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		log.info("passwordEncoder");
		return new BCryptPasswordEncoder();
	}
	
	public String generatePass(String pass) {
		return this.passwordEncoder().encode(pass);
	}
}
