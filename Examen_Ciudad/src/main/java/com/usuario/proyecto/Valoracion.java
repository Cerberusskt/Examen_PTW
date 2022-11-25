package com.usuario.proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usuario.datos.Conexion;

public class Valoracion{
	private int id;
	private String comentario;
	private int valoracion;
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	public String ingresarValoracion(int id, String comentario,String valoracion)
	{
		String result="";
		Conexion con=new Conexion();
		PreparedStatement us=null;
		String sql="INSERT INTO tb_valoracion(comentario,"
				+ "valoracion,id) "
				+ "VALUES(?,?,?)";
		try{
			us=con.getConexion().prepareStatement(sql);
			us.setInt(1, id);
			us.setString(2,comentario);
			us.setString(3,valoracion);				
			if(us.executeUpdate()==1)
			{
				result="Valoracion y Comentario Registrado";
					
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
	public String consultarValoracion()
	{
		String sql="SELECT * FROM tb_valoracion ORDER BY id";
		Conexion con=new Conexion();
		String tabla="<table border=2>"
				+ "<th>id</th>"
				+ "<th>Comentario</th>"
				+ "<th>Valoracion</th>";
				
		ResultSet rs=null;
		rs=con.Consulta(sql);
		try {
			while(rs.next())
			{
				tabla+="<tr><td>"+rs.getInt(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
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
	public String mostrarValidacion()
	{
		String combo="<select name=cmbValoracion>";
		String sql="SELECT * FROM tb_valoracion";
		ResultSet rs=null;
		Conexion cone=new Conexion();
		try
		{
			rs=cone.Consulta(sql);
			while(rs.next())
			{
				combo+="<option value="+rs.getString(1)+ ">"+rs.getInt(2)+"</option>";
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
