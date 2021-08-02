package com.me.becas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.becas.model.entity.Criterio;
import com.me.becas.model.service.ICriterioService;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class CriterioRestController {
	
	@Autowired
	private ICriterioService criterioService;
	
	//	private final Logger log = LoggerFactory.getLogger(CriterioRestController.class);
	
	//Petición 2 //GET //criterios
	// Trae el listado de los criterios
	@GetMapping("/criterios")
	public List<Criterio> index() {
		return criterioService.findAll();
	}
	


}
