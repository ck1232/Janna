package com.JJ.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
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
@PropertySources({
	@PropertySource(value = "classpath:admin-dev-config.properties", ignoreResourceNotFound = false),
	@PropertySource(value = "file:C:\\Inetpub\\vhosts\\ziumlight.com\\Configuration\\application-${spring.profiles.active}.properties", ignoreResourceNotFound=true)
})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	ApplicationContext context;
	
	@Value("${jdbc.admin.user}")
    private String user;
	
	@Value("${jdbc.admin.password}")
    private String password;
	
	@Value("${jdbc.url}")
    private String url;
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource())
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery(
			"select user_name,password, enabled from user where user_name=?")
		.authoritiesByUsernameQuery(
			"select u.user_name, r.name from user_role ur join user u on u.user_id = ur.user_id join role r on ur.role_id= r.role_id where u.user_name=?");
//        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
//        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");//dba have two roles.
    }
	
	public DriverManagerDataSource securityDataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName(driver);
	    driverManagerDataSource.setUrl(url);
	    driverManagerDataSource.setUsername(user);
	    driverManagerDataSource.setPassword(password);
	    return driverManagerDataSource;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

//	  http.csrf().ignoringAntMatchers("/invoice/saveExcelInvoice")
//	  	.and()
//	  	.authorizeRequests()
//	  	.accessDecisionManager(accessDecisionManager())
//	  	.antMatchers("/invoice/saveExcelInvoice").anonymous()
//	  	.antMatchers("/").authenticated()
//	  	.antMatchers("/dashboard").fullyAuthenticated()
//		.antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN","ADMIN")
//		.antMatchers("/query", "/q").hasAnyRole("ROLE_ADMIN","ADMIN")
//		.antMatchers("/product/**", "/batchintake/**", "/inventory**/**", "/promotion/**").hasAnyRole("PRODUCT_MGR", "ADMIN")
//		.antMatchers("/invoice/**", "/expense/**", "/salarybonus/**", "/employee/**", "/cheque/**").hasAnyRole("DATA_ENTRY_USER", "ADMIN")
//		
////		.antMatchers("/**").authenticated()
////		.antMatchers("/**").denyAll()
//		.and().formLogin().loginPage("/login").permitAll()
//		.usernameParameter("username").passwordParameter("password")
//		.and().exceptionHandling().accessDeniedPage("/Access_Denied")
//		.and().logout().invalidateHttpSession(true).logoutUrl("/logout").deleteCookies("JSESSIONID").permitAll()
//		.and().sessionManagement().maximumSessions(1).expiredUrl("/login").and().invalidSessionUrl("/login");
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
