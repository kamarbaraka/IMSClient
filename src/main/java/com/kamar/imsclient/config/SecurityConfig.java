package com.kamar.imsclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.web.SecurityFilterChain;

/**
 * the security configuration.
 * @author kamar baraka.*/


@Configuration
public class SecurityConfig  {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{

        /*set the authentication method*/
        httpSecurity.oauth2Login(oauth2 -> {});

        ClientRegistration githubClientRegistration = CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId("8dd8830b0ae03146ca71")
                .clientSecret("899f7b5aad76fb972ddd1d87d1c452425b365dba").build();
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());

        return httpSecurity.build();
    }
}
