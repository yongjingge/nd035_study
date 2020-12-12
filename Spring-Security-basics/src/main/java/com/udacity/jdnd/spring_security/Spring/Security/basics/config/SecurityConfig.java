package com.udacity.jdnd.spring_security.Spring.Security.basics.config;
/**
 * @author SarGould
 * Our Spring Security Configuration
 * implements the methods that modify Spring's configuration to use our self-defined AuthenticationService.
 */

import com.udacity.jdnd.spring_security.Spring.Security.basics.service.AuthenticationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationService authenticationService;

    public SecurityConfig (AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * used to tell Spring to use our AuthenticationService to check user logins
     * @param auth
     */
    @Override
    protected void configure (AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(this.authenticationService);
    }

    /**
     * used to configure the HttpSecurity object by chaining methods to express security requirements.
     * Specifically four tasks:
     * - allow all users to access the /signup page, as well as the css and js files;
     * - allow authenticated users to make request that is not explicitly covered elsewhere;
     * - generate a login form at /login page, allow anyone to access it;
     * - redirect successful logins to the /home page.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/signup", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();
        http.formLogin()
                .loginPage("/login")
                .permitAll();

        http.formLogin()
                .defaultSuccessUrl("/home", true);
    }
}
