package com.man.barber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.entity.MsUser;
import com.man.barber.entity.TrBarberTeam;
import com.man.barber.model.BarberShopModel;
import com.man.barber.repository.BarberShopRepository;
import com.man.barber.repository.UserRepository;

@Service
public class BarberShopService {

	@Autowired
	private BarberShopRepository barberShopRepository;
	@Autowired
	private UserRepository userRepository;

	public List<MsBarberShop> findUserAll() {
		return barberShopRepository.findAll();
	}

	public MsBarberShop findUserById(long id) {
		return barberShopRepository.findById(id).get();
	}

	public Page<BarberShopModel> getAllBarberShopModelFilterWithPaggingAndSearching(String name, String address,
			Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		return barberShopRepository.findAllFilterWithPagingAndSearching(name, address, paging);
	}

	public Boolean addBarberShop(BarberShopModel barberShopModel) {
		MsBarberShop barbershopTb = new MsBarberShop();
		Boolean result = false;
		try {
			MsUser userTb = userRepository.getById(barberShopModel.getBarberOwnerId());

			barbershopTb.setId(barberShopModel.getId());
			barbershopTb.setName(barberShopModel.getName());
			barbershopTb.setAddress(barberShopModel.getAddress());
			barbershopTb.setTel(barberShopModel.getTel());
			barbershopTb.setImage(barberShopModel.getImage());
			barbershopTb.setBarberOwnerId(userTb);

			barbershopTb = barberShopRepository.save(barbershopTb);

			if (barbershopTb != null) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Boolean updateBarberShop(BarberShopModel barberShopModel) {
		Boolean result = false;
		try {
			MsBarberShop barbershopTb = barberShopRepository.getById(barberShopModel.getId());
			if (barbershopTb != null) {
				if (!ObjectUtils.isEmpty(barberShopModel.getName())) {
					barbershopTb.setName(barberShopModel.getName());
				}
				if (!ObjectUtils.isEmpty(barberShopModel.getAddress())) {
					barbershopTb.setAddress(barberShopModel.getAddress());
				}
				if (!ObjectUtils.isEmpty(barberShopModel.getTel())) {
					barbershopTb.setTel(barberShopModel.getTel());
				}
				if (!ObjectUtils.isEmpty(barberShopModel.getImage())) {
					barbershopTb.setImage(barberShopModel.getImage());
				}
				if (!ObjectUtils.isEmpty(barberShopModel.getBarberOwnerId())) {
					MsUser barberOwner = userRepository.getById(barberShopModel.getBarberOwnerId());
					barbershopTb.setBarberOwnerId(barberOwner);
				}
				barbershopTb = barberShopRepository.save(barbershopTb);
				if (barbershopTb != null) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
