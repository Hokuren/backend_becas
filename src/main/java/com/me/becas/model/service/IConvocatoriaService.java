package com.me.becas.model.service;



import java.util.List;

import com.me.becas.model.dao.IConvocatoriaSimpleDao;
import com.me.becas.model.entity.Convocatoria;


public interface IConvocatoriaService {
	

	
	public Convocatoria findById(Long id);
	
	public Convocatoria save(Convocatoria convocatoria);
	
	public List<IConvocatoriaSimpleDao> findByAllConvocatorias(); 
	
	
}
