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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "MS_USER")
@XmlRootElement
public class MsUser {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "TITLE", length = 25)
    private String title;
    @Column(name = "FIRST_NAME", length = 255)
    private String firstName;
    @Column(name = "LAST_NAME", length = 255)
    private String lastName;
    @Column(name = "EMAIL", length = 255)
    private String email;
    @Column(name = "PASSWORD", length = 256)
    private String password;
    @Column(name = "TEL", length = 256)
    private String tel;
    @Column(name = "ADDRESS", length = 256)
    private String address;
    @Column(name = "USER_TYPE")
    private int user_type;
    
    @OneToOne(mappedBy = "barberOwnerId")
    private MsBarberShop barbershop;
    
    @OneToOne(mappedBy = "hairdresserId")
    private TrBarberTeam barberteam;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId", fetch = FetchType.LAZY)
    private List<TrAppointment> customerAppointment;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hairdresserSelectedId", fetch = FetchType.LAZY)
    private List<TrAppointment> hairdresserAppointment;

    public MsUser() {
    	
    }
    

	public MsUser(Long id, String title, String firstName, String lastName, String email, String password, String tel,
			String address, int user_type, MsBarberShop barbershop, TrBarberTeam barberteam,
			List<TrAppointment> customerAppointment, List<TrAppointment> hairdresserAppointment) {
		super();
		this.id = id;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.address = address;
		this.user_type = user_type;
		this.barbershop = barbershop;
		this.barberteam = barberteam;
		this.customerAppointment = customerAppointment;
		this.hairdresserAppointment = hairdresserAppointment;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public MsBarberShop getBarbershop() {
		return barbershop;
	}

	public void setBarbershop(MsBarberShop barbershop) {
		this.barbershop = barbershop;
	}

	public TrBarberTeam getBarberteam() {
		return barberteam;
	}

	public void setBarberteam(TrBarberTeam barberteam) {
		this.barberteam = barberteam;
	}

	public List<TrAppointment> getCustomerAppointment() {
		return customerAppointment;
	}

	public void setCustomerAppointment(List<TrAppointment> customerAppointment) {
		this.customerAppointment = customerAppointment;
	}

	public List<TrAppointment> getHairdresserAppointment() {
		return hairdresserAppointment;
	}

	public void setHairdresserAppointment(List<TrAppointment> hairdresserAppointment) {
		this.hairdresserAppointment = hairdresserAppointment;
	}
    
	
}
