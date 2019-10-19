<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%@page import="datos.Version"%>
<%@page import="datos.Clase"%>
<%@page import="datos.DiagramaDeClase"%>
<%@page import="negocio.ClaseABM"%>
<%@page import="negocio.VersionABM"%>
<%@page import="negocio.DiagramaDeClaseABM"%>
<%@page import="funciones.FuncionesNico"%>



<!DOCTYPE html>
<html>
<head>
<meta name="flattr:id" content="1ew3x0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="application/ld+json">

</script>
<script type="application/ld+json">

</script>


<title>demostración de trabajo en tiempo real de forma
	sincrónica llamar desde JavaScript</title>
	

<link rel="stylesheet" media="screen" type="text/css"
	href="http://s.plantuml.com/menu4.css" />
	



</head>
<body>
	<div id=gc>
		<div id=root>
			
			<script async
				src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
			
			<% String textoAProcesar = (String)request.getAttribute("textoAProcesar"); %>
			

				<h2>Working synchronous demonstration</h2>
				
				<script src=http://s.plantuml.com/synchro.js></script>
				<script>
					function compress(a) {
						a = unescape(encodeURIComponent(a));
						GID("im").src = "http://www.plantuml.com/plantuml/img/"
								+ encode64(zip_deflate(a, 9));
								
								document.getElementById("content").innerHTML = "http://www.plantuml.com/plantuml/img/"+ encode64(zip_deflate(a, 9));
					};
				</script>
				
				
				 <div id="content"></div>
				
				<table>
					<tr>
						<td><form>
								<textarea id="inflated" cols="64" rows="10"><%=textoAProcesar %></textarea>
								<p>
									<input type=submit
										onclick="compress(GID('inflated').value);return false;">
								<p>
									<img id="im"
										src=http://www.plantuml.com/plantuml/img/SyfFKj2rKt3CoKnELR1Io4ZDoSa70000>
							</form></td>
					
					</tr>
				</table>
				
				
				
			
			
			
				
			</div>
			
		</div>

	
	<script src="http://www.statcounter.com/counter/counter.js"></script>
</body>
</html>