package com.wsempleado.webservice.model;

public class ResponseEmpleado {

	private String tiempoVinculacion;
	private String edadActual;
	
	public ResponseEmpleado() {}
	
	public ResponseEmpleado(String tiempoVinculacion, String edadActual) {
		this.tiempoVinculacion = tiempoVinculacion;
		this.edadActual = edadActual;
	}

	public String getTiempoVinculacion() {
		return tiempoVinculacion;
	}

	public void setTiempoVinculacion(String tiempoVinculacion) {
		this.tiempoVinculacion = tiempoVinculacion;
	}

	public String getEdadActual() {
		return edadActual;
	}

	public void setEdadActual(String edadActual) {
		this.edadActual = edadActual;
	}
	
}