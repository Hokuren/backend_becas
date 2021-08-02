package com.me.becas.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.me.becas.model.entity.Aspirante;


public interface IAspiranteDao extends JpaRepository<Aspirante, Long> {
	

			@Query("select distinct s.fecha_solicitud as fecha_solicitud, "
			+ "a.numero_de_identificacion as numero_de_identificacion,"
			+ " a.nombre as nombre,a.apellido as apellido,s.estado as estado, p.nombre as programa,"
			+ "e.nombre as estrato, asi.porcentaje_covertura as porcentaje_covertura, c.nombre as convocatoria "
			+ "from Aspirante a "
			+ "inner join Solicitud s on a.aspirante_id = s.aspirante_id "
			+ "inner join Convocatoria c on s.convocatoria_id = c.convocatoria_id "
			+ "inner join ConvocatoriaPrograma cp on c.convocatoria_id = cp.convocatoria_id "
			+ "inner join Programa p on cp.programa_id = p.programa_id and s.programa_id = p.programa_id "
			+ "inner join Asignacion asi on c.convocatoria_id = asi.convocatoria_id "
			+ "inner join EstratoAsignacion estra on asi.asignacion_id = estra.asignacion_id inner "
			+ "join Estrato e on estra.estrato_id = e.estrato_id and a.estrato_id = e.estrato_id "
			+ "where a.numero_de_identificacion = ?1 order by s.fecha_solicitud desc")
			List<ISolicitudBeneficiario> findByNumeroDeIdentificacion(Long numero_de_identificacion);
			
			
			@Query("select distinct s.fecha_solicitud as fecha_solicitud, "
					+ "a.numero_de_identificacion as numero_de_identificacion,"
					+ " a.nombre as nombre,a.apellido as apellido,s.estado as estado, p.nombre as programa,"
					+ "e.nombre as estrato, asi.porcentaje_covertura as porcentaje_covertura, c.nombre as convocatoria "
					+ "from Aspirante a "
					+ "inner join Solicitud s on a.aspirante_id = s.aspirante_id "
					+ "inner join Convocatoria c on s.convocatoria_id = c.convocatoria_id "
					+ "inner join ConvocatoriaPrograma cp on c.convocatoria_id = cp.convocatoria_id "
					+ "inner join Programa p on cp.programa_id = p.programa_id and s.programa_id = p.programa_id "
					+ "inner join Asignacion asi on c.convocatoria_id = asi.convocatoria_id "
					+ "inner join EstratoAsignacion estra on asi.asignacion_id = estra.asignacion_id inner "
					+ "join Estrato e on estra.estrato_id = e.estrato_id and a.estrato_id = e.estrato_id "
					+ "WHERE s.estado = 'BENEFICIARIO' and c.convocatoria_id = ?1 order by s.fecha_solicitud desc")
			List<ISolicitudBeneficiario> findByAllBeneficiariosConvocatoria(Long convocatoria_id);
}
