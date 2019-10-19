<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
     <%@page import="datos.Version"%>
      <%@page import="datos.Clase"%>
     <%@page import="datos.DiagramaDeClase"%>
     <%@page import="negocio.ClaseABM"%>
     <%@page import="negocio.VersionABM"%>
     <%@page import="negocio.DiagramaDeClaseABM"%>
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
	


	
	<script src='https://code.responsivevoice.org/responsivevoice.js'></script>
	
	

	
	 <% Version version = (Version)request.getAttribute("version"); %>
      <% String texto = (String)request.getAttribute("texto"); %>
        <% String textoOir = (String)request.getAttribute("textoOir"); %>
         <% String textoParaDescargar = (String)request.getAttribute("textoParaDescargar"); %>
           <% String contrasenia = (String)request.getAttribute("contrasenia"); %>
             <% String emailCreador = (String)request.getAttribute("emailCreador"); %>
              <% String protocolo = (String)request.getAttribute("protocolo"); %>
            
        
        
  
	
</head>



<body>
	
	
	
	
	

	
		
		
		
<!-- Content page -->

<div style="height: 100%; overflow-y: scroll;">
		
		
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-balance zmdi-hc-fw"></i> Clases <small>de su  version de DC seleccionado</small></h1>
			</div>
			<p class="lead">Elija con que clase quiere seguir trabajando o cree una nueva.</p>
		</div>
		
		
		
		<form method="POST" action=" /UML-DC/ControladorVerVersiones">
				
								
											
		<INPUT type="hidden" name="emailCreador" value=<%=emailCreador %> />
		<INPUT type="hidden" name="contrasenia" value=<%=contrasenia %> />
		<button type="submit" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Volver atras</button>
		
		</form>
		
		
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
				
				
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					
					  	<li class="active"><a href="#newSchool" data-toggle="tab"><i class="zmdi zmdi-balance"></i> Sus clases</a></li>
					  	<li><a href="#newYear" data-toggle="tab"><i class="zmdi zmdi-calendar-check"></i> Nueva clase</a></li>
					  	<li><a href="#previsual" data-toggle="tab"><i class="zmdi zmdi-calendar-check"></i> Ver DC</a></li>
					  	<li><a href="#envioPorMail" data-toggle="tab"><i class="zmdi zmdi-calendar-check"></i> Enviar por E-mail</a></li>
					  	
					</ul>
					
					
					<div   class="tab-content">
					
					
						<div class="tab-pane fade active in" id="newSchool">
						
						<div class="table-responsive">
								<table id="Tabla1" class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Nombre</th>
											<th class="text-center">Tipo</th>
											<th class="text-center">#Atributos</th>
											<th class="text-center">#Metodos</th>
											<th class="text-center">#Relaciones</th>
											<th class="text-center">Seguir...</th>
											<th class="text-center">Borrar</th>
										</tr>
									</thead>
									<tbody>
									
									
									    
     
      
      
      <% //NO tiene versiones
		if (version.getListaClases().isEmpty()) {	
			
		}	
		 %>
		 
		 
		  <% //Tiene versiones
		if (!version.getListaClases().isEmpty()) {	
		ClaseABM claseabm = new ClaseABM();%>
			
		
									
		<% for (Clase claseParcial: version.getListaClases()){ %>
		
									<%  
									int cantiAtributos = 0;
									int cantiRelaciones= 0;
									int cantiMetodos= 0;
									
									
									int idClase = claseParcial.getIdClase();
									
									
									Clase claseConAtributos =  claseabm.traerClaseYListaAtributos(idClase);
									Clase claseConMetodos = claseabm.traerClaseYListaMetodos(idClase);
									Clase claseConRelaciones =  claseabm.traerClaseYListaRelaciones(idClase);
									
									
								
									
									if(!claseConAtributos.getListaAtributos().isEmpty()) {
								cantiAtributos = claseConAtributos.getListaAtributos().size();}
									
									
									if(!claseConRelaciones.getListaRelaciones().isEmpty()) {
								cantiRelaciones = claseConRelaciones.getListaRelaciones().size();}
								
									
									if(!claseConMetodos.getListaMetodos().isEmpty()){
								cantiMetodos = claseConMetodos.getListaMetodos().size();}
									
								
									
									
									%>
										<tr>
											<td><%= claseParcial.getIdClase() %></td>
											<td><%= claseParcial.getNombre() %></td>
											<td><%= claseParcial.getTipo() %></td>
											<td><%= cantiAtributos %></td>
											<td><%= cantiMetodos %></td>
											<td><%= cantiRelaciones %></td>
											
											
											
											<td>
											
											<form method="POST" action=" /UML-DC/ControladorVerListasDeLaClase">
											
											 <INPUT type="hidden" name="idClase" value="<%= claseParcial.getIdClase() %>" />
											
											<button  type="submit"  class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i> </button>
											</form>
											</td>
											
											
											<td>
											<form method="POST" action=" /UML-DC/ControladorBorrarClase">
											<INPUT type="hidden" name="idClase" value="<%= claseParcial.getIdClase() %>" />
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
						
						
						
				<div class="tab-pane fade" id="envioPorMail">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									
									
									    <form method="POST" action=" /UML-DC/ControladorEnviarPorMail">
									    
									     <INPUT type="hidden" name="idVersion" value="<%= version.getIdVersion() %>" />
									     <INPUT type="hidden" name="textoOir" value="<%=textoOir%>" />
							
									     
									     <INPUT type="hidden" name="protocolo" value="<%= protocolo %>" /> 
									  
									     
									     <INPUT type="hidden" name="url" value="https://code.responsivevoice.org/getvoice.php?t=<%=textoParaDescargar%>&tl=es-ES" />
									    
									    	<div class="form-group label-floating">
											  <label class="control-label">Enviar a:</label>
											  <input class="form-control" type="text" name="enviarA" required>
											</div>
											
											
											<div class="form-group label-floating">
											  <label class="control-label">Asunto:</label>
											  <input class="form-control" type="text" name="asunto">
											</div>
											
											
											<div class="form-group label-floating">
											  <label class="control-label">Enviado por:</label>
											  <input class="form-control" type="text" name="enviadoPor" required>
											</div>
											
											
											
											
										    <p class="text-center">
										    	<button type="submit" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Enviar e-mail</button>
										    </p>
										    
									    </form>
									    
									    
									    
									</div>
								</div>
							</div>
						</div>
						
						
						
						
						
						<div class="tab-pane fade" id="newYear">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									
									
									    <form method="POST" action=" /UML-DC/ControladorAgregarClase">
									    
									     <INPUT type="hidden" name="idVersion" value="<%= version.getIdVersion() %>" />
									    
									    	<div class="form-group label-floating">
											  <label class="control-label">Nombre de la Clase:</label>
											  <input class="form-control" type="text" name="nombre" required>
											</div>
											
											<div class="form-group">
										        <label class="control-label">Tipo:</label>
										        <select class="form-control" name="tipo">
										        	<option>Publica</option>
										          	<option>Privada</option>
										          	<option>Enum</option>
										          	<option>Abstracta</option>
										          	<option>Interface</option>
										          	<option>Enum</option>
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
						
						
							<div class="tab-pane fade" id="previsual">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									
									
									<input onclick='responsiveVoice.speak("<%=textoOir%>", "Spanish Female");' type='button' value='Reproducir' />
									<input onclick=' responsiveVoice.pause();' type='button' value='Pausar' />
									<input onclick=' responsiveVoice.resume();' type='button' value='Seguir' />
									<input onclick='responsiveVoice.cancel();' type='button' value='Cancelar' />
									
									
									<li>
									
								
									
									
					<a href="https://code.responsivevoice.org/getvoice.php?t=<%=textoParaDescargar%>&tl=es-ES"  target="_blank">
						<i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Descargar Audio
					</a>
					<a> 
					</a>
				</li>
				
					
									
									
									
					
									   
									
									
									<img uml= <%=texto %>     > 
									
									
									
									
									
									
								
									
									
									
									
									
								
									    
									</div>
								</div>
							</div>
						</div>
						
						
						
						
						
						
						
						
						
						
					  
					  	
					  	
					</div>
				</div>
			</div>
		</div>

		
		
		
		
		
		</div>
	

	<!-- Notifications area -->
	
	
	
	

	<!-- Dialog help -->
	<div class="modal fade"  role="dialog" id="Dialog-Help">
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