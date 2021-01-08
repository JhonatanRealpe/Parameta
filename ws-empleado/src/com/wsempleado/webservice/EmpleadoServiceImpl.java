package com.wsempleado.webservice;

import java.sql.SQLException;

import javax.jws.WebService;
import java.util.logging.Logger; 

import com.wsempleado.webservice.model.Empleado;
import com.wsempleado.webservice.model.dao.EmpleadoDAO;

@WebService(endpointInterface = "com.wsempleado.webservice.EmpleadoService", name = "Empleado")
public class EmpleadoServiceImpl implements EmpleadoService {

	Logger logger = Logger.getLogger(EmpleadoServiceImpl.class.getName());
	EmpleadoDAO consulta = new EmpleadoDAO(); 
	
	@Override
	public boolean createEmpleado(Empleado empleado) throws SQLException {
		boolean resp = false;
		try {
			resp = consulta.registrarEmpleado(empleado);	
		} catch (Exception e) {
			logger.info("Error en registro de empleado SQL "+ e); 
		}
		
		String mensaje = resp?" Registrado con exito!":" Ocurrio un error en el registro";
		System.out.println("El Empleado "+ empleado.getNombres() + mensaje);
		return resp;
	}

}
