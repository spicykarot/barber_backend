package com.man.barber.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.entity.TrBarberTeam;

public interface BarberTeamRepository extends JpaRepository<TrBarberTeam,Long>{
	
	public List<TrBarberTeam> findAll();


}
