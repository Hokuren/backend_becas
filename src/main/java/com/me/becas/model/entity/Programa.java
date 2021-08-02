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
@Table(name = "programas")
@SequenceGenerator(name = "PROGRAMAS_SEQUENCE", sequenceName = "SEQ_PROGRAMAS_ID", initialValue = 1, allocationSize = 1)
public class Programa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROGRAMAS_SEQUENCE")
	@Column(name = "programa_id")
	private Long programa_id;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String nombre;

	private static final long serialVersionUID = 1L;

	public Long getPrograma_id() {
		return programa_id;
	}

	public void setPrograma_id(Long programa_id) {
		this.programa_id = programa_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
