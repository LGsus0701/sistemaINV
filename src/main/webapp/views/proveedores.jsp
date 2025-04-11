<%@page import="models.Proveedor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema - Proveedores</title>
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
					<li class="mb-2"><a href="/SistemaINV/productos" class="block p-2 hover:bg-blue-700 rounded">Productos</a></li>
					<li class="mb-2"><a href="/SistemaINV/categorias" class="block p-2 hover:bg-blue-700 rounded">Categorías</a></li>
					<li class="mb-2"><a href="/SistemaINV/compras" class="block p-2 hover:bg-blue-700 rounded">Compras</a></li>
					<li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Ingresos</a></li>
					<li class="mb-2"><a href="/SistemaINV/salidas" class="block p-2 hover:bg-blue-700 rounded">Salidas</a></li>
					<li class="mb-2"><a href="/SistemaINV/proveedores" class="block p-2 bg-blue-700 rounded-md cursor-pointer border border white border-solid">Proveedores</a></li>
					<li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Reportes</a></li>
				</ul>
			</nav>
		</aside>

		<main class="p-4 w-full">
		    <h2 class="text-2xl font-bold mb-4">Listado de Proveedores</h2>
			<!-- Tabla de Proveedores -->
			<div class="w-full overflow-x-auto">
				<table class="min-w-full bg-white border border-gray-300 rounded-md shadow-md">
					<thead class="bg-orange-200">
						<tr>
<!-- 							<th class="px-4 py-2 border">#</th>
 -->						<th class="px-4 py-2 border">nombre</th>
							<th class="px-4 py-2 border">RUC</th>
							<th class="px-4 py-2 border">correo</th>
							<th class="px-4 py-2 border">telefono</th>
							<th class="px-4 py-2 border">direccion</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores");
						if (proveedores != null && !proveedores.isEmpty()) {
							for (Proveedor proveedor : proveedores) {
							
										
						%>
						
						
						<tr class="hover:bg-gray-100 text-center">
						
						
							
							<td class="px-4 py-2 border text-center"><%= proveedor.getNombreComercial() %></td>
							<td class="px-4 py-2 border text-center"><%= proveedor.getRuc() %></td>
							<td class="px-4 py-2 border text-center"><%= proveedor.getCorreo() %></td>
							<td class="px-4 py-2 border text-center"><%= proveedor.getTelefono() %></td>
							<td class="px-4 py-2 border text-center"><%= proveedor.getDireccion() %></td>
							<td class="px-4 py-2 border text-center">
						</tr>
						<%
							}
						} else {
						%>
						<tr>
							<td colspan="6" class="px-4 py-2 text-center border">No se encontraron proveedores</td>
						</tr>
						<% } %>
					</tbody>
				</table>
			</div>

			<!-- Mostrar total de registros -->
			<div class="mt-4 text-center font-semibold">
				Total de proveedores:
				<%= (proveedores != null) ? proveedores.size() : 0 %>
			</div>
		</main>
	</div>
</body>
</html>
