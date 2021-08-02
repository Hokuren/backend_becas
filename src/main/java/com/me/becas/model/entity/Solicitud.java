package com.me.becas.model.entity;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "solicitudes",
	indexes = { 
			@Index(name="I_SOLICITUDES_CONVOCATORIAS", columnList = "convocatoria_id" ),
			@Index(name="I_SOLICITUDES_ASPIRANTES", columnList = "aspirante_id" ),
			@Index(name="I_SOLICITUDES_FECHA_SOLICITUD", columnList = "fecha_solicitud" ),
})
@SequenceGenerator(name = "SOLICITUDES_SEQUENCE", sequenceName = "SEQ_SOLICITUDES_ID", initialValue = 1, allocationSize = 1)
public class Solicitud implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOLICITUDES_SEQUENCE")
	@Column(name = "solicitud_id")
	private Long solicitud_id;
	
	@Column(nullable = false)
	private Long aspirante_id;
	
	@Column(nullable = false)
	private Long convocatoria_id;
	
	@NotNull(message = "El programa no puede ser vacio")
	private Integer programa_id;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_solicitud;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false ,columnDefinition = "VARCHAR2(30) NOT NULL CHECK (status IN ('PENDIENTE', 'BENEFICIARIO','RECHAZADO')")
	private String estado; 
	
	@Column(nullable = false)
	private Long valor_matricula;
	
	@Column(nullable = false)
	private Long valor_cubierto_beca;
	
	@NotNull(message = "El aspirante no puede ser vacio")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name="FK_SOLICITUDES_ASPIRANTES"), name="aspirante_id",referencedColumnName="aspirante_id", insertable=false, updatable=false )
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Aspirante aspirante;
	
	@NotNull(message = "La convocatoria no puede ser vacia")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name="FK_SOLICITUDES_CONVOCATORIAS"), name="convocatoria_id",referencedColumnName="convocatoria_id", insertable=false, updatable=false )
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Convocatoria convocatoira;
	
	
	
	private static final long serialVersionUID = 1L;
	
	

	public Long getSolicitud_id() {
		return solicitud_id;
	}

	public void setSolicitud_id(Long solicitud_id) {
		this.solicitud_id = solicitud_id;
	}

	public Long getAspirante_id() {
		return aspirante_id;
	}

	public void setAspirante_id(Long aspirantes_id) {
		this.aspirante_id = aspirantes_id;
	}

	public Long getConvocatoria_id() {
		return convocatoria_id;
	}

	public void setConvocatoria_id(Long convocatoria_id) {
		this.convocatoria_id = convocatoria_id;
	}

	public Integer getPrograma_id() {
		return programa_id;
	}

	public void setPrograma_id(Integer programa_id) {
		this.programa_id = programa_id;
	}

	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}

	public void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Aspirante getAspirante() {
		return aspirante;
	}

	public void setAspirante(Aspirante aspirante) {
		this.aspirante = aspirante;
	}

	public Convocatoria getConvocatoira() {
		return convocatoira;
	}

	public void setConvocatoira(Convocatoria convocatoira) {
		this.convocatoira = convocatoira;
	}

	

}
