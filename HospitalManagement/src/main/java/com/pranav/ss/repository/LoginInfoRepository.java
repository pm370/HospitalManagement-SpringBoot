package com.pranav.ss.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.ss.entity.LoginInfo;

public interface LoginInfoRepository extends JpaRepository<LoginInfo, Long> {

	Optional<LoginInfo> findByUsername(String username);

}
