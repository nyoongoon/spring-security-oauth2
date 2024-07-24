package io.security.oauth2.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    /**
     * 시큐리티 필터체인 타입의 빈 생성하기
     * HttpSecurity.build()하여 SecurityFilterChain를 생성할 수 있다.
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        //SecurityFilterChain에 추가하기
        httpSecurity.apply(new CustomSecurityConfigurer().setFlag(false)); //apply를 통하여 SecurityConfigurer를 추가한다.
        return httpSecurity.build();
    }
}
