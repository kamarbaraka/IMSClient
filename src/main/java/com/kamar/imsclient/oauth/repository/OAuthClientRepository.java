package com.kamar.imsclient.oauth.repository;

import com.kamar.imsclient.oauth.entity.OAuthClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository for the oauth2 client.
 * @author kamar baraka.*/

@Repository
public interface OAuthClientRepository extends JpaRepository<OAuthClient, String > {
}
