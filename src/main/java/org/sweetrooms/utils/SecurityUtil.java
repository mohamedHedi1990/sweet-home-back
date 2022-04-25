package org.sweetrooms.utils;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.sweetrooms.security.UserDetailsImpl;

/**
 * The type Security util.
 */
public class SecurityUtil {

	/**
	 * Has authority boolean.
	 *
	 * @param authority the authority
	 * @return the boolean
	 */
	public static Boolean hasAuthority(String authority) {
		return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
				.anyMatch(o -> o.getAuthority().equals(authority));
	}

	/**
	 * Gets authentication.
	 *
	 * @return the authentication
	 */
	public static String getAuthentication() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	public static Long getCurrentUserId() {
		return ((UserDetailsImpl) (SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getId();
	}

	/**
	 * Gets authorities.
	 *
	 * @return the authorities
	 */
	public static Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<? extends GrantedAuthority> collection = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();
		return collection;
	}

}
