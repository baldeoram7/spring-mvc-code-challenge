package com.api.security;

import com.api.config.WebAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfigurator extends WebSecurityConfigurerAdapter {

    @Autowired
    private WebAuthenticationSuccessHandler successHandler;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("MontanaMax!!");
        auth.inMemoryAuthentication().withUser("elmyraduff")
                .password(hashedPassword).roles("USER");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/*").hasRole("USER")
                .antMatchers("/loginsuccess").hasRole("USER")
                .antMatchers("/createpet").hasRole("USER")
                .antMatchers("/createpets").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/listmissingpets").permitAll()
                .antMatchers("/").permitAll()
                .and().formLogin()
                .successHandler(new WebAuthenticationSuccessHandler())
                .loginPage("/login")
                .permitAll()
                .and().logout()
                .logoutSuccessUrl("/");

    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
