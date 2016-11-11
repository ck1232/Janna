package com.JJ.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	ApplicationContext context;
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource())
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery(
			"select userid,password, enabled from user where userid=?")
		.authoritiesByUsernameQuery(
			"select u.userid, r.name from jj.user_role ur join jj.user u on u.id = ur.userid join jj.role r on ur.roleid= r.id where u.userid=?");
//        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");//dba have two roles.
    }
	
	public DriverManagerDataSource securityDataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/jj");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("root");
	    return driverManagerDataSource;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.csrf()//.ignoringAntMatchers("/product/product/uploadImage")
	  	.and()
	  	.authorizeRequests()
	  	.accessDecisionManager(accessDecisionManager())
	  	.antMatchers("/","/dashboard").authenticated()
		.antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN","ADMIN")
//		.antMatchers("/development/**").authenticated()
//		.antMatchers("/**").denyAll()
		.and().formLogin().loginPage("/login")
		.usernameParameter("username").passwordParameter("password")
		.and().exceptionHandling().accessDeniedPage("/Access_Denied");

	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Bean
	public AccessDecisionManager accessDecisionManager() {
	    List<AccessDecisionVoter<? extends Object>> decisionVoters 
	      = Arrays.asList(
	        new WebExpressionVoter(),
	        new RoleVoter(),
	        new AuthenticatedVoter(),
	        new UrlVoter());
	    return new UnanimousBased(decisionVoters);
	}
}
