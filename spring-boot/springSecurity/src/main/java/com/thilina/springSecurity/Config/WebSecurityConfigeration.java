package com.thilina.springSecurity.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfigeration extends WebSecurityConfigurerAdapter {

    @Bean//responsible to manage Authentication --->we didn't configure it so we use ...ManagerBean()
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //user detail service to save user details to authenticate
    //--we configure it so we not override  userDetailServiceBean()
    //instead we override userDetailService()
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder().username("user").password(passwordEncoder().encode("userpass")).roles("USER").build();

        UserDetails userAdmin = User.builder().username("admin").password(passwordEncoder().encode("adminpass")).roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,userAdmin);
    }

    //define protected urls and private urls in website


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/home").permitAll()
                .antMatchers("/webprivate/**").authenticated()//Authorize all peoples can access
                .antMatchers("/webadmin/**").hasRole("ADMIN")//only ADMIN can access
                .and()
                .formLogin().loginPage("/login").permitAll()//in here we only gives .formLogin() it gives default login page
                .and()
                .logout().permitAll();
    }
}
