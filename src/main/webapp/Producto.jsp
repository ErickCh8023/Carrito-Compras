<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<form action="Controlador?menu=Producto" method="POST">
					<div class="form-group">
						<label>NOMBRE</label>
						<input type="text" value="${pro.getNombre()}" name="txtNombre" class="form-control" required="">
					</div>
					<div class="form-group">
						<label>PRECIO</label>
						<input type="text" value="${pro.getPrecio()}" name="txtPrecio" class="form-control" required="">
					</div>
					<div class="form-group">
						<label>STOCK</label>
						<input type="text" value="${pro.getStock()}" name="txtStock" class="form-control" required="">
					</div>
					<div class="form-group">
						<label>ESTADO</label>
						<input type="text" value="${pro.getEstado()}" name="txtEstado" class="form-control" required="">
					</div>
					<input type="submit" name="accion" value="Agregar" class="btn btn-info">
					<input type="submit" name="accion" value="Actualizar" class="btn btn-success">
				</form>
			</div>
		</div>
		<div class="col-sm-8">
			<table class="table table-hover table-sm caption-top">
			<caption>Lista de Productos</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRE</th>
						<th>PRECIO</th>
						<th>STOCK</th>
						<th>ESTADO</th>
						<th>ACCIONES</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach  var="pro2" items="${listado}">
						<tr>
							<td><c:out value="${pro2.getId()}"/></td>
		                	<td><c:out value="${pro2.getNombre()}"/></td>
		                    <td><c:out value="${pro2.getPrecio()}"/></td>
		                    <td><c:out value="${pro2.getStock()}"/></td>
		                    <td><c:out value="${pro2.getEstado()}"/></td>
		                    <td>
		                    	<a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${pro2.getId()}">Editar</a>
		                        <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${pro2.getId()}">Delete</a>
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