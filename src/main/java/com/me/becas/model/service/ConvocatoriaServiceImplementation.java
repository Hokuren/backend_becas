package com.me.becas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.me.becas.model.dao.IConvocatoriaDao;
import com.me.becas.model.dao.IConvocatoriaSimpleDao;
import com.me.becas.model.entity.Convocatoria;

@Service
public class ConvocatoriaServiceImplementation implements IConvocatoriaService {
	
	@Autowired
	private IConvocatoriaDao convocatoriaDao;

	@Override
	@Transactional(readOnly = true)
	public Convocatoria findById(Long id) {
		return convocatoriaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Convocatoria save(Convocatoria convocatoria) {
		return convocatoriaDao.save(convocatoria);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<IConvocatoriaSimpleDao> findByAllConvocatorias() {
		return convocatoriaDao.findByAllConvocatorias();
	}
}
