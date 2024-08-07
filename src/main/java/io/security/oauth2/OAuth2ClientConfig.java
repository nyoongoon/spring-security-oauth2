package io.security.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ClientRegistrations;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

/**
 * yml 설정방식이 아닌 자바 설정 방식으로 진행하는 경우
 */
@Configuration
public class OAuth2ClientConfig {
    @Bean
    public ClientRegistrationRepository client  RegistrationRepository(){
        return new InMemoryClientRegistrationRepository(keycloakClientRepository());
    }

    private ClientRegistration keycloakClientRepository() {
        return ClientRegistrations.fromIssuerLocation("http://localhost:8080/realms/oauth2")
                // 클라이언트 정보
                .registrationId("keycloak")
                .clientId("oauth2-client-app") //필수
                .clientSecret("Su4ATret5R17gTgst91YZgt67QCIDoua") //필수
                .redirectUri("http://localhost:8081/login/oauth2/code/keycloak")
                // 프로바이더 정보
//                .issuerUri("http://localhost:8080/realms/oauth2") //위의 fromIssuerLocation()에서 전달하고 있어서 전달안해도 됨
                .build();
    }
}
