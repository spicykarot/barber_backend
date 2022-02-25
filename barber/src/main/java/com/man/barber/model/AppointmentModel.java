package com.man.barber.model;

import java.util.Date;



public class AppointmentModel {
	private Long id;
	private Date timeSelected;
	private Date dateSelected;
	private String status;
	private Long barbershopId;
	private Long customerId;
	private Long hairdresserSelectedId;
	
	public AppointmentModel() {
		
	}
	
	public AppointmentModel(Long id, Date timeSelected, Date dateSelected, String status, Long barbershopId,
			Long customerId, Long hairdresserSelectedId) {
		super();
		this.id = id;
		this.timeSelected = timeSelected;
		this.dateSelected = dateSelected;
		this.status = status;
		this.barbershopId = barbershopId;
		this.customerId = customerId;
		this.hairdresserSelectedId = hairdresserSelectedId;
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

	public Long getBarbershopId() {
		return barbershopId;
	}

	public void setBarbershopId(Long barbershopId) {
		this.barbershopId = barbershopId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getHairdresserSelectedId() {
		return hairdresserSelectedId;
	}

	public void setHairdresserSelectedId(Long hairdresserSelectedId) {
		this.hairdresserSelectedId = hairdresserSelectedId;
	}
	
	
	
}
