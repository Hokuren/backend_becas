package com.me.becas.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "estrato_asignaciones",
	indexes = { 
			@Index(name = "I_ESTRATO_ASIGNACIONES_ESTRATOS", columnList = "estrato_id"),
			@Index(name = "I_ESTRATO_ASIGNACIONES_ASIGNACIONES", columnList = "asignacion_id")
})
@SequenceGenerator(name = "ESTRATO_ASIGNACIONES_SEQUENCE", sequenceName = "SEQ_ESTRATO_ASIGNACIONES_ID", initialValue = 1, allocationSize = 1)
public class EstratoAsignacion implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTRATO_ASIGNACIONES_SEQUENCE")
	@Column(name = "estra_asigna_id")
	private Long estra_asigna_id;
	
	@Column(nullable = false)
	private Integer estrato_id;
	
	@Column(nullable = false)
	private Long asignacion_id;
	
	@NotNull(message = "El estrato no puede ser vacio")
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name="FK_ESTRATO_ASIGNACIONES_ESTRATO"), name = "estrato_id", referencedColumnName="estrato_id", insertable=false, updatable=false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Estrato estrato;
	
	@NotNull(message = "La asignacion no puede ser vacia")
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name="FK_ESTRATO_ASIGNACIONES_ASIGNACIONES"), name = "asignacion_id", referencedColumnName="asignacion_id", insertable=false, updatable=false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Asignacion asignacion;
	
	
	
	private static final long serialVersionUID = 1L;

	
	
	public Long getEstra_asigna_id() {
		return estra_asigna_id;
	}

	public void setEstra_asigna_id(Long estra_asigna_id) {
		this.estra_asigna_id = estra_asigna_id;
	}

	public Integer getEstrato_id() {
		return estrato_id;
	}

	public void setEstrato_id(Integer estrato_id) {
		this.estrato_id = estrato_id;
	}

	public Long getAsignacion_id() {
		return asignacion_id;
	}

	public void setAsignacion_id(Long asignacion_id) {
		this.asignacion_id = asignacion_id;
	}
	
	public Estrato getEstrato() {
		return estrato;
	}

	public void setEstrato(Estrato estrato) {
		this.estrato = estrato;
	}

	public Asignacion getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}
	
}

