<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    <%@page import="test.PrimerDiagrama"%>
     <%@page import="datos.Clase"%>
     
    
    
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
	
	
	
	<% PrimerDiagrama primerDiagrama2 = new PrimerDiagrama();
	Clase c2 = primerDiagrama2.instanciarClase();%>
	<%String a = c2.explicacionDeLaClase3();%>
	
	
	<script type="text/javascript">
	
	function miFuncion() {
		
		var nombre = "<%=a%>";
		responsiveVoice.speak(nombre, "Spanish Female");
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
				Usuario V <i class="zmdi zmdi-close btn-menu-dashboard visible-xs"></i>
			</div>
			<!-- SideBar User info -->
			<div class="full-box dashboard-sideBar-UserInfo">
				<figure class="full-box">
					<img src="./assets/img/avatarOjos.jpg" alt="UserIcon">
					<figcaption class="text-center text-titles">Nicolas Perez</figcaption>
				</figure>
				
				<ul class="full-box list-unstyled text-center">
					<li>
						<a href="#!">
							<i class="zmdi zmdi-settings"></i>
						</a>
					</li>
					<li>
						<a href="#!" class="btn-exit-system">
							<i class="zmdi zmdi-power"></i>
						</a>
					</li>
				</ul>
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
		
		
		
<!-- Content page -->
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Ver y Modificar DC <small>ya existentes</small></h1>
			</div>
			<p class="lead">Por medio de este modulo usted podra ver el DC elegido, escucharlo, y modificarlo. Luego podra guardar una nueva version.</p>
		</div>
		
		
		<% PrimerDiagrama primerDiagrama = new PrimerDiagrama();
		Clase c1 = primerDiagrama.instanciarClase();%>
		
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Descripcion <small>Soporte sonoro</small></h1>
			</div>
			<p class="lead"> <%= c1.explicacionDeLaClase()%></p>
			
			
			
			
			<script type="text/javascript">miFuncion();</script>
			
			
		</div>
		
		
		
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Su diagrama de clases <small>imagen:</small></h1>
			</div>
			
			<center>
				<img a uml="
			@startuml

			title Diagrama de Prueba - V1.001


			class Estudiante {
  			-Int edad
  			-String nombre
  			+boolean esMayorDeEdad(int edad)
			}

			class Materia



			Materia  &quot;1&quot; o-- &quot;..*&quot; Estudiante: Agregacion


			@enduml
			"
			
			></center>
				
				
				
			
			
			
			
			
			

			
				
			
		</div>
		
		
		
		
					

		
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					  	<li class="active"><a href="#new" data-toggle="tab">Nueva Clase</a></li>
					  	<li><a href="#list" data-toggle="tab">Lista de Clases</a></li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade active in" id="new">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									    <form action="">
									    	<div class="form-group label-floating">
											  <label class="control-label">Numero</label>
											  <input class="form-control" type="text">
											</div>
									    	<div class="form-group label-floating">
											  <label class="control-label">Nombre</label>
											  <input class="form-control" type="text">
											</div>
											<div class="form-group">
										      <label class="control-label">Tipo</label>
										        <select class="form-control">
										          <option>Publica</option>
										          <option>Privada</option>
										          <option>Abstracta</option>
										          <option>interface</option>
										        </select>
										    </div>
											<div class="form-group">
										      <label class="control-label">�Agregarla?</label>
										        <select class="form-control">
										          <option>Si</option>
										          <option>No</option>
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
					  	<div class="tab-pane fade" id="list">
							<div class="table-responsive">
								<table class="table table-hover text-center">
									<thead>
										<tr>
											<th class="text-center">#</th>
											<th class="text-center">Numero de Clase</th>
											<th class="text-center">Nombre</th>
											<th class="text-center">Tipo</th>
											<th class="text-center">Cant atributos</th>
											<th class="text-center">Cant metodos</th>
											<th class="text-center">Cant relaciones</th>
											<th class="text-center">Modificar</th>
											<th class="text-center">Borrar</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>1</td>
											<td>Estudiante</td>
											<td>Publica</td>
											<td>2</td>
											<td>1</td>
											<td>1</td>
											<td><a href="#!" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i></a></td>
											<td><a href="#!" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a></td>
										</tr>
										
									</tbody>
								</table>
								<ul class="pagination pagination-sm">
								  	<li class="disabled"><a href="#!">�</a></li>
								  	<li class="active"><a href="#!">1</a></li>
								  	
								  	<li><a href="#!">�</a></li>
								</ul>
							</div>
					  	</div>
					</div>
				</div>
			</div>
		</div>
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
				    <div class="row-action-primary">
				      	<i class="zmdi zmdi-alert-triangle"></i>
				    </div>
				    <div class="row-content">
				      	<div class="least-content">1m</div>
				      	<h4 class="list-group-item-heading">Nuevo DC</h4>
				      	<p class="list-group-item-text">Su dise�o se ve asi: </p>
				    </div>
				    
				    
				    	<img a uml="
			@startuml

			title Diagrama de Prueba - V1.001


			class Estudiante {
  			-Int edad
  			-String nombre
  			+boolean esMayorDeEdad(int edad)
			}

			class Materia



			Materia  &quot;1&quot; o-- &quot;..*&quot; Estudiante: Agregacion


			@enduml
			"
			
			>
				    
				    
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