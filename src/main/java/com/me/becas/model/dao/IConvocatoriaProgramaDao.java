package com.me.becas.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.me.becas.model.entity.ConvocatoriaPrograma;


public interface IConvocatoriaProgramaDao extends JpaRepository<ConvocatoriaPrograma, Long> {
	
	//Petición 4 //DELETE //eliminar/convocatoria/programa/criterio
	@Modifying(clearAutomatically = true)
	@Query("delete from ConvocatoriaPrograma c where c.convocatoria_id = :convocatoria_id and c.programa_id = :programa_id and c.criterio_id = :criterio_id")
	public void deleteByConvocatoriaProgramaCriterio(@Param("convocatoria_id") Long convocatoria_id,@Param("programa_id") Long programa_id,@Param("criterio_id")  Long criterio_id);

	//Petición 5 //DELETE //eliminar/convocatoria/programa
	@Modifying(clearAutomatically = true)
	@Query("delete from ConvocatoriaPrograma c where c.convocatoria_id = :convocatoria_id and c.programa_id = :programa_id")
	public void deleteByConvocatoriaPrograma(@Param("convocatoria_id") Long convocatoria_id,@Param("programa_id") Long programa_id);

	
}
