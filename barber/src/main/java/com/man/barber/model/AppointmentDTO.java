package com.man.barber.model;

import java.util.Date;
import java.util.List;

import com.man.barber.entity.MsBarberShop;
import com.man.barber.entity.MsUser;

public class AppointmentDTO {
	private Long id;
	private Date timeSelected;
	private Date dateSelected;
	private String status;
	private BarberShopModel barbershopModel;
	private UserModel customerModel;
	private UserModel hairdresserModel;

	
	public AppointmentDTO() {
	}


	public AppointmentDTO(Long id, Date timeSelected, Date dateSelected, String status, BarberShopModel barbershopModel,
			UserModel customerModel, UserModel hairdresserModel) {
		super();
		this.id = id;
		this.timeSelected = timeSelected;
		this.dateSelected = dateSelected;
		this.status = status;
		this.barbershopModel = barbershopModel;
		this.customerModel = customerModel;
		this.hairdresserModel = hairdresserModel;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getTimeSelected() {
		return timeSelected;
	}


	public void setTimeSelected(Date timeSelected) {
		this.timeSelected = timeSelected;
	}


	public Date getDateSelected() {
		return dateSelected;
	}


	public void setDateSelected(Date dateSelected) {
		this.dateSelected = dateSelected;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public BarberShopModel getBarbershopModel() {
		return barbershopModel;
	}


	public void setBarbershopModel(BarberShopModel barbershopModel) {
		this.barbershopModel = barbershopModel;
	}


	public UserModel getCustomerModel() {
		return customerModel;
	}


	public void setCustomerModel(UserModel customerModel) {
		this.customerModel = customerModel;
	}


	public UserModel getHairdresserModel() {
		return hairdresserModel;
	}


	public void setHairdresserModel(UserModel hairdresserModel) {
		this.hairdresserModel = hairdresserModel;
	}

	
	
}
