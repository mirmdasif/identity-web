package com.identityweb.config.security;

import com.identityweb.utils.IdentityAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN_URL = "/j_spring_security_check";
    private static final String LOGOUT_URL = "/j_spring_security_logout";

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login","/signup").permitAll()
                .antMatchers(("/userProfile")).access("hasRole('ROLE_USER')")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/userProfile")
                .loginProcessingUrl(LOGIN_URL)
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout").logoutUrl(LOGOUT_URL)
                .and()
                .csrf();

    }

    @Bean
    public AuthenticationProvider authProvider(){
        return new IdentityAuthProvider();
    }
}