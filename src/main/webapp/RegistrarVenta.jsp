<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

    <title>Document</title>

</head>
<body>
    <div class="row">
        <div class="col-sm-6">
          <div class="card">
            <div class="card-body">
                <form action="Controlador?menu=NuevaVenta" method="POST">
					<div class="card-body">
						<div class="from-group">
							<label>Datos del Cliente</label>
						</div>
						<div class="from-group d-flex">
							<div class="col-sm-6 d-flex">
							<input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="Codigo">						
							<input type="submit" id="button" name="accion" value="BuscarCliente" class="btn btn-outline-info">						
							</div>
							<div class="col-sm-6">
							<input type="text" name="nombrescliente" value="${c.getNombres()}" class="form-control" placeholder="Nombres">						
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
                <label>Nro: </label>
                <div class="col-sm-6">
                    <input type="text" name="NroSerie" class="from-control col-sm-12">
                </div>
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
          </div>
        </div>
      </div>

    
    
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>