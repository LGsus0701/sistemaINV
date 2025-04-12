<%@page import="models.Ingreso"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema - Ingresos</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
	<div class="flex h-screen">
		<!-- Sidebar -->
		<aside class="w-64 bg-blue-900 text-white p-5">
			<h1 class="text-2xl font-bold mb-5">Inventario</h1>
			<nav>
				<ul>
					<li class="mb-2"><a href="/SistemaINV" class="block p-2 hover:bg-blue-700 rounded">Inicio</a></li>
					<li class="mb-2"><a href="/SistemaINV/productos" class="block p-2 hover:bg-blue-700 rounded">Productos</a></li>
					<li class="mb-2"><a href="/SistemaINV/categorias" class="block p-2 hover:bg-blue-700 rounded">Categorias</a></li>
					<li class="mb-2"><a href="/SistemaINV/compras" class="block p-2 hover:bg-blue-700 rounded">Compras</a></li>
					<li class="mb-2"><a href="/SistemaINV/ingresos" class="block p-2 hover:bg-blue-700 rounded bg-blue-800">Ingresos</a></li>
					<li class="mb-2"><a href="/SistemaINV/salidas" class="block p-2 hover:bg-blue-700 rounded">Salidas</a></li>
					<li class="mb-2"><a href="/SistemaINV/proveedores" class="block p-2 hover:bg-blue-700 rounded">Proveedores</a></li>
					<li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Reportes</a></li>
				</ul>
			</nav>
		</aside>

		<main class="p-4 w-full">
			<h2 class="text-2xl font-bold mb-4">Listado de Ingresos</h2>

			<!-- Tabla de Ingresos -->
			<div class="w-full overflow-x-auto">
				<table class="min-w-full bg-white border border-gray-300 rounded-md shadow-md">
					<thead class="bg-blue-200">
						<tr>
							<th class="px-4 py-2 border">#</th>
							<th class="px-4 py-2 border">Fecha Ingreso</th>
							<th class="px-4 py-2 border">ID Compra</th>
							<th class="px-4 py-2 border">Fecha Creación</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Ingreso> ingresos = (List<Ingreso>) request.getAttribute("ingresos");
						if (ingresos != null && !ingresos.isEmpty()) {
							int index = 1;
							for (Ingreso ingreso : ingresos) {
						%>
						<tr class="hover:bg-gray-100 text-center">
							<td class="px-4 py-2 border"><%=index++%></td>
							<td class="px-4 py-2 border"><%=ingreso.getFechaIngreso()%></td>
							<td class="px-4 py-2 border"><%=ingreso.getIdCompra()%></td>
							<td class="px-4 py-2 border"><%=ingreso.getFechaCreacion()%></td>
						</tr>
						<%
							}
						} else {
						%>
						<tr>
							<td colspan="4" class="px-4 py-2 text-center border">No se encontraron registros</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>

			<!-- Mostrar total de registros -->
			<div class="mt-4 text-center font-semibold">
				Total registros: <%= (ingresos != null) ? ingresos.size() : 0 %>
			</div>
		</main>
	</div>
</body>
</html>
