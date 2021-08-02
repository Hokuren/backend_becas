package com.me.becas.model.entity;

import java.io.Serializable;
//import java.util.Date;

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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity                                                                                                                     
@Table(name = "respuestas",
indexes = { 
		@Index(name = "I_RESPUESTAS_SOLICITUDES", columnList = "solicitud_id"),
		@Index(name = "I_RESPUESTAS_CRITERIOS", columnList = "criterio_id")
},
uniqueConstraints = { @UniqueConstraint(name = "UK_RESPUESTAS_SOLICITUDES", columnNames = { "solicitud_id", "criterio_id" }) } )
@SequenceGenerator(name = "RESPUESTAS_SEQUENCE", sequenceName = "SEQ_RESPUESTAS_ID", initialValue = 1, allocationSize = 1)  
public class Respuesta implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTES_SEQUENCE")
	private Long solicitud_id;
	
	@Column(nullable = false)
	private Long respuesta_id;
	
	@Column(nullable = false)
	private Long criterio_id;
	
	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String respuesta;
	
	@NotNull(message = "la solicitud no puede ser vacia")                     
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name="FK_RESPUESTAS_SOLICITUDES"), name = "solicitud_id", referencedColumnName="solicitud_id", insertable=false, updatable=false)                              
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })       
	private Solicitud solicitud; 
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	public Long getSolicitud_id() {
		return solicitud_id;
	}

	public void setSolicitud_id(Long solicitud_id) {
		this.solicitud_id = solicitud_id;
	}

	public Long getRespuesta_id() {
		return respuesta_id;
	}

	public void setRespuesta_id(Long respuesta_id) {
		this.respuesta_id = respuesta_id;
	}

	public Long getCriterio_id() {
		return criterio_id;
	}

	public void setCriterio_id(Long criterio_id) {
		this.criterio_id = criterio_id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}  

}                                                                              





































