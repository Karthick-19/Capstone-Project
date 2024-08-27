package com.example.demo;

import java.util.logging.Logger;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/oauth")
public class oauthrest {
	
    private static final Logger LOGGER = Logger.getLogger(oauthrest.class.getName());

	
	@GetMapping("")
	public String openMessage() {
		return "Open Message";
	}
	
	@GetMapping("/home")
	public String homeMessage() {
		return "Welcome Home";
	}
	
	@GetMapping("/admin")
	public String adminMessage() {
		return "Welcome Admin";
	}
	@GetMapping("/karthi")
	public String getUserPrincipal() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		return "name : "+"principal : "+currentPrincipalName+authentication.getPrincipal();
	}
	
	@GetMapping("/user")
    public String getUser(@AuthenticationPrincipal UserDetails userDetails) {
        return "User Details: " + userDetails.getUsername();
    }
	 @GetMapping("/user-info")
	    public String userInfo(@AuthenticationPrincipal OidcUser oidcUser) {
//	        if (oidcUser != null) {
//	            // Extract user information
//		 String userinfo = oidcUser.getEmail();
		 String userinfo = oidcUser.getUserInfo().getProfile();
		 return userinfo;
//	            String fullName = oidcUser.getFullName();
//	            String email = oidcUser.getEmail();
//	            String username = oidcUser.getPreferredUsername();
//	            Map<String, Object> attributes = oidcUser.getAttributes();
//
//	            // Log user information
//	            LOGGER.info("User Full Name: " + fullName);
//	            LOGGER.info("User Email: " + email);
//	            LOGGER.info("User Preferred Username: " + username);
//	            LOGGER.info("User Attributes: " + attributes);
//	            LOGGER.info("CHECKING FOR USER INFO");
//
//	            // Return user information
//	            return Map.of(
//	                "name", fullName,
//	                "email", email,
//	                "username", username,
//	                "attributes", attributes
//	            );
//	        }
//	        return Map.of("error", "User information not available");
	    }
//	

}
