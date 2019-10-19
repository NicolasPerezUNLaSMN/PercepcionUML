<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
     <%@page import="datos.Metodo"%>
         <%@page import="datos.Clase"%>
     <%@page import="datos.Version"%>
      <%@page import="datos.Argumento"%>
     <%@page import="datos.DiagramaDeClase"%>
     <%@page import="negocio.ArgumentoABM"%>
     <%@page import="negocio.VersionABM"%>
     <%@page import="negocio.ClaseABM"%>
	<%@page import="funciones.FuncionesNico"%>
     
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<head>
<title>Inicio visual a DC</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="./css/main.css">
	
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="jquery_plantuml.js"></script>
	
	<script src="http://code.responsivevoice.org/responsivevoice.js"></script>
	


	
	

	
</head>



<body>

	


<div style="height: 100%; overflow-y: scroll;">
		
		
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-balance zmdi-hc-fw"></i> Argumentos  <small>del metodo seleccionado</small></h1>
			</div>
			<p class="lead">Elija que argumentos borrar o cree nuevos</p>
		</div>
		
		
						<% Metodo metodo = (Metodo)request.getAttribute("metodo"); %>
				<form method="POST" action=" /UML-DC/ControladorVerListasDeLaClase">
				
								
											
				<INPUT type="hidden" name="idClase" value=<%=metodo.getClase().getIdClase() %> />
				
				<button type="submit" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Volver atras</button>
				</form>
		
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					
					  	<li class="active"><a href="#newSchool" data-toggle="tab"><i class="zmdi zmdi-balance"></i> Sus argumentos</a></li>
					  	<li><a href="#newYear" data-toggle="tab"><i class="zmdi zmdi-calendar-check"></i> Nuevo argumento</a></li>
					  	
					</ul>
					
					
					<div class="tab-content">
					
					
						<div class="tab-pane fade active in" id="newSchool">
						
						<div class="table-responsive">
								<table id="Tabla1" class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Nombre</th>
											<th class="text-center">Tipo</th>
											
											
											<th class="text-center">Borrar</th>
										</tr>
									</thead>
									<tbody>
									
									
									    
      
      
      
      <% //NO tiene versiones
		if (metodo.getListaArgumentos().isEmpty()) {	
			
		}	
		 %>
		 
		 
		  <% //Tiene versiones
		if (!metodo.getListaArgumentos().isEmpty()) {	
			
			
		ArgumentoABM argumentoabm = new ArgumentoABM();%>
			
		
									
		<% for (Argumento argumento: metodo.getListaArgumentos()){ %>
		
									<%  
									
									
									int idArgumento = argumento.getIdArgumento();
									
									
								
									
									
									%>
										<tr>
											<td><%= argumento.getIdArgumento() %></td>
											<td><%= argumento.getTipo() %></td>
											<td><%= argumento.getNombre() %></td>
											
											
											
											
											
											<td>
											<form method="POST" action=" /UML-DC/ControladorBorrarArgumento">
											<INPUT type="hidden" name="idArgumento" value="<%= argumento.getIdArgumento() %>" />
											<button type="submit"  class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i> </button>
											</form>
											</td>
											
										</tr>
									
										
										
		<% } //cierra el for %>
		
		
		
		
		<% } // cierra el tiene versiones%>
										
										
									</tbody>
								</table>
								
							</div>
							
						</div>
						
						
						<div class="tab-pane fade" id="newYear">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									
									
									    <form method="POST" action=" /UML-DC/ControladorAgregarArgumento">
									    
									     <INPUT type="hidden" name="idMetodo" value="<%= metodo.getIdMetodo() %>" />
									    
									    	<div class="form-group label-floating">
											  <label class="control-label">Nombre del argumento:</label>
											  <input class="form-control" type="text" name="nombre">
											</div>
											
											<div class="form-group">
										        <label class="control-label">Tipo:</label>
										        <select class="form-control" name="tipo">
										        	<option>String</option>
										          	<option>Int</option>
										          	<option>Boolean</option>
										          	<option>Char</option>
										          	<option>float</option>
										          	<option>Calendar</option>
										          
										          	<% int idClase = metodo.getClase().getIdClase(); %>
										          	<% ClaseABM cabm = new ClaseABM(); %>
										          	<%int idVersion = cabm.traerClase(idClase).getVersion().getIdVersion(); %>
										          	<% VersionABM vabm = new VersionABM(); %>
										          	<% for (Clase c:vabm.traerVersionYListaClases(idVersion).getListaClases()){ %>
										          		<option> 	<%=c.getNombre() %></option>
										          		<option> 	<%="ListaDe" +c.getNombre() %></option>
										          		
										          	<%} %>
										          	
										          	
										          	
										          	
										        </select>
										    </div>
											
											
										    <p class="text-center">
										    	<button type="submit" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Guardar</button>
										    </p>
										    
									    </form>
									    
									    
									    
									</div>
								</div>
							</div>
						</div>
						
						
						
					  
					  	
					  
					</div>
				</div>
			</div>
		</div>
		
		
		
	</div>
		
		
		
		
		
		
		
		
		
	
	

	
	
	<!--====== Scripts -->
	<script src="http://code.responsivevoice.org/responsivevoice.js"></script>
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="./js/sweetalert2.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/material.min.js"></script>
	<script src="./js/ripples.min.js"></script>
	<script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="./js/main.js"></script>
	<script>
		$.material.init();
	</script>
</body>


</html>