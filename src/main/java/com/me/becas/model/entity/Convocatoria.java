package com.me.becas.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "convocatorias")
@SequenceGenerator(name = "CONVOCATORIAS_SEQUENCE", sequenceName = "SEQ_CONVOCATORIAS_ID", initialValue = 1, allocationSize = 1)
public class Convocatoria implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONVOCATORIAS_SEQUENCE")
	@Column(name = "convocatoria_id", nullable = false)
	private Long convocatoria_id;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private Long monto;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_inicio;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_fin;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false, columnDefinition = "VARCHAR2(10) NOT NULL CHECK (estado IN ('OCULTA', 'PUBLICADA','CERRADA')")
	private String estado;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "convocatoria_id")
	@JsonIgnoreProperties({ "convocatoria","programa","criterio","hibernateLazyInitializer", "handler" })
	private List<ConvocatoriaPrograma> lista_programas;

	public Convocatoria() {
		lista_programas = new ArrayList<>();
	}

	private static final long serialVersionUID = 1L;

	public Long getConvocatoria_id() {
		return convocatoria_id;
	}

	public void setConvocatoria_id(Long convocatoria_id) {
		this.convocatoria_id = convocatoria_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ConvocatoriaPrograma> getLista_programas() {
		return lista_programas;
	}

	public void setLista_programas(List<ConvocatoriaPrograma> lista_programas) {
		this.lista_programas = lista_programas;
	}


}
