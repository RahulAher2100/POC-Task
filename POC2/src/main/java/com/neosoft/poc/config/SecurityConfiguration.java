package com.neosoft.poc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	private UserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(myUserDetailsService);
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/insert")
		.permitAll()
		.antMatchers("/token")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.exceptionHandling()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	
	
	
//-------------------------------------------------------------------------------------------	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		//super.configure(http);
//		
//		http.cors().and().csrf().disable();
//		http.authorizeHttpRequests()
//		.antMatchers("/insert").permitAll()
//		.antMatchers("/getAll").authenticated()
//		.antMatchers("/findByStudentId/{studId}").authenticated()
//		.and().formLogin()
//		.and().httpBasic();
//	}
//	
	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		//super.configure(auth);
//		
//		
//		auth.inMemoryAuthentication().withUser("rahul").password("rahul21").roles("STUDENT");
//		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
//	}
	
	
	
	
	//----security for all api---
	
//	@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			// TODO Auto-generated method stub
//			//super.configure(http);
//		
//		  http.csrf().disable();
//		  
//		  http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
//		}
	
	
	
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//		
//		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//		
//	}
	
	
	//---security based on url
	
//	@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			// TODO Auto-generated method stub
//			//super.configure(http);
//		
//		http.csrf().disable();
//		
//		http.authorizeRequests().antMatchers("/getAll").fullyAuthenticated().and().httpBasic();
//		http.authorizeRequests().antMatchers("/findByStudentId/{studentId}").fullyAuthenticated().and().httpBasic();
//		}
	
	
	
	
	
	//---security based on role 
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		//super.configure(http);
//	
//	http.csrf().disable();
//	
//	//http.authorizeRequests().antMatchers("/insert").hasAnyRole("STUDENT").anyRequest().fullyAuthenticated().and().httpBasic();
//	http.authorizeRequests().antMatchers("/getAll").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
//	http.authorizeRequests().antMatchers("/findByStudentId/{studentId}").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
//	}

}
