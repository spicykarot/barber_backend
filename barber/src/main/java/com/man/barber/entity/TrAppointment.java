package com.man.barber.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TR_APPOINTMENT")
@XmlRootElement
public class TrAppointment {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "TIMESELECTED", length = 255)
    private Date timeSelected;
    @Column(name = "DATESELECTED", length = 255)
    private Date dateSelected;
    @Column(name = "STATUS", length = 255)
    private String status;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "BARBERSHOP_ID", referencedColumnName = "id", nullable = false)
    private MsBarberShop barbershopId;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "id", nullable = false)
    private MsUser customerId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "HAIRDRESSERSELECTED_ID", referencedColumnName = "id", nullable = false)
    private MsUser hairdresserSelectedId;
    
    public TrAppointment() {
    	
    }
    
	public TrAppointment(Long id, Date timeSelected, Date dateSelected, String status, MsBarberShop barbershopId,
			MsUser customerId, MsUser hairdresserSelectedId) {
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

	public MsBarberShop getBarbershopId() {
		return barbershopId;
	}

	public void setBarbershopId(MsBarberShop barbershopId) {
		this.barbershopId = barbershopId;
	}

	public MsUser getCustomerId() {
		return customerId;
	}

	public void setCustomerId(MsUser customerId) {
		this.customerId = customerId;
	}

	public MsUser getHairdresserSelectedId() {
		return hairdresserSelectedId;
	}

	public void setHairdresserSelectedId(MsUser hairdresserSelectedId) {
		this.hairdresserSelectedId = hairdresserSelectedId;
	}
    

    
    
    
}
