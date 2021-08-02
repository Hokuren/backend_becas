package com.me.becas.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "aspirantes",
	indexes = { @Index(name = "I_ASPIRANTES_NUMERO_DE_INDENTIFICACION", columnList = "numero_de_identificacion")},
	uniqueConstraints = { @UniqueConstraint(name = "UK_TIPO_DOC_INDENTIFICACION", columnNames = { "tipo_de_documento", "numero_de_identificacion" }) } )
@SequenceGenerator(name = "ASPIRANTES_SEQUENCE", sequenceName = "SEQ_ASPIRANTES_ID", initialValue = 1, allocationSize = 1)
public class Aspirante implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASPIRANTES_SEQUENCE")
	@Column(name = "aspirante_id")
	private Long aspirante_id;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String tipo_de_documento;

	@Column(nullable = false)
	private Long numero_de_identificacion;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String nombre;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String apellido;


	@Column(nullable = false)
	private Long estrato_id;
	
	
	
	private static final long serialVersionUID = 1L;
	
	

	public Long getAspirante_id() {
		return aspirante_id;
	}

	public void setAspirante_id(Long aspirantes_id) {
		this.aspirante_id = aspirantes_id;
	}

	public String getTipo_de_documento() {
		return tipo_de_documento;
	}

	public void setTipo_de_documento(String tipo_de_documento) {
		this.tipo_de_documento = tipo_de_documento;
	}

	public Long getNumero_de_identificacion() {
		return numero_de_identificacion;
	}

	public void setNumero_de_identificacion(Long numero_de_identificacion) {
		this.numero_de_identificacion = numero_de_identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getEstrato_id() {
		return estrato_id;
	}

	public void setEstrato_id(Long estrato_id) {
		this.estrato_id = estrato_id;
	}


	

}
