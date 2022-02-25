package com.man.barber.model;


public class BarberTeamModel {
	private Long id;
	private Long barbershopId;
	private Long hairdresserId;
	
	public BarberTeamModel() {
		
	}
	
	public BarberTeamModel(Long id, Long barbershopId, Long hairdresserId) {
		super();
		this.id = id;
		this.barbershopId = barbershopId;
		this.hairdresserId = hairdresserId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBarbershopId() {
		return barbershopId;
	}

	public void setBarbershopId(Long barbershopId) {
		this.barbershopId = barbershopId;
	}

	public Long getHairdresserId() {
		return hairdresserId;
	}

	public void setHairdresserId(Long hairdresserId) {
		this.hairdresserId = hairdresserId;
	}
	
	
	
}
