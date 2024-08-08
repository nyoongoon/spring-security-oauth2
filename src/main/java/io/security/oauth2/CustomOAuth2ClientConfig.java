package io.security.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
public class CustomOAuth2ClientConfig {
    @Bean
    SecurityFilterChain oauth2SecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests((requests) -> requests.anyRequest().authenticated());
        httpSecurity.oauth2Login(Customizer.withDefaults());
        httpSecurity.oauth2Client();
        return httpSecurity.build()
    }
}
