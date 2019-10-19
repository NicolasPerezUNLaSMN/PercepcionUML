<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
    
    

<%@page import="datos.DiagramaDeClase"%>
<%@page import="negocio.DiagramaDeClaseABM"%>
<%@page import= "java.util.List" %>
     
    


   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="es">
<head>
	<title>Percepción UML. Bienvenido al portal principal. Recuerde que posee algunos atajos como:
	1- Abrir diagrama ya existente, 2- Crear un nuevo diagrama, 3- Escriba un diagrama con nuestro protocolo</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="./css/main.css">
	
	
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">

<style>
 .fa-facebook-square:hover {
 color:#3B5998;
 }
 .fa-twitter-square:hover {
 color:#55acee;
 }
 .fa-google-plus-square:hover{
 color:#dd4b39;
 }
 .fa-linkedin-square:hover{
 color:#0177B5;
 }
 .fa-facebook-square {
 font-size: 52px;
 color: gray;
 }
 .fa-twitter-square {
 font-size: 52px;
 color: gray;
 }
 .fa-google-plus-square {
 font-size: 52px;
 color: gray;
 }
 .fa-linkedin-square {
 font-size: 52px;
 color: gray;
 }
 </style>
	
	
</head>
<body>


	<!-- 
	<section class="full-box cover dashboard-sideBar">
		<div class="full-box dashboard-sideBar-bg btn-menu-dashboard"></div>
		<div class="full-box dashboard-sideBar-ct">
			
			<div class="full-box text-uppercase text-center text-titles dashboard-sideBar-title">
				Percepción UML <i class="zmdi zmdi-close btn-menu-dashboard visible-xs"></i>
			</div>
			
			<div class="full-box dashboard-sideBar-UserInfo">
				<figure class="full-box">
					<img src="./assets/img/avatarOjos.jpg" alt="Logotipo de Percepción UML">
					<figcaption class="text-center text-titles">Desarrollado por y para la UNLa</figcaption>
				</figure>
				
				
			</div>
			
			
			
			
			<ul class="list-unstyled full-box dashboard-sideBar-Menu">
				<li>
					
					
					
					<a href=""><i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i>Documentación</a>
					<a href=""><i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Manual del usuario</a>
					<a href=""> <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i>Video tutorial</a>
					<a href=""> <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i>Audio explicativo</a>
					<a href=""> <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i>Ejemplo de protocolo</a>
					<a href=""> <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i>Agradecimientos</a>
					<a href=""> <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i>Paginas amigas</a>
					
					
				</li>
				
				
				
			</ul>
		</div>
	</section>
	
	-->
	
	
	
	

	<!-- Content page-->
	<section class="full-box dashboard-contentPage">
		
		
			
		
		
		<!-- Content page -->
		<div class="container-fluid">
			<div class="page-header">
			  <h1 class="text-titles">Creación de Diagramas de Clases <small>Elija interface gráfica o protocolo de texto</small></h1>
			</div>
		</div>
		
		
		<div class="full-box text-center" style="padding: 30px 10px;">
		
		
		<a href="elegirDiagramaDeClases.jsp"   accesskey="1"> 
			<article class="full-box tile">
	  
				<div class="full-box tile-title text-center text-titles text-uppercase">
					Abrir DC existente
				</div>
				
				
				
				<div class="full-box tile-icon text-center">
					<i class="zmdi zmdi-cloud-download"></i>
					
				</div>
				
				
		
			<% DiagramaDeClaseABM dabm = new DiagramaDeClaseABM (); %>
		
		<% int cantidad = dabm.traerDiagramaDeClase().size(); %>
				
				
				<div class="full-box tile-number text-titles">
					<p class="full-box"><%=cantidad %> </p>
					<small>Disponibles</small>
				</div>
				
				
				
				
			</article>
			</a>
			
			
			
			<a href="crearDiagramaDeClases.jsp" accesskey="2"> 
			<article class="full-box tile">
				<div class="full-box tile-title text-center text-titles text-uppercase">
					Crear nuevo Diagrama
				</div>
				<div class="full-box tile-icon text-center">
					<i class="zmdi zmdi-puzzle-piece"></i>
				</div>
				
			</article>
			</a>
			
			
			<a href="escribirDiagramaDeClases.jsp"  accesskey="3"> 
				<article class="full-box tile">
				<div class="full-box tile-title text-center text-titles text-uppercase">
					Escribir Diagrama de Clases
				</div>
				
				<div class="full-box tile-number text-titles">
					<p class="full-box">Edíte</p>
					<small>un simple texto</small>
				</div>
			</article>
			</a>
			
			
			
		<div>
		
		       
					<a href="https://1drv.ms/w/s!AgB0dw0E7wKakKZxst_5P4bC7rLQiw"><i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i>Documentación</a>
					<a href="https://1drv.ms/f/s!AgB0dw0E7wKakII-Et0RiYy4BXlChw"><i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i> Manual del usuario</a>
					<a href="https://1drv.ms/f/s!AgB0dw0E7wKakLFOPr7z30uMcRqAaA"> <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i>Video tutorial</a>
					<a href="https://1drv.ms/f/s!AgB0dw0E7wKakLFQy0RC3_Y9foCgfw"> <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i>Audio explicativo</a>
					<a href="https://1drv.ms/f/s!AgB0dw0E7wKakLFSIKSP6eW_2eNnAQ"> <i class="zmdi zmdi-view-dashboard zmdi-hc-fw"></i>Ejemplo de protocolo</a>
					
					
			</div>		
				
			
			
			
			
		</div>
		
		
		
		<center><a href="https://www.facebook.com/groups/546266565848437 "target="_blank" class="fa fa-facebook"></a>
 <a href="https://www.instagram.com/percepcionuml/" target="_blank" class="fa fa-instagram"></a>
 <a href="https://plus.google.com/102793582451064465757" target="_blank" class="fa fa-google-plus"></a>
  
   <a href="http://www.unla.edu.ar/" rel="home" target="_blank">
				                    <img src="http://campus.unla.edu.ar/wp-content/uploads/2015/03/logo.png" alt="Universidad Nacional de Lanús" title="UNLa">
								</a></center>
  
 
  
                               
			          
			        
		
	</section>
	
	

	
	
	
	           
                  

	
	
	<!--====== Scripts -->
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