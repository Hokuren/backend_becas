package com.me.becas.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "estratos")
@SequenceGenerator(name = "ESTRATOS_SEQUENCE", sequenceName = "SEQ_ESTRATOS_ID", initialValue = 1, allocationSize = 1)
public class Estrato implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTRATOS_SEQUENCE")
	@Column(name = "estrato_id")
	private Integer estrato_id;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
    private String nombre;
	
	
	
	private static final long serialVersionUID = 1L;

	
	
	public Integer getEstrato_id() {
		return estrato_id;
	}

	public void setEstrato_id(Integer estrato_id) {
		this.estrato_id = estrato_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}



