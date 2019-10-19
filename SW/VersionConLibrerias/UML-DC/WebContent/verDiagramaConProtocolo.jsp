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
	
	 
	<script type="text/javascript">
				function prepHref(linkElement) {
		    var myDiv = document.getElementById('Div_contain_image');
		    var myImage = myDiv.children[0];
		    linkElement.href = myImage.src;
		    

		}
		</script>  
		
		
		
	

	
	<script src='https://code.responsivevoice.org/responsivevoice.js'></script>
	
	
      <% String textoAProcesar = (String)request.getAttribute("textoAProcesar"); %>
             <% String textoAProcesarSinComillas = (String)request.getAttribute("textoAProcesarSinComillas"); %>
        
        
  
	
</head>



<body>
	
	
	
	
	

		
		
		
<!-- Content page -->

<section class="full-box dashboard-contentPage">
		
		
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					
					
					<div class="tab-content">
					
					
						
						
					<script src=http://s.plantuml.com/synchro.js></script>
				<script>
					function compress(a) {
						a = unescape(encodeURIComponent(a));
						GID("im").src = "http://www.plantuml.com/plantuml/img/"
								+ encode64(zip_deflate(a, 9));
								
								document.getElementById("content").innerHTML = "Enviar la imagen por mail ahora";
								
								document.getElementById("link").value = "http://www.plantuml.com/plantuml/img/"+ encode64(zip_deflate(a, 9));
					};
				</script>	
				
				
				<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles"><i class="zmdi zmdi-font zmdi-hc-fw"></i> Protocolo PlantUML </h1>
			</div>
			
		
				
			
		</div>
				
				
				
				 
				 
				 <table >
					<tr>
						<td><form>
						
						
						
						
											
								<button  type=submit
										onclick="compress(GID('inflated').value);return false;" class="btn btn-info btn-raised btn-sm"><i class="zmdi zmdi-floppy"></i>Generar URL de la imagen </button>			 
						
								<textarea class="form-control" id="inflated" cols="20" rows="15" style="font-size:12px; font-type:Arial"><%=textoAProcesarSinComillas %></textarea>
								
								
								
							</form></td>
							
							
							<td> 
								
									<img id="im"
										uml= <%= textoAProcesar %>></td>
										
										
										<td>
										<form method="POST" action=" /UML-DC/ControladorEnviarMailImagen">
										<!--  <a id="content" type="submit"  target="_blank"></a> -->
										
											<INPUT id="link" type="hidden" name="link" />
											<button id="content" type="submit"  class="btn btn-danger btn-raised btn-xs">Aun no se genero la imagen </button>
											</form>
										
										</td>
										
										<td></td>
										
					
					</tr>
				</table>
						
						
					
						<!--  
					<div id="Div_contain_image"><img uml= <%= textoAProcesar %>  ></div>
					
					-->
					
				
						
						
						
						
						
					
					  
					  	
					  
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
			  	
			  	<!--Menu ayuda 1  --> 
			  	<div class="list-group-item">
				   
				    
				      	
				      	<h2 class="list-group-item-heading">Descripcion del DC</h2>
				
				   
				    
				    
				 
				    
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