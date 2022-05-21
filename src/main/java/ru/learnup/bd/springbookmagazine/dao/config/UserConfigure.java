package ru.learnup.bd.springbookmagazine.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfigure extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests().anyRequest().permitAll(); // Works for GET, POST, PUT, DELETE
        http.authorizeRequests()
                .antMatchers("/").authenticated()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/**").permitAll()
                .and()
                .formLogin();

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
