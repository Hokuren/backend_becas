package com.me.becas.model.dao;

import java.util.Date;

public interface ISolicitudBeneficiario {
	
	Date getfecha_solicitud();
	
	Long getnumero_de_identificacion();
	
	String getnombre();
	
	String getapellido();
	
	String getestado();
	
	String getprograma();
	
	String getestrato();
	
	Long getporcentaje_covertura();
	
	String getconvocatoria();
}
