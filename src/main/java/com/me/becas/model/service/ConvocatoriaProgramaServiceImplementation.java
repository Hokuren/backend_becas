package com.me.becas.model.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.me.becas.model.dao.IConvocatoriaProgramaDao;

@Service
public class ConvocatoriaProgramaServiceImplementation implements IConvocatoriaProgramaService {
	
	@Autowired
	private IConvocatoriaProgramaDao convocatoriaProgramaDao;
	
	@Override
	@Transactional
	public void deleteByConvocatoriaProgramaCriterio(Long convocatoria_id, Long programa_id, Long criterio_id) {
		convocatoriaProgramaDao.deleteByConvocatoriaProgramaCriterio(convocatoria_id, programa_id, criterio_id);
	}

	@Override
	@Transactional
	public void deleteByConvocatoriaPrograma(Long convocatoria_id, Long programa_id) {
		convocatoriaProgramaDao.deleteByConvocatoriaPrograma(convocatoria_id, programa_id);
	}



	

}
