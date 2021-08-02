package com.me.becas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.becas.model.entity.Programa;
import com.me.becas.model.service.IProgramaService;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProgramaRestController {
	
	@Autowired
	private IProgramaService programaService;
	
	//	private final Logger log = LoggerFactory.getLogger(ProgramaRestController.class);
	
	//Petición 3 //GET //programas
	//Trae el listado de los programas
	@GetMapping("/programas")
	public List<Programa> index(){
		return programaService.findAll();
	}
}
