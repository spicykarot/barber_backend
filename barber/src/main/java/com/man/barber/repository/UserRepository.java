package com.man.barber.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.entity.MsUser;

public interface UserRepository extends JpaRepository<MsUser,Long>{
	
	public List<MsUser> findAll();

	
}
