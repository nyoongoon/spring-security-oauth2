package io.security.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class CustomOAuth2ClientConfig {
    @Bean
    SecurityFilterChain oauth2SecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests((requests) -> requests
                .antMatchers("/loginPage").permitAll()
                .anyRequest().authenticated());
        httpSecurity.oauth2Login(oauth2 -> oauth2.loginPage("/loginPage"));
        return httpSecurity.build();
    }
}
