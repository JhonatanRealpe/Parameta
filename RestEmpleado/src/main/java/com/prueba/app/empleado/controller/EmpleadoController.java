package com.prueba.app.empleado.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.apache.axis.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.app.empleado.model.Empleado;
import com.prueba.app.empleado.model.ResponseEmpleado;
import com.prueba.app.empleado.util.Validate;
import com.wsempleado.webservice.EmpleadoServiceImplService;
import com.wsempleado.webservice.EmpleadoServiceImplServiceLocator;
import com.wsempleado.webservice.EmpleadoServiceImplServiceSoapBindingStub;

import ws_empleado.empleado.EmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	private Validate validate;
	
	private static final Logger log = LoggerFactory.getLogger(EmpleadoService.class);
	
	@GetMapping("/getHello")
	public String getHello() {
		return "Prueba Hello Empleados";
	}
	
	//Método recibe un Json y retorna Json
	@GetMapping("/empleado")
	public ResponseEntity<Object> createEmpleado(@RequestBody Empleado empleado) throws MalformedURLException, RemoteException {
		ResponseEmpleado response = new ResponseEmpleado();
		Map<String, Object> errores = validate.errores(empleado);
		Map<String, Object> body = new LinkedHashMap<String, Object>();
		int e = errores.size();
		if(e>0) {
			body = errores;
		}else {
			response.setEdadActual(empleado.getEdadActual());
			response.setTiempoVinculacion(empleado.getTiempoVinculacion());
			body.put("data", response);
		
/*			Para consumir el web service de esta forma es como lo haría normalmente  pero no se si tengo problema con alguna librería tendría que actualizar esta parte tambien lo hice con el plugin cxf-codegen-plugin pero no alcance a integrarlo a este proyecto * 							
			EmpleadoServiceImplService servicio = new EmpleadoServiceImplServiceLocator();
			EmpleadoService ws = new EmpleadoServiceImplServiceSoapBindingStub(new URL(servicio.getEmpleadoPortAddress()), servicio);
			ws_empleado.empleado.Empleado empleadoservice = getEmpleadoServicio(empleado);	
			boolean resp = ws.createEmpleado(empleadoservice); 
 * 
 */
			
		}
		
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
	//Convertidos de objeto cliente a objeto ws
	public ws_empleado.empleado.Empleado getEmpleadoServicio(Empleado empleado) {
		ws_empleado.empleado.Empleado empleadoservice = new ws_empleado.empleado.Empleado();
		empleadoservice.setNombres(empleado.getNombres());
		empleadoservice.setApellidos(empleado.getApellidos());
		empleadoservice.setTipoDocumento(empleado.getTipoDocumento());
		empleadoservice.setNumeroDocumento(empleado.getNumeroDocumento());
		empleadoservice.setFechaNacimiento(empleado.getFechaNacimiento());
		empleadoservice.setFechaVinculacion(empleado.getFechaVinculacion());
		empleadoservice.setCargo(empleado.getCargo());
		empleadoservice.setSalario(empleado.getSalario());
        return empleadoservice;
    }
	
	
}
