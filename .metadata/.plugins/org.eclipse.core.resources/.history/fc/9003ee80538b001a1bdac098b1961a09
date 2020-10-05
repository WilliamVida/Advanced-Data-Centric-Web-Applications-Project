package com.sales.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// the security code in the slides gives an error "The method withDefaultPasswordEncoder() is undefined for the type User" even though for me it worked on the previous lab. a fellow student asked on stackoverflow and was given a fix to the code.
// https://stackoverflow.com/questions/61363348/error-the-method-withdefaultpasswordencoder-is-undefined-for-the-type-user-s
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	// user details
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user1").password("password1").roles("ADMIN").and().withUser("user")
				.password("user").roles("USER");
	}

	// logout - https://stackoverflow.com/questions/23661492/implement-logout-functionality-in-spring-boot
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/addCustomer.html", "/addProduct.html", "/newOrder.html", "/showCustomers.html",
						"/showOrders.html", "/showProducts.html")
				.hasAnyRole("ADMIN", "USER").antMatchers("/admin").hasRole("ADMIN").antMatchers("/").permitAll().and()
				.formLogin().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/");
	}

}
