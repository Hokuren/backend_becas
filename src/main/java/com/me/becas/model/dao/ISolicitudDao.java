package com.me.becas.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.me.becas.model.entity.Solicitud;


public interface ISolicitudDao extends JpaRepository<Solicitud, Long>  {
	

}
