package com.me.becas.model.service;

public interface IConvocatoriaProgramaService {

	public void deleteByConvocatoriaProgramaCriterio(Long convocatoria_id, Long programa_id, Long criterio_id);
			
	public void deleteByConvocatoriaPrograma(Long convocatoria_id, Long programa_id);
}
