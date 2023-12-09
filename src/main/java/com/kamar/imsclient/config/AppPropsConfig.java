package com.kamar.imsclient.config;

import com.kamar.imsclient.app_props.OAuth2ClientProps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * configuration of application properties.
 * @author kamar baraka.*/

@Configuration
@EnableConfigurationProperties(value = {OAuth2ClientProps.class})
public class AppPropsConfig {
}
