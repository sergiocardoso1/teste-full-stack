package com.sergiocardoso.backend.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;

import com.sergiocardoso.backend.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch (Exception e) {
			return null;
		}
		
	}

}
