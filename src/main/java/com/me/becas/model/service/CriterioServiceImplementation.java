package com.me.becas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.me.becas.model.dao.ICriterioDao;
import com.me.becas.model.entity.Criterio;

@Service
public class CriterioServiceImplementation implements ICriterioService {

	@Autowired
	private ICriterioDao criterioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Criterio> findAll() {
		return (List<Criterio>) criterioDao.findAll();
	}

}
