package br.com.retroflix.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MyWebApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		System.out.println(" ----------> Configurando acessos <------------");
		
		httpSecurity.csrf().disable()
						   .authorizeRequests()
						   .antMatchers(HttpMethod.POST,"/login").permitAll()
						   .antMatchers(HttpMethod.GET,"/produtos").permitAll()
						   .antMatchers(HttpMethod.GET, "/produtos/id/*").permitAll()
						   .antMatchers(HttpMethod.GET, "/produtos/*").permitAll()
						   .anyRequest().permitAll();
						   //.anyRequest().authenticated().and().cors();
		httpSecurity.addFilterBefore(new TokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
