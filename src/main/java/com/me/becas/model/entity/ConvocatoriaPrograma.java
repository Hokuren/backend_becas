package com.me.becas.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "convocatoria_programas", indexes = {
		@Index(name = "I_CONVOCATORIA_PROGRAMAS_CONVOCATORIA", columnList = "convocatoria_id"),
		@Index(name = "I_CONVOCATORIA_PROGRAMAS_PROGRAMAS", columnList = "programa_id"),
		@Index(name = "I_CONVOCATORIA_PROGRAMAS_CRITERIOS", columnList = "criterio_id") })
@SequenceGenerator(name = "CONVOCATORIA_PROGRAMAS_SEQUENCE", sequenceName = "SEQ_CONVOCATORIA_PROGRAMAS_ID", initialValue = 1, allocationSize = 1)
public class ConvocatoriaPrograma implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONVOCATORIA_PROGRAMAS_SEQUENCE")
	@Column(name = "convo_progra_id")
	private Long convo_progra_id;

	@Column(nullable = false, name="convocatoria_id")
	private Long convocatoria_id;

	@Column(nullable = false, name="programa_id")
	private Long programa_id;

	@Column(nullable = false, name="criterio_id")
	private Long criterio_id;

	@Column(nullable = false)
	private Long peso_criterio;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_CONVOCATORIA_PROGRAMAS_CONVOCATORIAS"), name = "convocatoria_id", referencedColumnName = "convocatoria_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "lista_programas", "hibernateLazyInitializer", "handler" })
	private Convocatoria convocatoria;

	@ManyToOne(optional = false, fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_CONVOCATORIA_PROGRAMAS_PROGRAMAS"), name = "programa_id", referencedColumnName = "programa_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Programa programa;

	@ManyToOne(optional = true, fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_CONVOCATORIA_PROGRAMAS_CRITERIOS"), name = "criterio_id", referencedColumnName = "criterio_id", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Criterio criterio;

	private static final long serialVersionUID = 1L;

	public Long getConvo_progra_id() {
		return convo_progra_id;
	}

	public void setConvo_progra_id(Long convo_progra_id) {
		this.convo_progra_id = convo_progra_id;
	}

	public Long getConvocatoria_id() {
		return convocatoria_id;
	}

	public void setConvocatoria_id(Long convocatoria_id) {
		this.convocatoria_id = convocatoria_id;
	}

	public Long getPrograma_id() {
		return programa_id;
	}

	public void setPrograma_id(Long programa_id) {
		this.programa_id = programa_id;
	}

	public Long getCriterio_id() {
		return criterio_id;
	}

	public void setCriterio_id(Long criterio_id) {
		this.criterio_id = criterio_id;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public void setConvocatoria(Convocatoria convocatoria) {
		this.convocatoria = convocatoria;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Criterio getCriterio() {
		return criterio;
	}

	public void setCriterio(Criterio criterio) {
		this.criterio = criterio;
	}

	public Long getPeso_criterio() {
		return peso_criterio;
	}

	public void setPeso_criterio(Long peso_criterio) {
		this.peso_criterio = peso_criterio;
	}

	@Override
	public String toString() {
		return "ConvocatoriaPrograma [convo_progra_id=" + convo_progra_id + ", convocatoria_id=" + convocatoria_id
				+ ", programa_id=" + programa_id + ", criterio_id=" + criterio_id + ", peso_criterio=" + peso_criterio
				+ ", programa=" + programa + ", criterio=" + criterio + "]";
	}
	
	
}
