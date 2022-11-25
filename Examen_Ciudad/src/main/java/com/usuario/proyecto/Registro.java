package com.usuario.proyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.usuario.datos.Conexion;

public class Registro {
	private int id;
	private String pregunta1;
	private String pregunta2;
	private String pregunta3;
	private String pregunta4;
	private String pregunta5;
	private String pregunta6;
	
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}

	
	public String getPregunta1() {
		return pregunta1;
	}
	public void setPre1(String pregunta1) {
		this.pregunta1 = pregunta1;
	}
	public String getPregunta2() {
		return pregunta2;
	}
	public void setPregunta2(String pregunta2) {
		this.pregunta2 = pregunta2;
	}
	public String getPregunta3() {
		return pregunta3;
	}
	public void setPregunta3(String pregunta3) {
		this.pregunta3 = pregunta3;
	}
	public String getPregunta4() {
		return pregunta4;
	}
	public void setPregunta4(String pregunta4) {
		this.pregunta4 = pregunta4;
	}
	public String getPregunta5() {
		return pregunta5;
	}
	public void setPre5(String pregunta5) {
		this.pregunta5 = pregunta5;
	}
	public String getPregunta6() {
		return pregunta6;
	}
	public void setPregunta6(String pregunta6) {
		this.pregunta6 = pregunta6;
	}
	
	public String ingresarPreguntas(int id, String pregunta1,String pregunta2,String pregunta3,String pregunta4,String pregunta5,String pregunta6)
	{
		String result="";
		Conexion con=new Conexion();
		PreparedStatement us=null;
		String sql="INSERT INTO tb_preguntas(id,pregunta1,"
				+ "pregunta2,pregunta3,pregunta4,pregunta5,pregunta6)"
				+ "VALUES(?,?,?,?,?,?,?)";
		try{
			us=con.getConexion().prepareStatement(sql);
			us.setInt(1,id);
			us.setString(2,pregunta1);
			us.setString(3,pregunta2);				
			us.setString(4,pregunta3);	
			us.setString(5,pregunta4);
			us.setString(6,pregunta5);
			us.setString(7,pregunta6);
			if(us.executeUpdate()==1)
			{
				result=" Preguntas Registradas " ;
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
	public String consultarPreguntas()
	{
		String sql="SELECT * FROM tb_preguntas ORDER BY id";
		Conexion con=new Conexion();
		String tabla="<table border=2>"
				+ "<th>id</th>"
				+ "<th>¿Qué probabilidad hay de que recomiendes nuestro sito web a un amigo?</th>"
				+ "<th>¿La información es útil?</th>"
				+ "<th>¿Qué podríamos haber hecho mejor?</th>"
				+ "<th>¿Hay algún otro servicio que le gustaría que ofreciéramos?</th>"
				+ "<th>¿Cómo se enteró de la existencia de esta página web?</th>"
				+ "<th>¿Cuál es su grado de satisfacción con su experiencia general en nuestro sitio web hoy?</th>";
		
		ResultSet rs=null;
		rs=con.Consulta(sql);
		try {
			while(rs.next())
			{
				tabla+="<tr><td>"+rs.getInt(1)+"</td>"
						+ "<td>"+rs.getString(2)+"</td>"
						+ "<td>"+rs.getString(3)+"</td>"
						+ "<td>"+rs.getString(4)+"</td>"
						+ "<td>"+rs.getString(5)+"</td>"
						+ "<td>"+rs.getString(6)+"</td>"
						+ "<td>"+rs.getString(7)+"</td>"
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
	public String mostrarPreguntas()
	{
		String combo="<select name=cmbRegistro>";
		String sql="SELECT * FROM tb_preguntas";
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