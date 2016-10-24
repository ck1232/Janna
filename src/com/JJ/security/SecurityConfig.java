package com.JJ.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource())
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery(
			"select userid,password, enabled from user where userid=?")
		.authoritiesByUsernameQuery(
			"select u.userid, r.name from janna.user_role ur join janna.user u on u.id = ur.userid join janna.role r on ur.roleid= r.id where u.userid=?");
//        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");//dba have two roles.
    }
	
	public DriverManagerDataSource securityDataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/janna");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("root");
	    return driverManagerDataSource;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.csrf().and()
	  	.authorizeRequests()
	  	.antMatchers("/","/dashboard").authenticated()
		.antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN","ADMIN")
		.antMatchers("/development/**").authenticated()
		.antMatchers("/**").denyAll()
		.and().formLogin().loginPage("/login")
		.usernameParameter("username").passwordParameter("password")
		.and().exceptionHandling().accessDeniedPage("/Access_Denied");

	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
