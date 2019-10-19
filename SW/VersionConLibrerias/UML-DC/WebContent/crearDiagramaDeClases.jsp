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
	
	

	
</head>



<body>


	<!-- Content page-->
	<div style="height: 100%; overflow-y: scroll;">
		
		
		
		
<!-- Content page -->
		
		
		
		
		
		
		
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Genero un nuevo diagrama de clases </h1>
			</div>
			
		
				
			
		</div>
		
		
		
		
					

		
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					  	<li class="active"><a href="#new" data-toggle="tab">Datos obligatorios</a></li>
					  	
					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade active in" id="new">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									
									
									    <form method="POST" action=" /UML-DC/ControladorCrearDiagrama">
									    
									    	<div class="form-group label-floating">
											  <label for="pass1" class="control-label">e-mail de creacion</label>
											  <input class="form-control" id="pass1" type="text" name="emailCreador">
											</div>
											
											<div class="form-group label-floating">
											  <label for="pass" class="control-label">contraseña</label>
											  <input class="form-control" id="pass" type="text" name="contrasenia">
											</div>
											
									    	<div class="form-group label-floating">
											  <label for="pass3" class="control-label">Titulo del diagrama de clases:</label>
											  <input class="form-control" id="pass3" type="text" name="titulo">
											</div>
											
											
										    <p class="text-center">
										    
										    	<button for="boton1" type="submit" href="#!" id="boton1" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Generar DC</button>
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