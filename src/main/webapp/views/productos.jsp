<%@page import="models.Categoria"%>
<%@page import="models.Producto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="models.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema - Productos</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
	<div class="flex h-screen">
		<!-- Sidebar -->
		<aside class="w-64 bg-blue-900 text-white p-5">
			<h1 class="text-2xl font-bold mb-5">Inventario</h1>
			
			
			<nav>
				<ul>
					<li class="mb-2"><a href="/SistemaINV" class="block p-2 bg-blue-700 rounded">Inicio</a></li>
					<li class="mb-2"><a href="/SistemaINV/productos" class="block p-2 hover:bg-blue-700 rounded-md cursor-pointer border border-white border-solid">Productos</a></li>
					<li class="mb-2"><a href="/SistemaINV/categorias" class="block p-2 hover:bg-blue-700 rounded">Categorias</a></li>
					<li class="mb-2"><a href="/SistemaINV/compras" class="block p-2 hover:bg-blue-700 rounded">Compras</a></li>
					<li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Ingresos</a></li>
					<li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Salidas</a></li>
					<li class="mb-2"><a href="/SistemaINV/proveedores" class="block p-2 hover:bg-blue-700 rounded">Proveedores</a></li>
					<li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Reportes</a></li>
				</ul>
			</nav>
		</aside>

		<main class="p-4 w-full">
		    <h2 class="text-2xl font-bold mb-4">Listado de Productos</h2>
		

			<!-- Tabla de Productos -->
			<div class="w-full overflow-x-auto">
				<table class="min-w-full bg-white border border-gray-300 rounded-md shadow-md">
					<thead class="bg-blue-200">
						<tr>
							<th class="px-4 py-2 border">Código</th>
							<th class="px-4 py-2 border">Nombre</th>
							<th class="px-4 py-2 border">Stock Actual</th>
							<th class="px-4 py-2 border">Stock Mínimo</th>
							<th class="px-4 py-2 border">Precio</th>
							<th class="px-4 py-2 border">Moneda</th>
							<th class="px-4 py-2 border">Categoria</th>
							
						</tr>
					</thead>
					<tbody>
						<% 
                        List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                        if (productos != null && !productos.isEmpty()) {
                            for(Producto producto: productos) { 
                        %>
                        
                        
                        
						<tr class="hover:bg-gray-100">
							<td class="px-4 py-2 border text-center"><%= producto.getCodigo() %></td>
							<td class="px-4 py-2 border text-center"><%= producto.getNombre() %></td>
							<td class="px-4 py-2 border text-center"><%= producto.getStockActual() %></td>
							<td class="px-4 py-2 border text-center"><%= producto.getStockMinimo() %></td>
							<td class="px-4 py-2 border text-center"><%= producto.getPrecio() %></td>
							<td class="px-4 py-2 border text-center"><%= producto.getMoneda() %></td>
							<td class="px-4 py-2 border text-center"><%= producto.getNombreCategoria() %></td>
							<td class="px-4 py-2 border text-center">
								
							</td>
						</tr>
						<% } %>
						<% } else { %>
						<tr>
							<td colspan="7" class="px-4 py-2 text-center border">No se encontraron registros</td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>

			<!-- Mostrar total de registros -->
			<div class="mt-4 text-center font-semibold">
				Total registros:
				<%= (productos != null) ? productos.size() : 0 %></div>
		</main>
	</div>



</body>
</html>
