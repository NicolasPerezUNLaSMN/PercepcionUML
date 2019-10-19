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
<title>Enviar su diagrama de clases</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="./css/main.css">
	
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript" src="jquery_plantuml.js"></script>
	


	
	<script src='https://code.responsivevoice.org/responsivevoice.js'></script>
	
	

	
	 <% String link = (String)request.getAttribute("link"); %>
   
            
        
        
  
	
</head>



<body>
	
	
	
	
	

	
		
		
		
<!-- Content page -->

<div style="height: 100%; overflow-y: scroll;">
		
		
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-balance zmdi-hc-fw"></i> Envio <small>su imagen se genero correctamente y puede ser enviada</small></h1>
			</div>
			<p class="lead">Complete los datos del envio</p>
		</div>
		
		
		
		
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
				
				
					<ul class="nav nav-tabs" style="margin-bottom: 15px;">
					
					  	<li class="active"><a href="#newSchool" data-toggle="tab"><i class="zmdi zmdi-balance"></i> Datos envio</a></li>
					  
					  	
					</ul>
					
					
					<div   class="tab-content">
					
					
						<div class="tab-pane fade active in" id="newSchool">
						
						
						
									    <form method="POST" action=" /UML-DC/ControladorEnviarPorMailImagen">
									    
									     <INPUT type="hidden" name="link" value="<%= link %>" />
									    
							
									  
									     
									     
									    
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