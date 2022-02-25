package com.man.barber.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.entity.MsUser;
import com.man.barber.entity.TrAppointment;
import com.man.barber.model.AppointmentDTO;
import com.man.barber.model.BarberShopModel;

public interface AppointmentRepository extends JpaRepository<TrAppointment,Long>{
	
	public List<TrAppointment> findAll();

	@Query("select a "
			+ "from TrAppointment a "
			+ "where a.customerId.id = :customerId  "
			+ "ORDER BY a.dateSelected DESC, a.timeSelected DESC, a.id ASC")
	List<TrAppointment> findAppointmentByCustomerId(@Param("customerId") Long customerId);
	
//	@Query("select new com.man.barber.model.AppointmentDTO("
//			+ "a.id "
//			+ ",a.timeSelected "
//			+ ",a.dateSelected "
//			+ ",a.status "
//			+ ",a.barbershopId "
//			+ ",a.customerId "
//			+ ",a.hairdresserSelectedId ) "
//			+ "from TrAppointment a "
//			+ "where a.customerId.id = :customerId  "
//			+ "ORDER BY a.dateSelected DESC, a.timeSelected DESC, a.id ASC")
//	Page<AppointmentDTO> findAppointmentByCustomerId(@Param("customerId") Long customerId, Pageable pageable);
	
	
	
	
	
	
}
