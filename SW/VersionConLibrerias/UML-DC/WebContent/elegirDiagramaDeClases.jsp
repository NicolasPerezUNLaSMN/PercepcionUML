<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    <%@page import="test.PrimerDiagrama"%>
     <%@page import="datos.Clase"%>
     
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<head>

<title>Percepción UML. Para elegir un diagrama debe ingresar el e-mail y la contraseña. Para ingresar los datos puede presionar alt mas 1. Tambien puede volver hacia atras apretanto alt  mas a. </title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="./css/main.css">
	
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="jquery_plantuml.js"></script>
	
	<script src="http://code.responsivevoice.org/responsivevoice.js"></script>
	
	

	
</head>



<body>
	
	
	
	
	

		
<!-- Content page -->
		
		
		
		
		
		
		
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Elija su diagrama de clases </h1>
			</div>
			
		
				
			
		</div>
		
		
		<a href="inicioVisual.jsp" accesskey="a">
		<button type="submit" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Volver al inicio</button>
		</a>
		
		
		
		
					

		
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					  	<li class="active"><a href="#new"  data-toggle="tab" >Datos de ingreso</a></li>
					  	
					</ul>
					
				
						<div class="tab-pane fade active in" id="new">
							<div class="container-fluid">
								<div class="row">
									<div class="col-xs-12 col-md-10 col-md-offset-1">
									
									
									    <form  method="POST" action=" /UML-DC/ControladorVerVersiones">
									       
									       
									    	<div class="form-group label-floating" >
									    	
											  <label  accesskey="1" for="email" class="control-label">e-mail de acceso</label>
											  <input class="form-control" id="email"  type="text" name="emailCreador">
											  
											</div>
											
									    	<div class="form-group label-floating">
									    	
											  <label for="pass" class="control-label">contraseña</label>
											  <input class="form-control"  id="pass" type="text" id="Contraseña" name="contrasenia">
											</div>
											
											
										    <p class="text-center">
										    
										    	<button type="submit" href="#!" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i> Buscar diagrama de clases</button>
										    </p>
										    
									    </form>
									    
									    
									    
									    		
		
		
									    
									   				    
									    
									</div>
								</div>
							</div>
						</div>
						
					
					</div>
				</div>
			</div>
	
		
		

		
		
		
	</section>
	
	

	
	
	
	

	
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