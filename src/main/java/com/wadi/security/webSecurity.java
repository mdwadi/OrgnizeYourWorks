package com.wadi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.wadi.server.userServiceInterface;

@EnableWebSecurity
public class webSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private userServiceInterface userDetailsService;

	@Autowired
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public webSecurity(userServiceInterface userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {

		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.SIGN_UP_URL)
				.permitAll().anyRequest().authenticated().and()
				.addFilter(new authenticationFilter(authenticationManager()));
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(bCryptPasswordEncoder);
	}

}
