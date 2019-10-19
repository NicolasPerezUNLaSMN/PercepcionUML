<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
     <%@page import="datos.Version"%>
      <%@page import="datos.Clase"%>
     <%@page import="datos.DiagramaDeClase"%>
     <%@page import="datos.Metodo"%>
     <%@page import="datos.Atributo"%>
     <%@page import="datos.Relacion"%>
     <%@page import="java.util.Set" %>
  
     <%@page import="negocio.ClaseABM"%>
      <%@page import="negocio.VersionABM"%>
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
	<!-- SideBar -->
	
	
	
	

	<!-- Content page-->
	
	
	
		
		
		
<!-- Content page -->



<div style="height: 100%; overflow-y: scroll;">





		
		
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-balance zmdi-hc-fw"></i> Estructura <small>de la clase a editar</small></h1>
			</div>
			<p class="lead">Elija la relacion, atributo o metodo con el que quiere trabajar o cree un elemento nuevo.</p>
		</div>
		
		
		
		<form method="POST" action=" /UML-DC/ControladorVerClases">
		
		
				<% int idClase = (Integer)request.getAttribute("idClase"); %>
				
		
				<%ClaseABM cabm = new ClaseABM ();%>
		
				<%Clase claseYSuVersion = cabm.traerClase(idClase);%>
		
				<%int idVersionDeLaClase = claseYSuVersion.getVersion().getIdVersion();%>
				
								
											
		<INPUT type="hidden" name="idVersion" value="<%= idVersionDeLaClase%>" />
		<button type="submit" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Volver atras</button>
		
		</form>
		
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
				
				
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					
					  	<li class="active"><a href="#atributos" data-toggle="tab"><i class="zmdi zmdi-balance"></i> Sus atributos</a></li>
					  	<li><a href="#newAtributo" data-toggle="tab"><i class="zmdi zmdi-calendar-check"></i> Nuevo atributo</a></li>
					  	<li><a href="#relaciones" data-toggle="tab"><i class="zmdi zmdi-calendar-check"></i> Sus relaciones</a></li>
					  	<li><a href="#newRelacion" data-toggle="tab"><i class="zmdi zmdi-calendar-check"></i> Nueva relacion</a></li>
					  	<li><a href="#metodos" data-toggle="tab"><i class="zmdi zmdi-calendar-check"></i> Sus metodos</a></li>
					  	<li><a href="#newMetodo" data-toggle="tab"><i class="zmdi zmdi-calendar-check"></i> Nuevo metodo</a></li>
					  	
					</ul>
					
					
					  <% Set <Atributo> atributos= (Set <Atributo>)request.getAttribute("atributos"); %>
					  <% Set <Relacion> relaciones= (Set <Relacion>)request.getAttribute("relaciones"); %>
					  <% Set <Metodo> metodos= (Set<Metodo>)request.getAttribute("metodos"); %>
					   
					
					
					<div class="tab-content">
					
					<!-- Lista de atributos -->
						<div class="tab-pane fade active in" id="atributos">
						
						<div class="table-responsive">
								<table id="Tabla1" class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Privilegio</th>
											<th class="text-center">Tipo</th>
											<th class="text-center">Nombre</th>
											
											
											<th class="text-center">Borrar</th>
										</tr>
									</thead>
									<tbody>
									
									
									    
    
      
      
      <% //NO tiene versiones
		if (atributos==null) {	
			
		}	
		 %>
		 
		 
		  <% //Tiene versiones
		if (atributos!=null) {	
		
			
		
									
		for (Atributo atributo: atributos){ 
			
			int idAtributo = atributo.getIdAtributo();
			String nombre = atributo.getNombre();
			String privilegio = atributo.getPrivilegio();
			String tipo = atributo.getTipo();
		
								
									
									
									%>
										<tr>
											<td><%= idAtributo %></td>
											<td><%= privilegio %></td>
											<td><%= tipo %></td>
											<td><%= nombre %></td>
											
											
											
											
											
											
											
											<td>
											<form method="POST" action=" /UML-DC/ControladorBorrarAtributo">
											<INPUT type="hidden" name="idAtributo" value="<%= idAtributo%>" />
											<INPUT type="hidden" name="idClase" value="<%= idClase%>" />
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
						




						
						
						
						
						
							<!-- Nuevo metodo -->
						
						<div class="tab-pane fade" id="newMetodo">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									
									
									    <form method="POST" action=" /UML-DC/ControladorAgregarMetodo">
									    
									     <INPUT type="hidden" name="idClase" value="<%= idClase %>" />
									    
									    	<div class="form-group label-floating">
											  <label class="control-label">Nombre del metodo:</label>
											  <input class="form-control" type="text" name="nombre">
											</div>
											
											<div class="form-group">
										        <label class="control-label">Privilegio:</label>
										        <select class="form-control" name="privilegio">
										        	<option>Publica</option>
										          	<option>Privada</option>
										          	<option>Protected</option>
										          	<option>Estatico</option>
										          	<option>Sin Definir</option>
										          	
										        </select>
										    </div>
										    
										    
										    <div class="form-group">
										        <label class="control-label">Retorno:</label>
										        <select class="form-control" name="retorno">
										        	<option>String</option>
										          	<option>Int</option>
										          	<option>Char</option>
										          	<option>Void</option>
										          	<option>float</option>
										          	<option>Calendar</option>
										          	
										          		
										          	<% ClaseABM cabm2 = new ClaseABM(); %>
										          	<%int idVersion2 = cabm2.traerClase(idClase).getVersion().getIdVersion(); %>
										          	<% VersionABM vabm = new VersionABM(); %>
										          	<% for (Clase c:vabm.traerVersionYListaClases(idVersion2).getListaClases()){ %>
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
						





						
						
						
						
						
						
						
						<!-- Nuevo atributo -->
						
						<div class="tab-pane fade" id="newAtributo">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									
									
									    <form method="POST" action=" /UML-DC/ControladorAgregarAtributo">
									    
									     <INPUT type="hidden" name="idClase" value="<%= idClase %>" />
									    
									    	<div class="form-group label-floating">
											  <label class="control-label">Nombre del atributo:</label>
											  <input class="form-control" type="text" name="nombre" required>
											</div>
											
											<div class="form-group">
										        <label class="control-label">Privilegio:</label>
										        <select class="form-control" name="privilegio">
										        	<option>Publica</option>
										          	<option>Privada</option>
										          	<option>Protected</option>
										          	<option>Sin Definir</option>
										          	
										        </select>
										    </div>
										    
										    <div class="form-group">
										        <label class="control-label">Tipo:</label>
										        <select class="form-control" name="tipo">
										        	<option>String</option>
										          	<option>boolean</option>
										          	<option>int</option>
										          	<option>float</option>
										          	<option>Calendar</option>
										          	
										          	
										          	<% ClaseABM cabm3 = new ClaseABM(); %>
										          	<%int idVersion3 = cabm3.traerClase(idClase).getVersion().getIdVersion(); %>
										          	<% VersionABM vabm3 = new VersionABM(); %>
										          	<% for (Clase c:vabm3.traerVersionYListaClases(idVersion3).getListaClases()){ %>
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
						
						
						
						
						<!-- Lista relaciones -->
						<div class="tab-pane fade" id="relaciones">
							<div class="table-responsive">
								<table class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Tipo</th>
											<th class="text-center">Clase</th>
											<th class="text-center">Inicio</th>
											<th class="text-center">Fin</th>
											
											<th class="text-center">Borrar</th>
										</tr>
									</thead>
									<tbody>
									
									
																		
									
									    
    
      
      
      <% //NO tiene versiones
		if (relaciones==null) {	
			
		}	
		 %>
		 
		 
		  <% //Tiene versiones
		if (relaciones!=null) {	
		
			
		
									
		for (Relacion relacion: relaciones){ 
			
			int idRelacion = relacion.getIdRelacion();
			String tipo = relacion.getTipoRelacion();
			String clase = relacion.getClase();
			String inicio = relacion.getInicioRelacion();
			String fin = relacion.getFinRelacion();
		
								
									
									
									%>
										<tr>
											<td><%= idRelacion %></td>
											<td><%= tipo %></td>
											<td><%= clase %></td>
											<td><%= inicio %></td>
											<td><%= fin %></td>
											
											
											
											
											
											
											
											<td>
											<form method="POST" action=" /UML-DC/ControladorBorrarRelacion">
											<INPUT type="hidden" name="idRelacion" value="<%= idRelacion%>" />
											<INPUT type="hidden" name="idClase" value="<%= idClase%>" />
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
						
						
						
						
						
					
						
				<!-- nueva relacion -->
						<div class="tab-pane fade" id="newRelacion">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									
									
									    <form method="POST" action="/UML-DC/ControladorAgregarRelacion">
									    
									     <INPUT type="hidden" name="idClase" value="<%= idClase %>" />
									    
									    	
											
											<div class="form-group">
										        <label class="control-label">Tipo:</label>
										        <select class="form-control" name="tipo">
										        	<option>Agregacion</option>
										          	<option>Composicion</option>
										          	<option>Hereda de</option>
										          	<option>Hereda a</option>
										          	<option>Dependencia</option>
										          	<option>Implementacion</option>
										          	
										        </select>
										    </div>
										    
										    
										    
										    <div class="form-group">
										        <label class="control-label">Clase con que se relaciona:</label>
										        <select class="form-control" name="clase">
										        
										        <%
										        VersionABM versionabm = new VersionABM();
										        ClaseABM claabm = new ClaseABM();
										        int idVersion = claabm.traerClase(idClase).getVersion().getIdVersion();
										        for (Clase c:versionabm.traerVersionYListaClases(idVersion).getListaClases()){%>
										        	
										        	<option><%=c.getNombre() %></option>
										        	
										        	
										        <%} %>    
										        	
										          	
										        </select>
										    </div>
										    
										    
										    <div class="form-group">
										        <label class="control-label">Multiplicidad inicial:</label>
										        <select class="form-control" name="inicial">
										        	<option>  </option>
										          	<option>0..1</option>
										          	<option>0..*</option>
										          	<option>1..*</option>
										          	
										        </select>
										    </div>
										    
										    <div class="form-group">
										        <label class="control-label">Multiplicidad final:</label>
										        <select class="form-control" name="final">
										        	<option>  </option>
										          	<option>0..1</option>
										          	<option>0..*</option>
										          	<option>1..*</option>
										          	
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
						
						
						
						
						
						
						<!-- Lista de metodos -->
						<div class="tab-pane fade" id="metodos">
							<div class="table-responsive">
								<table class="table table-hover text-center">
									
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Privilegio</th>
											<th class="text-center">Retorno</th>
											<th class="text-center">Nombre</th>
											
											<th class="text-center">Seguir...</th>
											<th class="text-center">Borrar</th>
										</tr>
									</thead>
									<tbody>
									
									
									    
    
      
      
      <% //NO tiene versiones
		if (metodos==null) {	
			
		}	
		 %>
		 
		 
		  <% //Tiene versiones
		if (metodos!=null) {	
		
			
		
									
		for (Metodo metodo: metodos){ 
			
			int idMetodo = metodo.getIdMetodo();
			String nombre = metodo.getNombre();
			String privilegio = metodo.getPrivilegio();
			String retorno = metodo.getRetorno();
		
								
									
									
									%>
										<tr>
											<td><%= idMetodo %></td>
											<td><%= privilegio %></td>
											<td><%= retorno %></td>
											<td><%= nombre %></td>
											
											
											
											<td>
											
											<form method="POST" action=" /UML-DC/ControladorVerArgumentos">
											
											 <INPUT type="hidden" name="idMetodo" value="<%= idMetodo %>" />
											
											<button  type="submit"  class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i> </button>
											</form>
											</td>
											
											
											
											<td>
											<form method="POST" action=" /UML-DC/ControladorBorrarMetodo">
											<INPUT type="hidden" name="idMetodo" value="<%= idMetodo%>" />
											<INPUT type="hidden" name="idClase" value="<%= idClase%>" />
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
						
						
						
						
						
								
						
					
						
					  
					  	
					  	
					</div>
				</div>
			</div>
		</div>
		
		
	
		
		</div>
		
		
		
		

		
		
	
	

	<!-- Dialog help -->
	<div class="modal fade" tabindex="-1" role="dialog" id="Dialog-Help">
	  	<div class="modal-dialog" role="document">
		    <div class="modal-content">
			    <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			    	<h4 class="modal-title">Ayuda</h4>
			    </div>
			    <div class="modal-body">
			        <p>
			        	Ante cualquier duda contactenos en: 
			        </p>
			    </div>
		      	<div class="modal-footer">
		        	<button type="button" class="btn btn-primary btn-raised" data-dismiss="modal"><i class="zmdi zmdi-thumb-up"></i> Ok</button>
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