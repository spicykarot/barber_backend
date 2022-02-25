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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TR_BARBERTEAM")
@XmlRootElement
public class TrBarberTeam {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false, updatable = true)
    private Long id;
    
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "BARBERSHOP_ID", referencedColumnName = "id", nullable = false)
    private MsBarberShop barbershopId;
	
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "HAIRDRESSER_ID", referencedColumnName = "id")
    private MsUser hairdresserId;
    
    public TrBarberTeam() {
    	
    }
    
	public TrBarberTeam(Long id, MsBarberShop barbershopId, MsUser hairdresserId) {
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

	public MsBarberShop getBarbershopId() {
		return barbershopId;
	}

	public void setBarbershopId(MsBarberShop barbershopId) {
		this.barbershopId = barbershopId;
	}

	public MsUser getHairdresserId() {
		return hairdresserId;
	}

	public void setHairdresserId(MsUser hairdresserId) {
		this.hairdresserId = hairdresserId;
	}
	
	
	
    
}
