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
@Table(name = "asignaciones",
	indexes = { @Index(name = "I_ASIGNACIONES_CONVOCATORIAS", columnList = "convocatoria_id")
})
@SequenceGenerator(name = "ASIGNACIONES_SEQUENCE", sequenceName = "SEQ_ASIGNACIONES_ID", initialValue = 1, allocationSize = 1)
public class Asignacion implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASIGNACIONES_SEQUENCE")
	@Column(name = "asignacion_id")
	private Long asignacion_id;
	
	@Column(name="convocatoria_id", nullable = false)
	private Long convocatoria_id; 
	
	@Column(nullable = false)
	private Long porcentaje_covertura;
	
	@Column(nullable = false)
	private Long porcentaje_monto;
	
	@NotNull(message = "la convocatoria no puede ser vacia")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
 	@JoinColumn(foreignKey = @ForeignKey(name="FK_ASIGNACIONES_CONVOCATORIAS"), name="convocatoria_id",referencedColumnName="convocatoria_id", insertable=false, updatable=false )
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Convocatoria convocatoria;
	

	private static final long serialVersionUID = 1L;
	
	
	public Long getAsignacion_id() {
		return asignacion_id;
	}

	public void setAsignacion_id(Long asignacion_id) {
		this.asignacion_id = asignacion_id;
	}

	public Long getConvocatoria_id() {
		return convocatoria_id;
	}

	public void setConvocatoria_id(Long convocatoria_id) {
		this.convocatoria_id = convocatoria_id;
	}

	public Long getPorcentaje_covertura() {
		return porcentaje_covertura;
	}

	public void setPorcentaje_covertura(Long porcentaje_covertura) {
		this.porcentaje_covertura = porcentaje_covertura;
	}

	public Long getPorcentaje_monto() {
		return porcentaje_monto;
	}

	public void setPorcentaje_monto(Long porcentaje_monto) {
		this.porcentaje_monto = porcentaje_monto;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

}

