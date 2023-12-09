package com.kamar.imsclient.app_props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * the oauth2 client properties.
 * @author kamar baraka.*/

@ConfigurationProperties(prefix = "app.oauth2")
public record OAuth2ClientProps (
        String githubClientId,
        String githubClientSecret,
        String googleClientId,
        String googleClientSecret
) {
}
