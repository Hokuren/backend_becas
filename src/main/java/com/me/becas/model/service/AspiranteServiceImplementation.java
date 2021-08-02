package com.me.becas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.me.becas.model.dao.IAspiranteDao;
import com.me.becas.model.dao.ISolicitudBeneficiario;


@Service
public class AspiranteServiceImplementation implements IAspiranteService {

	@Autowired 
	private IAspiranteDao aspiranteDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<ISolicitudBeneficiario> findByNumeroDeIdentificacion(Long numero_de_identificacion) {
		return aspiranteDao.findByNumeroDeIdentificacion(numero_de_identificacion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ISolicitudBeneficiario> findByAllBeneficiariosConvocatoria(Long convocatoria_id) {
		return aspiranteDao.findByAllBeneficiariosConvocatoria(convocatoria_id);
	}

}
