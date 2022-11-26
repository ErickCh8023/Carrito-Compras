<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>xddd</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<style>
	div #button{
	margin-right: 10px;
	}
	div{
	margin-top: 4px;
	}
</style>


<body class="d-flex">
	<div class="row">
        <div class="col-sm-6">
          <div class="card">
            <div class="card-body">
                <form action="Controlador" method="POST">
					<div class="card-body">
						<div class="from-group">
							<label>Datos del Cliente</label>
						</div>
						<div class="from-group d-flex">
							<div class="col-sm-6 d-flex">
							<input type="text" name="codigocliente" class="form-control" placeholder="Codigo">						
							<input type="submit" id="button" name="accion" value="Buscar" class="btn btn-outline-info">						
							</div>
							<div class="col-sm-6">
							<input type="text" name="nombrescliente" class="form-control" placeholder="Nombres">						
							</div>
						</div>
						<div class="from-group">
							<label>Datos Producto</label>
						</div>
						<div class="from-group d-flex">
							<div class="col-sm-6 d-flex">
								<input type="text" name="codigoproducto" class="form-control" placeholder="Codigo">						
								<input type="submit" id="button" name="accion" value="Buscar" class="btn btn-outline-info">						
								</div>
								<div class="col-sm-6">
								<input type="text" name="datosproducto" class="form-control" placeholder="Datos Producto">						
							</div>
						</div>
						<div class="from-group d-flex">
							<div class="col-sm-6">
								<input type="text" name="precio" placeholder="$/0.00" class="form-control">						
							</div>
							<div class="col-sm-3">
								<input type="number" id="button" name="cantidad" placeholder="" class="form-control">						
							</div>
							<div class="col-sm-3">
								<input type="text" name="stock" placeholder="Stock" class="form-control">						
							</div>
						</div>
						<div class="form-group">
							<input type="submit" name="accion" value="Agregar" class="btn btn-outline-info">
						</div>
					</div>
				</form>
            </div>
          </div>
        </div>
        <div class="col-sm-6">
          <div class="card">
            <div class="card-body">
                <div class="d-flex col-sm-5 ml-auto">
                	<label>Numero Serie: </label>
                    <input type="text" name="NroSerie" class="from-control">
                </div>
                <br>
                <table class="table table-hover">
                    <tr>
                        <th>Nro</th>
                        <th>Codigo</th>
                        <th>Descripcion</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>SubTotal</th>
                        <th>Acciones</th>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <div class="card-footer">
            	<input type="text" name="accion" value="Generar Venta" class="btn btn-outline-success">
            	<input type="text" name="accion" value="Cancelar" class="btn btn-danger">
            </div>
          </div>
        </div>
      </div>
	
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>