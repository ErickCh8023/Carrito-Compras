<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex">
		<div class="card col-sm-4">
			<div class="card-body">
				<form class="" action="">
					<div class="form-group">
						<label>DNI</label>
						<input type="text" name="txtDni" class="form-control">
					</div>
					<div class="form-group">
						<label>NOMBRE</label>
						<input type="text" name="txtNombre" class="form-control">
					</div>
					<div class="form-group">
						<label>TELEFONO</label>
						<input type="text" name="txtTel" class="form-control">
					</div>
					<div class="form-group">
						<label>ESTADO</label>
						<input type="text" name="txtEstado" class="form-control">
					</div>
					<div class="form-group">
						<label>USER</label>
						<input type="text" name="txtUser" class="form-control">
					</div>
					<input type="submit" name="accion" value="Agregar" class="btn btn-info">
				</form>
			</div>
		</div>
		<div class="col-sm-8">
			<table class="table table-hover table-sm caption-top">
			<caption>Lista de Empleados</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>DNI</th>
						<th>NOMBRE</th>
						<th>TELEFONO</th>
						<th>ESTADO</th>
						<th>USUARIO</th>
						<th>ACCIONES</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="em" items="${empleados}">
					<tr>
						<td>${em.getId()}</td>
						<td>${em.getDni()}</td>
						<td>${em.getNom()}</td>
						<td>${em.getTel()}</td>
						<td>${em.getEstado()}</td>
						<td>${em.getUser()}</td>
						<td>
							<a>Editar</a>
							<a>Delete</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>