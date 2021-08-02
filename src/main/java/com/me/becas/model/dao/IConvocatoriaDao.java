package com.me.becas.model.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.me.becas.model.entity.Convocatoria;


public interface IConvocatoriaDao extends JpaRepository<Convocatoria, Long>{
	
	@Query("select convocatoria_id as convocatoria_id,nombre as nombre from Convocatoria")
	List<IConvocatoriaSimpleDao> findByAllConvocatorias();
	

}
