package com.core.movies.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.core.movies.constantsUtils.ConstantsStrings;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		if(username.equals(ConstantsStrings.admin))
		{
			roles=Arrays.asList(new SimpleGrantedAuthority(ConstantsStrings.ROLE_ADMIN));
			return new User(ConstantsStrings.admin,ConstantsStrings.ADMIN_PWD,roles);
		}
		if(username.equals(ConstantsStrings.user))
		{
			roles=Arrays.asList(new SimpleGrantedAuthority(ConstantsStrings.ROLE_USER));
			return new User(ConstantsStrings.user,ConstantsStrings.USER_PWD,roles);
		}
		throw new UsernameNotFoundException(ConstantsStrings.ERROR_USER_NOT_FOUND+ username);
	}

}
