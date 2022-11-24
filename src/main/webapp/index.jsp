<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<title>Ventas Admin</title>
</head>
<body>
	<div class="container mt-4 col-lg-4">
		<div class="card col-sm-10">
			<div class="card-body">
				<form class="form-sign" action="Validar" method="POST">
					<div class="form-group text-center">
						<h3>LOGIN</h3>
						<img src="img/logo.png" alt="70" width="170" height="70">
						<label>¡Bienvenido!</label>
					</div>
					<div class="form-group">
						<label>Usuario:</label>
						<input type="text" name="txtuser" class="form-control">
					</div>
					<div class="form-group">
						<label>Contraseña:</label>
						<input type="password" name="txtpass" class="form-control">
					</div>
					<input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block">
				</form>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>