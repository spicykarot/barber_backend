package com.man.barber.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "MS_BARBERSHOP")
@XmlRootElement
public class MsBarberShop {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "NAME", length = 25)
    private String name;
    @Column(name = "ADDRESS", length = 255)
    private String address;
    @Column(name = "TEL", length = 255)
    private long tel;
    @Column(name = "IMAGE", length = 255)
    private String image;
    
    @Basic(optional = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BARBEROWNER_ID", referencedColumnName = "id")
    private MsUser barberOwnerId;
    
    @OneToMany(mappedBy = "barbershopId", fetch = FetchType.LAZY)
    private List<TrBarberTeam> barberteam;
    
    @OneToMany(mappedBy = "barbershopId", fetch = FetchType.LAZY )
    private List<TrAppointment> appointment;
    
    public MsBarberShop() {
    	
    }
    
	public MsBarberShop(Long id, String name, String address, long tel, String image, MsUser barberOwnerId,
			List<TrBarberTeam> barberteam, List<TrAppointment> appointment) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.image = image;
		this.barberOwnerId = barberOwnerId;
		this.barberteam = barberteam;
		this.appointment = appointment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public MsUser getBarberOwnerId() {
		return barberOwnerId;
	}

	public void setBarberOwnerId(MsUser barberOwnerId) {
		this.barberOwnerId = barberOwnerId;
	}

	public List<TrBarberTeam> getBarberteam() {
		return barberteam;
	}

	public void setBarberteam(List<TrBarberTeam> barberteam) {
		this.barberteam = barberteam;
	}

	public List<TrAppointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<TrAppointment> appointment) {
		this.appointment = appointment;
	}
	
	
    
    
}
