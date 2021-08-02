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
@Table(name = "criterios")
@SequenceGenerator(name = "CRITERIOS_SEQUENCE", sequenceName = "SEQ_CRITERIOS_ID", initialValue = 1, allocationSize = 1)
public class Criterio implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTES_SEQUENCE")
	@Column(name = "criterio_id")
	private Long criterio_id;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String nombre;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false ,columnDefinition = "VARCHAR2(30) NOT NULL CHECK (status IN ('RANGO', 'MULTIPLE','BOOLEANO')")
	private String tipo_de_criterio;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String valor_uno;

	@NotEmpty(message = "no puede estar vacio")
	@Column(nullable = false)
	private String valor_dos;

	private static final long serialVersionUID = 1L;

	public Long getCriterio_id() {
		return criterio_id;
	}

	public void setCriterio_id(Long criterio_id) {
		this.criterio_id = criterio_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo_de_criterio() {
		return tipo_de_criterio;
	}

	public void setTipo_de_criterio(String tipo_de_criterio) {
		this.tipo_de_criterio = tipo_de_criterio;
	}

	public String getValor_uno() {
		return valor_uno;
	}

	public void setValor_uno(String valor_uno) {
		this.valor_uno = valor_uno;
	}

	public String getValor_dos() {
		return valor_dos;
	}

	public void setValor_dos(String valor_dos) {
		this.valor_dos = valor_dos;
	}
}
