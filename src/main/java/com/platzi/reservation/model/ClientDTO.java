package com.platzi.reservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "client")
@NamedQuery(name = "ClientDTO.findByIdentification", query = "Select c from ClientDTO c where c.identification = ?1")
public class ClientDTO {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	private String clientkey;
	private String name;
	private String lastname;
	private String identification;
	private String address;
	private String telephone;
	private String email;
	
	@OneToMany(mappedBy = "client")
	private Set<ReservationDTO> reservas;
}
