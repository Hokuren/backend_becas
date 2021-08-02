package com.me.becas.model.service;

import java.sql.Types;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;


@Service
public class ConvocatoriaJdbcImplementation implements IConvocatoriaJdbcService {
	
	private static final String nombrePaquete= "DBO_CONVOCATORIA";
	private static final String nombreProcedimiento= "SP_ASPIRANTES_CONVOCATORIA";
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ConvocatoriaJdbcImplementation(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Map<String, Object> generarBeneficiarios(Long convocatoria_id) {
		
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withCatalogName(nombrePaquete)
				.withProcedureName(nombreProcedimiento)
				.declareParameters(
						new SqlParameter("convocatoria_id",Types.NUMERIC)
				);
		Map<String, Object> resultado = jdbcCall.execute(convocatoria_id);
		
		System.out.println(resultado);
		
		return resultado;
	}

}
