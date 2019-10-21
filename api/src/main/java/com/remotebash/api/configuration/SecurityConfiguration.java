package com.remotebash.api.configuration;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final DataSource dataSource;
    
    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    public SecurityConfiguration(BCryptPasswordEncoder bCryptPasswordEncoder, DataSource dataSource) {
		super();
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.dataSource = dataSource;
	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
        	.inMemoryAuthentication()
        	.withUser("admin")
        		.password("admin")
        		.roles("ADMIN")
        		.and()
        	.withUser("user")
        		.password("user")
        		.roles("USER");
        	
        auth.
        	jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
        		
    }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                //.antMatchers("/admin").hasRole("ADMIN")
                //.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
                .and()
                .formLogin()  
                //.defaultSuccessUrl("/home")
                .loginPage("/login").failureUrl("/login?error=true")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").and().exceptionHandling()  
                .accessDeniedPage("/");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
