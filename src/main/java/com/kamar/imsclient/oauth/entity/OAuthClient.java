package com.kamar.imsclient.oauth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * representation of an oauth client.
 * @author kamar baraka.*/

@Entity
@Data
public class OAuthClient {

    @Id
    private String registrationId;

    private String  clientId;
    private String clientSecret;
    private String redirectUri;

}
