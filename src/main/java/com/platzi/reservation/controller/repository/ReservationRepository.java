package com.platzi.reservation.controller.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.reservation.model.ReservationDTO;

public interface ReservationRepository extends JpaRepository<ReservationDTO, String> {

	@Query("Select r from ReservationDTO r where r.admisionDate =:admisionDate and r.depurateDate =:depurateDate")
	public List<ReservationDTO> find(@Param("admisionDate") Date admisionDate, @Param("depurateDate") Date depurateDate);
	
}
