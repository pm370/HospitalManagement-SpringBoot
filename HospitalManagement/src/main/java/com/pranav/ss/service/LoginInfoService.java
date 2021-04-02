package com.pranav.ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pranav.ss.entity.LoginInfo;
import com.pranav.ss.pojo.LoginInfoPojo;
import com.pranav.ss.repository.LoginInfoRepository;

@Service
public class LoginInfoService {

	@Autowired
	private LoginInfoRepository loginInfoRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void saveInfo(LoginInfoPojo loginInfoPojo) {
		LoginInfo loginInfo=new LoginInfo();
		loginInfo.setUsername(loginInfoPojo.getUsername());
		loginInfo.setPassword(passwordEncoder.encode(loginInfoPojo.getPassword()));
		loginInfoRepo.save(loginInfo);
	}
}
