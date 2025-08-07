package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Mobile;

public interface MobileDao extends JpaRepository<Mobile, Integer> {

}
