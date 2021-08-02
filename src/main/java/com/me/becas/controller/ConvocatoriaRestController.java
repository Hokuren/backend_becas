package com.me.becas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.becas.model.dao.IConvocatoriaSimpleDao;
import com.me.becas.model.entity.Convocatoria;
import com.me.becas.model.service.IConvocatoriaJdbcService;
import com.me.becas.model.service.IConvocatoriaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ConvocatoriaRestController {
	
	@Autowired
	private IConvocatoriaService convocatoriaService;
	
	@Autowired
	private IConvocatoriaJdbcService convocatoriaJdbcService;
	
	private final Logger log = LoggerFactory.getLogger(ConvocatoriaRestController.class);
	
	
	//Petición 6 //GET //convocatoria/{convocatoria_id}
	@GetMapping("/convocatoria/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Convocatoria convocatoria = null;
		
		Map<String, Object> response = new HashMap<>();
	
		try {
			convocatoria = convocatoriaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		if (convocatoria == null) {
			response.put("mensaje", "La convocatoria ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Convocatoria>(convocatoria, HttpStatus.OK);
	}
	
	
	//Petición 7 //PUT //convocatoria/{convocatoria_id}	
	@PutMapping("/convocatoria/{id}")
	public ResponseEntity<?> Update(@Valid @RequestBody Convocatoria convocatoria, BindingResult result, @PathVariable() Long id){
	
		Convocatoria convocatoriaActual = convocatoriaService.findById(id);
		Convocatoria convocatoriaActualizada = null;
		
		Map<String, Object> response = new HashMap<>();
		log.info("**********" + id + "**********");
		
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (convocatoriaActual == null) {
			response.put("mensaje", "Error: no se puedo editar, la convocatoria con ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			convocatoriaActualizada = convocatoriaService.save(convocatoria);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al actualizar la convocatoria en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
		}
		response.put("mensaje", "La convocatoria ha sido actualizada con éxito!");
		//response.put("convocatoria", convocatoriaActualizada);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	//Petición 8 //POST	//convocatoria/{convocatoria_id}/generar_beneficiaros
	//genera los beneficiarios y rechazados de una respectiva convocatoria
	@PostMapping("/convocatoria/{convocatoria_id}/generar_beneficiaros")
	public ResponseEntity<?> updateBeneficiariosConvocatoria(@PathVariable Long convocatoria_id) {
	
		Map<String, Object> response = new HashMap<>();
	
		try {
			response = convocatoriaJdbcService.generarBeneficiarios(convocatoria_id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	//Petición 10 //GET //convocatorias	 
	//Trae el listado de las convocatorias
	@GetMapping("/convocatorias")
	public List<IConvocatoriaSimpleDao> index() {
		return convocatoriaService.findByAllConvocatorias();
	}
		
}
