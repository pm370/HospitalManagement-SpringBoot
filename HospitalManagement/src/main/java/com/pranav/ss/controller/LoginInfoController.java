package com.pranav.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.ss.pojo.LoginInfoPojo;
import com.pranav.ss.service.LoginInfoService;

@RequestMapping("/login/info")
@RestController
public class LoginInfoController {

	@Autowired
	private LoginInfoService loginInfoService;
	
	@PostMapping("/save")
	public void saveInfo(@RequestBody LoginInfoPojo loginInfoPojo) {
		loginInfoService.saveInfo(loginInfoPojo);
	}
	
}
