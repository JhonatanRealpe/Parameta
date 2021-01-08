package com.wsempleado.webservice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wsempleado.webservice.connection.Conexion;
import com.wsempleado.webservice.model.Empleado;

public class EmpleadoDAO {
	Connection c = null;

	public EmpleadoDAO() {
		c = new Conexion().getConnection();
	}

	public ArrayList<Empleado> getEmpleados() throws SQLException {
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		String sql = "SELECT * FROM empleado;";
		PreparedStatement pst = c.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Empleado empleado = new Empleado();
			empleado.setNombres(rs.getString("nombres"));
			empleado.setApellidos(rs.getString("apellidos"));
			empleado.setTipoDocumento(rs.getString("tipo_documento"));
			empleados.add(empleado);

		}
		return empleados;
	}

	public Boolean registrarEmpleado(Empleado empleado) throws SQLException {
		boolean resp = false;
		
		PreparedStatement ps = c.prepareStatement("INSERT INTO empleado "
				+ "(nombres, apellidos, tipo_documento, numero_documento, fecha_nacimiento, fecha_vinculacion, cargo, salario)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, empleado.getNombres());
		ps.setString(2, empleado.getApellidos());
		ps.setString(3, empleado.getTipoDocumento());
		ps.setString(4, empleado.getNumeroDocumento());
		ps.setString(5, empleado.getFechaNacimiento());
		ps.setString(6, empleado.getFechaVinculacion());
		ps.setString(7, empleado.getCargo());
		ps.setDouble(8, empleado.getSalario());
		
		int rs = ps.executeUpdate();
		
		if(rs>0)
			resp = true;
		
		return resp;
	}
}
