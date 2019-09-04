package com.platzi.reservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="reservation")
public class ReservationDTO {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid2")
	private String reservationkey;
	@Temporal(TemporalType.DATE)
	private Date admisionDate;
	@Temporal(TemporalType.DATE)
	private Date depurateDate;
	private Integer amountPeople;
	
	@ManyToOne
	@JoinColumn(name = "clientkey")
	private ClientDTO client;

}
