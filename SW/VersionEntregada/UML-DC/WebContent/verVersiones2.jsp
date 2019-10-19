<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
     <%@page import="datos.Version"%>
     <%@page import="datos.DiagramaDeClase"%>
	<%@page import="funciones.FuncionesNico"%>
     
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<head>
<title>Percepción UML. En esta pagina usted puede acceder a las versiones disponibles o crear una nueva.</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="./css/main.css">
	
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="jquery_plantuml.js"></script>
	
	<script src="http://code.responsivevoice.org/responsivevoice.js"></script>
	
	
	
	  <script type="text/javascript">
          function verClases(i){
        	  
        	  session.setAttribute("idVersion", i);
        	
          }
          
          function borrarVersion(idVersion){
            alert("Acción 2 pulsada");
          }


        </script>
      

	
	

	
</head>



<body>
	<!-- SideBar -->
	<section class="full-box cover dashboard-sideBar">
		<div class="full-box dashboard-sideBar-bg btn-menu-dashboard"></div>
		<div class="full-box dashboard-sideBar-ct">
			<!--SideBar Title -->
			<div class="full-box text-uppercase text-center text-titles dashboard-sideBar-title">
				PERCEPCIÓN UML <i class="zmdi zmdi-close btn-menu-dashboard visible-xs"></i>
			</div>
			<!-- SideBar User info -->
			<div class="full-box dashboard-sideBar-UserInfo">
				<figure class="full-box">
					<img src="./assets/img/avatarOjos.jpg" alt="Logotipo de Percepción UML">
					<figcaption class="text-center text-titles">Desarrollado por y para la UNLa</figcaption>
				</figure>
				
				
			</div>
			
			
			
			<!-- SideBar Menu -->
			<ul class="list-unstyled full-box dashboard-sideBar-Menu">
				<li>
					<a href="inicioVisual.jsp">
						<i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Inicio
					</a>
				</li>
				
				
				
			</ul>
		</div>
	</section>
	
	
	
	

	<!-- Content page-->
	<section class="full-box dashboard-contentPage">
		<!-- NavBar -->
		<nav class="full-box dashboard-Navbar">
			<ul class="full-box list-unstyled text-right">
				<li class="pull-left">
					<a href="#!" class="btn-menu-dashboard"><i class="zmdi zmdi-more-vert"></i></a>
				</li>
				<li>
					<a href="#!" class="btn-Notifications-area">
						<i class="zmdi zmdi-notifications-none"></i>
						<span class="badge">1</span>
					</a>
				</li>
				
				<li>
					<a href="#!" class="btn-modal-help">
						<i class="zmdi zmdi-help-outline"></i>
					</a>
				</li>
			</ul>
		</nav>
		
		

		
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-balance zmdi-hc-fw"></i> Versiones <small>de su diagrama de clase seleccionado</small></h1>
			</div>
			<p class="lead">Elija con que version quiere seguir trabajando o cree una nueva.</p>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					
					  	<li class="active"><a href="#newSchool" data-toggle="tab" accesskey="1"><i class="zmdi zmdi-balance"></i> Sus versiones</a></li>
					  	<li><a href="#newYear" data-toggle="tab" accesskey="2"><i class="zmdi zmdi-calendar-check"></i> Nueva version</a></li>
					  	
					</ul>
					
					
					<div class="tab-content">
					
					
						<div class="tab-pane fade active in" id="newSchool">
						
						<div class="table-responsive">
								<table id="Tabla1" class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Ultima actualizacion</th>
											<th class="text-center">Comentario</th>
											<th class="text-center">Autor</th>
											<th class="text-center">Seguir...</th>
											<th class="text-center">Borrar</th>
										</tr>
									</thead>
									<tbody>
									
									
									    
      <% DiagramaDeClase diagrama= (DiagramaDeClase)request.getAttribute("diagrama"); %>
         <% String contrasenia= (String)request.getAttribute("contrasenia"); %>
           <% String emailCreador= (String)request.getAttribute("emailCreador"); %>
      
      <% //NO tiene versiones
		if (diagrama.getListaVersiones().isEmpty()) {	
			
		}	
		 %>
		 
		 
		  <% //Tiene versiones
		if (!diagrama.getListaVersiones().isEmpty()) {	%>
			
		<% int i = 0 ; %>
									
		<% for (Version version: diagrama.getListaVersiones()){ %>
		
									<% i = i+1; %>
									
									
									
										<tr>
											<td><%= version.getIdVersion() %></td>
											<td><%= FuncionesNico.traerFechaCortaParaHibernate(version.getUltimaActualizacion()) %></td>
											<td><%= version.getComentario() %></td>
											<td><%= version.getQuien() %></td>
											
											
											
											<td>
											
											<form method="POST" action=" /UML-DC/ControladorVerClases">
											
											 <INPUT type="hidden" name="idVersion" value="<%= version.getIdVersion() %>" />
											 <INPUT type="hidden" name="contrasenia" value="<%= contrasenia %>" />
											 <INPUT type="hidden" name="emailCreador" value="<%= emailCreador %>" />
											 
											<button  type="submit"  class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i> </button>
											</form>
											</td>
											
											
											<td>
											<form method="POST" action=" /UML-DC/ControladorBorrarVersion">
											<INPUT type="hidden" name="idVersion" value="<%= version.getIdVersion() %>" />
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
						
						
						<div class="tab-pane fade" id="newYear" >
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									
									   <form method="POST" action=" /UML-DC/ControladorAgregarVersion" >
									    
									     <INPUT type="hidden" name="idDiagrama" value="<%= diagrama.getIdDiagramaDeClase() %>" />
									    
									    	<div class="form-group label-floating" >
											  <label for="Comentario" class="control-label" >Comentario para esta versión:</label>
											  <input class="form-control"  id="Comentario" type="text" name="comentario">
											</div>
											
											<div class="form-group label-floating">
											  <label for="Nombre" class="control-label">Nombre para la versión del diagrama de clases:</label>
											  <input class="form-control"  id="Nombre" type="text" name="quien">
											</div>
											
											
										    <p class="text-center">
										    	<button href="#!" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Guardar</button>
										    </p>
										    
									    </form>
									</div>
								</div>
							</div>
						</div>
						
						
						
					  	<div class="tab-pane fade" id="listYear">
							<div class="table-responsive">
								<table class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Year</th>
											<th class="text-center">Start Date</th>
											<th class="text-center">End Date</th>
											<th class="text-center">Update</th>
											<th class="text-center">Delete</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>2017</td>
											<td>23/01/2017</td>
											<td>07/11/2017</td>
											<td><a href="#!" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></a></td>
											<td><a href="#!" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a></td>
										</tr>
										<tr>
											<td>2</td>
											<td>2016</td>
											<td>23/01/2016</td>
											<td>07/11/2016</td>
											<td><a href="#!" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></a></td>
											<td><a href="#!" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a></td>
										</tr>
										<tr>
											<td>3</td>
											<td>2015</td>
											<td>23/01/2015</td>
											<td>07/11/2015</td>
											<td><a href="#!" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></a></td>
											<td><a href="#!" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a></td>
										</tr>
									</tbody>
								</table>
								<ul class="pagination pagination-sm">
								  	<li class="disabled"><a href="#!">Â«</a></li>
								  	<li class="active"><a href="#!">1</a></li>
								  	<li><a href="#!">2</a></li>
								  	<li><a href="#!">3</a></li>
								  	<li><a href="#!">4</a></li>
								  	<li><a href="#!">5</a></li>
								  	<li><a href="#!">Â»</a></li>
								</ul>
							</div>
					  	</div>
					  	<div class="tab-pane fade" id="newPeriod">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									    <form action="">
									    	<div class="form-group label-floating">
											  <label class="control-label">Name</label>
											  <input class="form-control" type="text">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Status</label>
											  <input class="form-control" type="text">
											</div>
											<div class="form-group">
											  <label class="control-label">Start Date</label>
											  <input class="form-control" type="date">
											</div>
											<div class="form-group">
											  <label class="control-label">End Date</label>
											  <input class="form-control" type="date">
											</div>
											<div class="form-group label-floating">
											  <label class="control-label">Amount</label>
											  <input class="form-control" type="text">
											</div>
											<div class="form-group">
										        <label class="control-label">Year</label>
										        <select class="form-control">
										          	<option>2017</option>
										          	<option>2016</option>
										          	<option>2015</option>
										        </select>
										    </div>
										    <p class="text-center">
										    	<button href="#!" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Save</button>
										    </p>
									    </form>
									</div>
								</div>
							</div>
						</div>
					  	<div class="tab-pane fade" id="listPeriod">
							<div class="table-responsive">
								<table class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Name</th>
											<th class="text-center">Status</th>
											<th class="text-center">Start Date</th>
											<th class="text-center">End Date</th>
											<th class="text-center">Amount</th>
											<th class="text-center">Year</th>
											<th class="text-center">Update</th>
											<th class="text-center">Delete</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>Period 1</td>
											<td>Active</td>
											<td>23/01/2017</td>
											<td>23/03/2017</td>
											<td>$40</td>
											<td>2017</td>
											<td><a href="#!" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></a></td>
											<td><a href="#!" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a></td>
										</tr>
										<tr>
											<td>2</td>
											<td>Period 2</td>
											<td>Active</td>
											<td>24/03/2017</td>
											<td>23/06/2017</td>
											<td>$40</td>
											<td>2017</td>
											<td><a href="#!" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></a></td>
											<td><a href="#!" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a></td>
										</tr>
										<tr>
											<td>3</td>
											<td>Period 3</td>
											<td>Active</td>
											<td>24/06/2017</td>
											<td>23/09/2017</td>
											<td>$40</td>
											<td>2017</td>
											<td><a href="#!" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></a></td>
											<td><a href="#!" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a></td>
										</tr>
									</tbody>
								</table>
								<ul class="pagination pagination-sm">
								  	<li class="disabled"><a href="#!">Â«</a></li>
								  	<li class="active"><a href="#!">1</a></li>
								  	<li><a href="#!">2</a></li>
								  	<li><a href="#!">3</a></li>
								  	<li><a href="#!">4</a></li>
								  	<li><a href="#!">5</a></li>
								  	<li><a href="#!">Â»</a></li>
								</ul>
							</div>
					  	</div>
					</div>
				</div>
			</div>
		</div>
	</section>
		
		
		
		
		
		
		
		
		
		
					

		
		
		
	</section>
	
	

	<!-- Notifications area -->
	<section class="full-box Notifications-area">
		<div class="full-box Notifications-bg btn-Notifications-area"></div>
		<div class="full-box Notifications-body">
		
		
			<div class="Notifications-body-title text-titles text-center">
				Notificaciones <i class="zmdi zmdi-close btn-Notifications-area"></i>
			</div>
			
			
			<div class="list-group">
			  	<div class="list-group-item">
			  	
			  	
				    
				  
				    
				    
				    	
				    
				    
			  	</div>
			  	<div class="list-group-separator"></div>
			  	
			  	
			
			  	
			  	

		</div>
	</section>
	
	
	

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