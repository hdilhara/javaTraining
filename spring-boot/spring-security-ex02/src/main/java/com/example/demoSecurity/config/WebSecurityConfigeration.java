package com.example.demoSecurity.config;



import org.springframework.beans.factory.annotation.Configurable;
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

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user= User.builder().username("user").password(passwordEncoder().encode("upass")).roles("R").build();
        UserDetails admin=User.builder().username("admin").password(passwordEncoder().encode("apass")).roles("W","R").build();

        return new InMemoryUserDetailsManager(user,admin);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/home").permitAll()
                .antMatchers("/private").hasRole("R")//.access("hasRole('R') or hasRole('W')")/*************/
                .antMatchers("/admin").hasRole("W")
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll();
    }

}
// http
//         .csrf (). disable ()
//         .authorizeRequests ()
//         .antMatchers ( "/" "/ index", "/ webpublico"). permitAll ()
//         .antMatchers ( "/ webprivado"). authenticated ()
//         .antMatchers ( "/ webadmin"). hasRole ( "ADMIN"). and ()
//         .formLogin ()
//         .loginPage ( "/ login")
//         .permitAll ()
//         .and ()
//         .logout () // get method for I desabilitado CSRF
//         .permitAll ();