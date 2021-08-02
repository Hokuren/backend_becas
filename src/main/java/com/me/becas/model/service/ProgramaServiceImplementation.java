package com.me.becas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.me.becas.model.dao.IProgramaDao;
import com.me.becas.model.entity.Programa;


@Service
public class ProgramaServiceImplementation implements IProgramaService {
	
	@Autowired
	private IProgramaDao programaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Programa> findAll() {
		return (List<Programa>) programaDao.findAll();
	}
	
	
	 
}
