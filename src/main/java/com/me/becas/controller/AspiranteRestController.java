package com.me.becas.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.becas.model.dao.ISolicitudBeneficiario;
import com.me.becas.model.service.IAspiranteService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class AspiranteRestController {
	
	@Autowired
	private IAspiranteService aspiranteService;
	
	//	private final Logger log = LoggerFactory.getLogger(AspiranteRestController.class);
	
	//Petición 1 //GET //aspirante/{numero_de_identifacion}/solictitud	
	//Trae los datos del aspirante para validar su estado referente a la convocatoria 
	@GetMapping("/aspirante/{numero_de_identificacion}/solicitud")
	public ResponseEntity<?> aspiranteCedula(@PathVariable Long numero_de_identificacion) {
		
		List<ISolicitudBeneficiario> aspirante = null;
		Map<String, Object> response = new HashMap<>();		
				
		try {
			aspirante = aspiranteService.findByNumeroDeIdentificacion(numero_de_identificacion);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (aspirante == null) {
			response.put("mensaje", "No hay una solicitud de un aspirante con numero de identicación: ".concat(numero_de_identificacion.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(aspirante, HttpStatus.OK);
	}
	
	
	//Petición 9 //GET	//convocatoria/{convocatoria_id}/beneficiarios
	//Trae todos los beneficiarios de una convocatoria especifica 
	@GetMapping("/convocatoria/{convocatoria_id}/beneficiarios") 
	public ResponseEntity<?> beneficiariosConvocatoria(@PathVariable Long convocatoria_id) {

		List<ISolicitudBeneficiario> beneficiarios = null;
		Map<String, Object> response = new HashMap<>();		
				
		try {
			beneficiarios = aspiranteService.findByAllBeneficiariosConvocatoria(convocatoria_id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (beneficiarios == null || beneficiarios.isEmpty()) {
			response.put("mensaje", "No hay una beneficiarios de la convocatoria con ID: ".concat(convocatoria_id.toString()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(beneficiarios, HttpStatus.OK);
	}
}
