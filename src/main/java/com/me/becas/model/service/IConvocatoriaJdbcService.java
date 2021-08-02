package com.me.becas.model.service;

import java.util.Map;

public interface IConvocatoriaJdbcService {
	public Map<String, Object> generarBeneficiarios(Long convocatoria_id);
}
