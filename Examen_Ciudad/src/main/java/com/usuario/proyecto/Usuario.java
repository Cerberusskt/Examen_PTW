package com.usuario.proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usuario.datos.Conexion;

public class Usuario {
	
		
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String fecha;


	public int getid() {
		return id;
	}


	public void setid(int id) {
		this.id = id;
	}

	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEdad() {
		return email;
	}

	public void setEdad(String edad) {
		this.email = edad;
	}
	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public String consultarUsuarios()
	{
		String sql="SELECT * FROM tb_usuarios ORDER BY id";
		Conexion con=new Conexion();
		String tabla="<table border=2><th>id</th><th>Nombre</th><th>Apellido</th><th>Email</th><th>Fecha</th>";
		ResultSet rs=null;
		rs=con.Consulta(sql);
		try {
			while(rs.next())
			{
				tabla+="<tr><td>"+rs.getString(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getString(4)+"</td>"
						+ "<td>"+rs.getString(5)+"</td>"
						+ "</td></tr>";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		tabla+="</table>";
		return tabla;
	}
	public String ingresarUsuario(int id, String nombre, String apellido,String email,String fecha)
	{
		String result="";
		Conexion con=new Conexion();
		PreparedStatement us=null;
		String sql="INSERT INTO tb_usuarios (id,nombre,"
				+ "apellido,email,fecha) "
				+ "VALUES(?,?,?,?,?)";
		try{
			us=con.getConexion().prepareStatement(sql);
			us.setInt(1,id);
			us.setString(2,nombre);
			us.setString(3,apellido);
			us.setString(4,email);
			us.setString(5,fecha);
			if(us.executeUpdate()==1)
			{
				result=
					"Usuario Ingresado " + nombre + apellido;
			}
			else
			{
				result="Error en inserción";
			}
		}
		catch(Exception ex)
		{
			result=ex.getMessage();
		}
		finally
		{
			try
			{
				us.close();
				con.getConexion().close();
			}
			catch(Exception ex)
			{
				System.out.print(ex.getMessage());
			}
		}
		return result;
	}
	public String mostrarUsuario()
	{
		String combo="<select name=cmbUsuario>";
		String sql="SELECT * FROM tb_usuarios";
		ResultSet rs=null;
		Conexion cone=new Conexion();
		try
		{
			rs=cone.Consulta(sql);
			while(rs.next())
			{
				combo+="<option value="+rs.getInt(1)+ ">"+rs.getString(2)+"</option>";
			}
			combo+="</select>";
		}
		catch(SQLException e)
		{
			System.out.print(e.getMessage());
		}
		return combo;
	}


	


	

}