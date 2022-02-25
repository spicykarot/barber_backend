package com.man.barber.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.entity.MsUser;
import com.man.barber.entity.TrAppointment;
import com.man.barber.model.AppointmentDTO;
import com.man.barber.model.AppointmentModel;
import com.man.barber.model.BarberShopModel;
import com.man.barber.model.UserModel;
import com.man.barber.repository.AppointmentRepository;
import com.man.barber.repository.BarberShopRepository;
import com.man.barber.repository.UserRepository;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private BarberShopRepository barberShopRepository;
	@Autowired
	private UserRepository userRepository;
	
	public List<TrAppointment> findUserAll() {
        return appointmentRepository.findAll();
    }

    public TrAppointment findUserById(long id) {
        return appointmentRepository.findById(id).get();
    }
    
//    public AppointmentModel findAppointmentmodelAllWithPaging() {
//		MsUser appointmentTb = userRepository.getById(id);
//
//		appointmentDTO appointmentDTO = new appointmentDTO();
//		appointmentDTO.setId(appointmentTb.getId());
//		appointmentDTO.setTitle(appointmentTb.getTitle());
//		appointmentDTO.setFirstName(appointmentTb.getFirstName());
//		appointmentDTO.setLastName(appointmentTb.getLastName());
//		appointmentDTO.setEmail(appointmentTb.getEmail());
//		appointmentDTO.setPassword(appointmentTb.getPassword());
//		appointmentDTO.setTel(appointmentTb.getTel());
//		appointmentDTO.setAddress(appointmentTb.getAddress());
//		appointmentDTO.setUser_type(appointmentTb.getUser_type());
//
//		return appointmentDTO;
//	}
    
//    public Page<AppointmentDTO> findAppointmentByCustomerId(Long customerId, Integer pageNo, Integer pageSize) {
//		Pageable paging = PageRequest.of(pageNo, pageSize);
//		return appointmentRepository.findAppointmentByCustomerId(customerId, paging);
//	}
    
    public List<AppointmentDTO> findAppointmentDTOByUserId(Long customerId, Integer pageNo, Integer pageSize) {
        List<AppointmentDTO> appointmentDTOList = new ArrayList<AppointmentDTO>();
        
        for (TrAppointment appointmentTb : appointmentRepository.findAppointmentByCustomerId(customerId)) {

            AppointmentDTO appointmentDTO = new AppointmentDTO();
            BarberShopModel barbershopModel = new BarberShopModel();
            UserModel customerModel = new UserModel();
            UserModel hairdresserModel = new UserModel();

            appointmentDTO.setId(appointmentTb.getId());
            appointmentDTO.setTimeSelected(appointmentTb.getTimeSelected());
            appointmentDTO.setDateSelected(appointmentTb.getDateSelected());
            appointmentDTO.setStatus(appointmentTb.getStatus());

            MsBarberShop barberTb = barberShopRepository.getById(appointmentTb.getBarbershopId().getId());
            MsUser customerTb = userRepository.getById(appointmentTb.getCustomerId().getId());
            MsUser hairdresserTb = userRepository.getById(appointmentTb.getHairdresserSelectedId().getId());
            
            barbershopModel.setId(barberTb.getId());
            barbershopModel.setName(barberTb.getName());
            barbershopModel.setAddress(barberTb.getAddress());
            barbershopModel.setTel(barberTb.getTel());
            barbershopModel.setBarberOwnerId(barberTb.getBarberOwnerId().getId());
            
            customerModel.setId(customerTb.getId());
            customerModel.setTitle(customerTb.getTitle());
            customerModel.setFirstName(customerTb.getFirstName());
            customerModel.setLastName(customerTb.getLastName());
            customerModel.setEmail(customerTb.getEmail());
            customerModel.setPassword(customerTb.getPassword());
            customerModel.setTel(customerTb.getTel());
            customerModel.setAddress(customerTb.getAddress());
            customerModel.setUser_type(customerTb.getUser_type());
            
            hairdresserModel.setId(hairdresserTb.getId());
            hairdresserModel.setTitle(hairdresserTb.getTitle());
            hairdresserModel.setFirstName(hairdresserTb.getFirstName());
            hairdresserModel.setLastName(hairdresserTb.getLastName());
            hairdresserModel.setEmail(hairdresserTb.getEmail());
            hairdresserModel.setPassword(hairdresserTb.getPassword());
            hairdresserModel.setTel(hairdresserTb.getTel());
            hairdresserModel.setAddress(hairdresserTb.getAddress());
            hairdresserModel.setUser_type(hairdresserTb.getUser_type());
            
            appointmentDTO.setBarbershopModel(barbershopModel);
            appointmentDTO.setCustomerModel(customerModel);
            appointmentDTO.setHairdresserModel(hairdresserModel);
            
            appointmentDTOList.add(appointmentDTO);
        }
        return appointmentDTOList;
    }
    
    public Boolean addAppointment(AppointmentModel appointmentModel) {
		TrAppointment appointmentTb = new TrAppointment();
		Boolean result = false;
		try {
			System.out.println("barberId: " + appointmentModel.getBarbershopId());
			System.out.println("CustomerId: " + appointmentModel.getCustomerId());
			System.out.println("HairdresserSelectedId: " + appointmentModel.getHairdresserSelectedId());
			
			MsBarberShop barberTb = barberShopRepository.getById(appointmentModel.getBarbershopId());
			MsUser customer = userRepository.getById(appointmentModel.getCustomerId());
			MsUser hairdresserSelected = userRepository.getById(appointmentModel.getHairdresserSelectedId());
			
			System.out.println("barberTb : " + barberTb);
			System.out.println("customer : " + customer);
			System.out.println("hairdresserSelected : " + hairdresserSelected);

			appointmentTb.setTimeSelected(appointmentModel.getTimeSelected());
			appointmentTb.setDateSelected(appointmentModel.getDateSelected());
			appointmentTb.setStatus(appointmentModel.getStatus());
			appointmentTb.setBarbershopId(barberTb);
			appointmentTb.setCustomerId(customer);
			appointmentTb.setHairdresserSelectedId(hairdresserSelected);
			
			System.out.println("Appointment : ");
			System.out.println(appointmentTb.toString());
			System.out.println(appointmentTb);
			

			appointmentTb = appointmentRepository.save(appointmentTb);

			if (appointmentTb != null) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Boolean updateAppointment(AppointmentModel appointmentModel) {
		Boolean result = false;
		try {
			TrAppointment appointmentTb = appointmentRepository.getById(appointmentModel.getId());
			if (appointmentTb != null) {
				if (!ObjectUtils.isEmpty(appointmentModel.getTimeSelected())) {
					appointmentTb.setTimeSelected(appointmentModel.getTimeSelected());
				}
				if (!ObjectUtils.isEmpty(appointmentModel.getDateSelected())) {
					appointmentTb.setDateSelected(appointmentModel.getDateSelected());
				}
				if (!ObjectUtils.isEmpty(appointmentModel.getStatus())) {
					appointmentTb.setStatus(appointmentModel.getStatus());
				}
				if (!ObjectUtils.isEmpty(appointmentModel.getBarbershopId())) {
					MsBarberShop barbershop = barberShopRepository.getById(appointmentModel.getBarbershopId());
					appointmentTb.setBarbershopId(barbershop);
				}
				if (!ObjectUtils.isEmpty(appointmentModel.getCustomerId())) {
					MsUser customer = userRepository.getById(appointmentModel.getCustomerId());
					appointmentTb.setCustomerId(customer);
				}
				if (!ObjectUtils.isEmpty(appointmentModel.getHairdresserSelectedId())) {
					MsUser hairdresser = userRepository.getById(appointmentModel.getHairdresserSelectedId());
					appointmentTb.setHairdresserSelectedId(hairdresser);
				}
				appointmentTb = appointmentRepository.save(appointmentTb);
				if (appointmentTb != null) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
