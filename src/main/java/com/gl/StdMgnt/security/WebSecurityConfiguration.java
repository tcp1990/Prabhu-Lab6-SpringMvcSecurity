package com.gl.StdMgnt.security;

import static org.springframework.http.HttpMethod.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(POST, "/students/save").hasAnyRole("USER", "ADMIN") // #
				.antMatchers("/", "/students/showFormForAdd").hasAnyRole("USER", "ADMIN") // #
				.antMatchers("/students/update", "/students/delete").hasAnyRole("ADMIN").anyRequest().authenticated() // #
				.and().formLogin().loginProcessingUrl("/login").successForwardUrl("/").permitAll() // #
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll() // #
				.and().exceptionHandling().accessDeniedPage("/students/403") // #
				.and().cors().and().csrf().disable();
	}
}