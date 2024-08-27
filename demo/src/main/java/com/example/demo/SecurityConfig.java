package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
//	@Bean
//	SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
//		return http
//				.authorizeHttpRequests(req -> {
//					req.requestMatchers("/").permitAll();
//					req.anyRequest().authenticated();
//				})
//				.oauth2Login(withDefaults())
//				.formLogin(withDefaults())
//				.build();
//	}
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/", "/login**").permitAll()  // Allow access to root and login endpoints
                    .anyRequest().authenticated()  // Require authentication for all other endpoints
            )
            .oauth2Login(oauth2Login ->
                oauth2Login
                    .userInfoEndpoint(userInfoEndpoint -> 
                        userInfoEndpoint.oidcUserService(oidcUserService()) // Process user info for OIDC
                    )
                    .defaultSuccessUrl("/api/oauth/home", true)  // Redirect to an API endpoint after successful login
            );
        return http.build();
    }
	
//	An implementation of an OAuth2UserService that supports OpenID Connect 1.0Provider's.
	  public OidcUserService oidcUserService() {
	        OidcUserService oidcUserService = new OidcUserService();
	        // Customize the OIDC user service if necessary
	        return oidcUserService;
	    }

}
