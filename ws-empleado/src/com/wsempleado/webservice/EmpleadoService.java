package com.wsempleado.webservice;

import java.sql.SQLException;

import javax.jws.WebService;

import com.wsempleado.webservice.model.Empleado;

@WebService(targetNamespace = "http://ws-empleado/empleado")
public interface EmpleadoService {
	
		public boolean createEmpleado (Empleado empleado) throws SQLException;
}