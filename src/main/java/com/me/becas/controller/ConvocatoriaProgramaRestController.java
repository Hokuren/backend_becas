package com.me.becas.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.becas.model.service.IConvocatoriaProgramaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ConvocatoriaProgramaRestController {
	
	@Autowired 
	private IConvocatoriaProgramaService convocatoriaProgramaService;
	
	private final Logger log = LoggerFactory.getLogger(ConvocatoriaProgramaRestController.class);
	
	//Petición 4 //DELETE //eliminar/convocatoria/programa/criterio
	//Permite eliminar los criterios que no se van a emplear en programa 
	@DeleteMapping("/eliminar/convocatoria/{convocatoria_id}/programa/{programa_id}/criterio/{criterio_id}")
	public ResponseEntity<?> deleteCriterio(@PathVariable Long convocatoria_id, @PathVariable Long programa_id, @PathVariable Long criterio_id){
		Map<String, Object> response = new HashMap<>();
		log.info("**********" + convocatoria_id + "**********");
		log.info("**********" + programa_id + "**********");
		log.info("**********" + criterio_id + "**********");
		try	{
			convocatoriaProgramaService.deleteByConvocatoriaProgramaCriterio(convocatoria_id, programa_id, criterio_id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el criterio en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El criterio ha sido eliminado de la convocatoria con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	//Petición 5 //DELETE //eliminar/convocatoria/{convocatoria_id}/programa/{programa_id}
	//Permite eliminar un programa asociado a una convocatoria
	@DeleteMapping("/eliminar/convocatoria/{convocatoria_id}/programa/{programa_id}")
	public ResponseEntity<?> deletePrograma(@PathVariable Long convocatoria_id, @PathVariable Long programa_id){
		Map<String, Object> response = new HashMap<>();
		log.info("**********" + convocatoria_id + "**********");
		log.info("**********" + programa_id + "**********");
		try	{
			convocatoriaProgramaService.deleteByConvocatoriaPrograma(convocatoria_id, programa_id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar el programa en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El programa ha sido eliminado de la convocatoria con éxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
