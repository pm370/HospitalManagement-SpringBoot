package com.pranav.ss.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pranav.ss.entity.LoginInfo;
import com.pranav.ss.repository.LoginInfoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MemberDetailService implements UserDetailsService {

	@Autowired
	private LoginInfoRepository loginInfoRepo;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		LoginInfo loginInfo = loginInfoRepo.findByUsername(username)
				.orElseThrow(()-> new BadCredentialsException("Invalid Username or Password"));
		return new SecureMember(loginInfo);
	}
}
