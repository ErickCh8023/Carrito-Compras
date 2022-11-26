<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<title>Ventas Admin</title>
	<style>
	ul li{
		margin-left: 10px;
	}
	</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-info">
		  <div class="container-fluid">
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a style="margin-left: 10px" class="btn btn-outline-dark" href="#">Home</a>
		         </li>
		         <li class="nav-item">
		          <a class="btn btn-outline-dark" href="Controlador?menu=Producto" target="myFrame">Producto</a> <%-- Target hace referencia al iframe --%>
		         </li>
		         <li class="nav-item">
		          <a class="btn btn-outline-dark" href="Controlador?menu=Empleado&accion=Listar" target="myFrame">Empleado</a>
		         </li>
		         <li class="nav-item">
		          <a class="btn btn-outline-dark" href="Controlador?menu=Cliente" target="myFrame">Clientes</a>
		         </li>
		         <li class="nav-item">
		          <a class="btn btn-outline-dark" href="Controlador?menu=NuevaVenta" target="myFrame">Nueva Venta</a>
		         </li>
		      </ul>
						<div class="dropdown">
						  <button class="btn btn-outline-dark dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
						   ${usuario.getNom()}
						  </button>
						  <ul class="dropdown-menu text-center">
						    <a class="dropdown-item" href="#"> <img  src="img/user.png" alt="50px" width="50px"></a>
						    <li><a class="dropdown-item" href="#">${usuario.getUser()}</a></li>
						    <li><a class="dropdown-item" href="#">usuario@gmail.com</a></li>
							<form action="validar" method="POST">
									<button  name="accion" value="Salir" class="dropdown-item" href="#">Salir</button>
							</form>
						  </ul>
						</div>					
		    </div>
		  </div>
	</nav>
	<div class="m-4" style="height: 550px">
		<iframe name="myFrame" style="height: 100%; width: 100%; border: none "></iframe>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>