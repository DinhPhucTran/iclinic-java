package com.group4.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
	
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/login").permitAll()
                .antMatchers("/add-user").permitAll()
                .antMatchers("/user-list").permitAll()
                .antMatchers("/**").fullyAuthenticated()
                .and().formLogin()
                    	.loginPage("/login").failureUrl("/login?error")
                    	.usernameParameter("username")
                    	.passwordParameter("password")
		.and().logout().logoutSuccessUrl("/login?logout")
		//.and().csrf()
		.and().exceptionHandling().accessDeniedPage("/403");
	    
	    http.csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	  web.ignoring().antMatchers("/resources/**");
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService);
	    authProvider.setPasswordEncoder(passwordEncoder());
	    return authProvider;
	}
}
