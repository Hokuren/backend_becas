package com.me.becas.model.service;

import java.util.List;

import com.me.becas.model.dao.ISolicitudBeneficiario;



public interface IAspiranteService {
		
	public List<ISolicitudBeneficiario> findByNumeroDeIdentificacion(Long numero_de_identificacion);
	
	public List<ISolicitudBeneficiario> findByAllBeneficiariosConvocatoria(Long convocatoria_id);

}
