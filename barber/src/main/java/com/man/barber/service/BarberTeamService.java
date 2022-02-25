package com.man.barber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.man.barber.entity.TrBarberTeam;
import com.man.barber.repository.BarberShopRepository;
import com.man.barber.repository.BarberTeamRepository;

@Service
public class BarberTeamService {
	
	@Autowired
	private BarberTeamRepository barberTeamRepository;
	
	public List<TrBarberTeam> findUserAll() {
        return barberTeamRepository.findAll();
    }

    public TrBarberTeam findUserById(long id) {
        return barberTeamRepository.findById(id).get();
    }
    
    

}
