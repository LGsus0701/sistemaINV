<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.util.*, models.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Nueva Salida</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 p-6">

    <div class="max-w-xl mx-auto bg-white p-6 rounded shadow-md">
        <h2 class="text-2xl font-bold mb-4">Registrar Nueva Salida</h2>

        <form action="/SistemaINV/salidas" method="post">
            <div class="mb-4">
                <label class="block font-semibold">Fecha Salida:</label>
                <input type="date" name="fecha_salida" class="w-full border p-2 rounded" required>
            </div>

            <div class="mb-4">
                <label class="block font-semibold">Orden de Trabajo:</label>
                <input type="text" name="codigo_ot" class="w-full border p-2 rounded" required>
            </div>

            <div class="mb-4">
                <label class="block font-semibold">Producto:</label>
                <select name="id_producto" class="w-full border p-2 rounded" required>
                    <option value="">Seleccione un producto</option>
                    <%
                        List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                        if (productos != null) {
                            for (Producto producto : productos) {
                    %>
                                <option value="<%= producto.getIdProducto() %>">
                                    <%= producto.getNombre() %>
                                </option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>

            <div class="mb-4">
                <label class="block font-semibold">Cantidad:</label>
                <input type="number" name="cantidad" class="w-full border p-2 rounded" min="1" required>
            </div>

            <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">Guardar</button>
            <a href="/SistemaINV/salidas" class="ml-4 text-blue-600 hover:underline">Cancelar</a>
        </form>
    </div>

</body>
</html>
