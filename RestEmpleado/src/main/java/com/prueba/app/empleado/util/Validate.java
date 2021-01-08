package com.prueba.app.empleado.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.prueba.app.empleado.model.Empleado;

@Service
public class Validate {
	
	public Map<String, Object> errores(Empleado empleado){
		
		Map<String, Object> erros = new LinkedHashMap<String, Object>();
		String campo;
		Empleado empleadoF;
		
		campo = empleado.getNombres();
		if(campo==null ||  campo.isEmpty())
			erros.put("Error nombres"," no puede ser vacio");
		
		campo = empleado.getApellidos();
		if(campo==null ||  campo.isEmpty())
			erros.put("Error apellidos"," no puede ser vacio");
		
		campo = empleado.getTipoDocumento();
		if(campo==null ||  campo.isEmpty())
			erros.put("Error tipoDocumento"," no puede ser vacio");
		
		campo = empleado.getNumeroDocumento();
		if(campo==null ||  campo.isEmpty())
			erros.put("Error numeroDocumento"," no puede ser vacio");
		
		campo = empleado.getFechaNacimiento();
		if(campo==null ||  campo.isEmpty())
			erros.put("Error fechaNacimiento"," no puede ser vacio");
		else if(!isValidDate(campo))
			erros.put("Error fechaNacimiento"," no tiene un formato valido (yyyy/dd/MM)");
		else{
			empleadoF = setEdad(empleado);
			if(empleadoF == null)
				erros.put("Error"," empleado menor de edad!!!");
		}
			
			
		
		campo = empleado.getFechaVinculacion();
		if(campo==null ||  campo.isEmpty())
			erros.put("Error fechaVinculacion"," no puede ser vacio");
		else if(!isValidDate(campo))
			erros.put("Error fechaVinculacion"," no tiene un formato valido (yyyy/dd/MM)");
		else{
			empleadoF = setTiempoVinculacion(empleado);
			if(empleadoF == null)
				erros.put("Error fechaVinculacion"," no puede ser superior al día actual ni menor a la fecha de nacimiento");
		}
			
		
		campo = empleado.getCargo();
		if(campo==null ||  campo.isEmpty())
			erros.put("Error cargo"," no puede ser vacio");
		
		
		return erros;
	}
	
	public boolean isValidDate(String fecha) { 
		 try {
	            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/dd/MM", Locale.getDefault());
	            formatoFecha.setLenient(false);
	            formatoFecha.parse(fecha);
	        } catch (ParseException e) {
	            return false;
	        }
	        return true; 
	}
	
	public Empleado setEdad(Empleado empleado) { 
		String edadActual ="";
		 try {
	            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/dd/MM", Locale.getDefault());
	            formatoFecha.setLenient(false);
	            Calendar date1 = getCalendar(formatoFecha.parse(empleado.getFechaNacimiento()));
	            Calendar date2 = getCalendar(new Date());
	          
	            Calendar aux = Calendar.getInstance();
	            aux.setTimeInMillis(date2.getTimeInMillis() - date1.getTimeInMillis());
	            
	            int diff = (aux.get(Calendar.YEAR) - 1970);
	            if(diff<18)
	            	return null;
	            //A tomar en cuenta que el año minimo es 1970 por eso le resto esa cantidad
	            edadActual = ("" + (aux.get(Calendar.YEAR) - 1970) + " Años,  " + aux.get(Calendar.MONTH) + " Meses y " +
	            (aux.get(Calendar.DAY_OF_MONTH)-1)+ " Días");
	            
	        } catch (ParseException e) {
	        	System.out.println("Error "+ e.getLocalizedMessage());
	        }
		 	empleado.setEdadActual(edadActual);
		 	return empleado;
	}
	
	public Empleado setTiempoVinculacion(Empleado empleado) { 
		String TiempoVinculacion ="";
		 try {
	            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/dd/MM", Locale.getDefault());
	            formatoFecha.setLenient(false);
	            Calendar date0 = getCalendar(formatoFecha.parse(empleado.getFechaNacimiento()));
	            Calendar date1 = getCalendar(formatoFecha.parse(empleado.getFechaVinculacion()));
	            Calendar date2 = getCalendar(new Date());
	          
	            if(date1.getTimeInMillis()>date2.getTimeInMillis() || date1.getTimeInMillis()<date0.getTimeInMillis())
	            	return null;
	            
	            Calendar aux = Calendar.getInstance();
	            aux.setTimeInMillis(date2.getTimeInMillis() - date1.getTimeInMillis());
	            //A tomar en cuenta que el año minimo es 1970 por eso le resto esa cantidad
	            TiempoVinculacion = ("" + (aux.get(Calendar.YEAR) - 1970) + " Años,  " + aux.get(Calendar.MONTH) + " Meses y " +
	            (aux.get(Calendar.DAY_OF_MONTH)-1)+ " Días");
	            
	        } catch (ParseException e) {
	        	System.out.println("Error "+ e.getLocalizedMessage());
	        }
		 	empleado.setTiempoVinculacion(TiempoVinculacion);
		 	return empleado;
	}
	
	public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

}
