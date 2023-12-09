package com.kamar.imsclient.config;

import com.kamar.imsclient.app_props.OAuth2ClientProps;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

/**
 * the security configuration.
 * @author kamar baraka.*/


@Configuration
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity
                                                   )throws Exception{

        /*set the authentication method*/
        httpSecurity.oauth2Login(oauth2 -> {});

        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());

        return httpSecurity.build();
    }

    @Bean(name = {"github"})
    public ClientRegistration buildGithubClientRegistration(OAuth2ClientProps oAuth2ClientProps){

        return CommonOAuth2Provider.GITHUB.getBuilder("github")
                .clientId(oAuth2ClientProps.githubClientId())
                .clientSecret(oAuth2ClientProps.githubClientSecret())
                .build();
    }

    @Bean(name = {"google"})
    public ClientRegistration buildGoogleClientRegistration(OAuth2ClientProps clientProps){

        return CommonOAuth2Provider.GOOGLE.getBuilder("google")
                .clientId(clientProps.googleClientId())
                .clientSecret(clientProps.googleClientSecret())
                .build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(@Qualifier("github") ClientRegistration githubClientRegistration,
                                                                     @Qualifier("google") ClientRegistration googleClientRegistration){

        return new InMemoryClientRegistrationRepository(githubClientRegistration, googleClientRegistration);
    }
}
