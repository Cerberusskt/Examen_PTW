<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.usuario.proyecto.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QATAR - DOHA</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <link rel="stylesheet" href="css/estilo.css">   
</head>

    <header>
        <div class="container">
            <nav class="nav">
                <a href="informacion.jsp" class="logo">FtoAnthonyDj</a>
                <ul class="nav-list">
                    <li class="nav-item">
                        <a href="index.jsp" class="nav-link active">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a href="hospedaje.jsp" class="nav-link ">Hospedaje</a>
                    </li>
                    <li class="nav-item">
                        <a href="lugar_interes.jsp" class="nav-link ">Lugares Interés</a>
                    </li>
                     <li class="nav-item">
                        <a href="comida.jsp" class="nav-link ">Comida Tipica</a>
                    </li>
                    <li class="nav-item">
                        <a href="mapa.jsp" class="nav-link ">Mapa Ubicación</a>
                    </li>
                    <li class="nav-item">
                        <a href="formulario.jsp" class="nav-link ">Formulario</a>
                    </li>
                </ul>
            </nav>
        </div>
    </header>
<body>
<video src="imagenes/validacion.mp4" autoplay loop muted></video>
<main>
    	<section class="hacer" id="hacer">
        <div class="container">
            <h1 class="head">Formulario De Apoyo Para La Página</h1>
         <div class="he-des">
        </div>
    </section>

<%
int id=Integer.parseInt(request.getParameter("id"));
String nombre=request.getParameter("nombre");
String apellido=request.getParameter("apellido");	
String email=request.getParameter("txtemail");
String fecha=request.getParameter("fecha");


Usuario usuario=new Usuario();
out.print(usuario.ingresarUsuario(id,nombre,apellido,email,fecha));
%>
<div class="global">
                        <h2 class="h2-sub">
                            ENCUESTA PARA USUARIOS VALORACIÓN PÁGINA!
                        </h2>
                        <br>
                        <br>
                </div>
                <form action="evaluacion_pre.jsp" method="post">	
				<br><br>  
                <table border="0">
                <tr>
				<td>ID:</td>
				<td><input type="text" name="id" class=field  required/>*</td>
				</tr>	
                <tr>
				<td>¿Qué probabilidad hay de que recomiendes nuestro sito web a un amigo?</td>
				<td><input type="textarea" name="pregunta1" class=field  required/></td>
				</tr>
				<tr>
				<td>¿La información es útil?</td>
				<td><input type="text" name="pregunta2" class=field  required/></td>
				</tr>
				<tr>
				<td>¿Qué podríamos haber hecho mejor?</td>
				<td><input type="text" name="pregunta3" class=field  required/></td>
				</tr>
				<tr>
				<td>¿Hay algún otro servicio que le gustaría que ofreciéramos?</td>
				<td><input type="text" name="pregunta4" class=field  required/></td>
				</tr>
				<tr>
				<td>¿Cómo se enteró de la existencia de esta página web?</td>
				<td><input type="text" name="pregunta5" class=field  required/></td>
				</tr>
				<tr>
				<td>¿Cuál es su grado de satisfacción con su experiencia general en nuestro sitio web hoy?</td>
				<td><input type="text" name="pregunta6" class=field  required/></td>
				</tr>
				<tr>
				<td><br><input type="submit" class="btn btn-green" value="Enviar Preguntas"><td/><br>
				<input type="reset" class="btn btn-green" value="Borrar"><br>
				</tr>
				</table>
				</form>
						
  <footer>
        <div class="container">
            <div class="footer-content">
                <div class="footer-content-about">
                    <h4>Más Sobre Nosotros</h4>
                    <div class="circle">
                        <i class="fas fa-circle"></i>
                    </div>
                    <p>
                    Qatar recibe miles de emigrantes y como resultado Doha ha sido testigo de la tasa de crecimiento explosivo de la población de doha esta
                    se sitúa actualmente en el alrededor de unos dos millones con la población de la ciudad mas del doble que en la ultima decada. Qatar en 
                    el año 2022 séra sede del primer mundial de fútbol en un pais árabe, la COPA MUNDIAL DE FÚTBOL DEL PRESENTE AÑO.
                    </p>
                </div>
                <div>
                    <div>
                        <h4>Siguenos</h4>
                        <ul class="social-icons">
                            <li>
                                <a target="_blank" href="https://twitter.com/Anthony03185944"><i class="fab fa-twitter"></i></a>
                            </li>
                            <li>
                                <a target="_blank" href="https://www.facebook.com/anthony.delgado.79219754"><i class="fab fa-facebook-square"></i></a>
                            </li>
                            <li>
                                <a target="_blank" href="https://www.instagram.com/skt.thonyvdj/"><i class="fab fa-instagram"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</main>
</body>
</html>