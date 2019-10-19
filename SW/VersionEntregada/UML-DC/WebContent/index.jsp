<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Inicio</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="./css/main.css">

</head>
<body  class="cover" style="background-image: url(./assets/img/inicio.jpg);">

	<form action="inicioVisual.jsp" method="" autocomplete="off" class="full-box logInForm">
		
		<p class="text-center text-muted"><i class="zmdi zmdi-account-circle zmdi-hc-5x"></i></p>
		<p class="text-center text-muted text-uppercase">Inicia sesi�n en modo Visi�n</p>
		
		<div class="form-group text-center">
			<input type="submit" value="Iniciar sesi�n V" class="btn btn-raised btn-danger">
		</div>
	</form>
	
	
	<form action="inicioVisual.jsp" method="" autocomplete="off" class="full-box logInForm2">
		
		<p class="text-center text-muted"><i class="zmdi zmdi-account-circle zmdi-hc-5x"></i></p>
		<p class="text-center text-muted text-uppercase">Inicia sesi�n en modo Audisi�n</p>
		
		<div class="form-group text-center">
			<input type="submit" value="Iniciar sesi�n A" class="btn btn-raised btn-danger">
		</div>
	</form>
	
	
	<!--====== Scripts -->
	<script src="./js/jquery-3.1.1.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/material.min.js"></script>
	<script src="./js/ripples.min.js"></script>
	<script src="./js/sweetalert2.min.js"></script>
	<script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="./js/main.js"></script>
	<script>
		$.material.init();
	</script>







</body>
</html>