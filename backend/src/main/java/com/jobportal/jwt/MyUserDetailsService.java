package com.jobportal.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobportal.dto.UserDTO;
import com.jobportal.exception.JobPortalException;
import com.jobportal.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			// Fetch user details based on the email
			UserDTO dto = userService.getUserByEmail(email);

			if (dto == null) {
				logger.error("User with email {} not found", email);
				throw new UsernameNotFoundException("User not found with email: " + email);
			}

			// Return custom user details object
			return new CustomUserDetails(dto.getId(), email, dto.getName(), dto.getPassword(),
					dto.getProfileId(), dto.getAccountType(), new ArrayList<>());
		} catch (JobPortalException e) {
			// Log the exception and rethrow it as a UsernameNotFoundException
			logger.error("Error occurred while fetching user details for email: {}", email, e);
			throw new UsernameNotFoundException("User not found with email: " + email, e);
		}
	}
}
