<%@page import="models.Producto"%>
<%@page import="models.Proveedor"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Compra</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
    <div class="max-w-xl mx-auto mt-10 bg-white p-6 rounded shadow-md">
        <h2 class="text-2xl font-bold mb-6">Registrar Compra</h2>
        <form action="/SistemaINV/compras" method="post" class="space-y-4">
            <div>
                <label class="block font-medium mb-1">Proveedor</label>
                <select name="id_proveedor" class="w-full border p-2 rounded">
                    <%
                        List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores");
                        for (Proveedor p : proveedores) {
                    %>
                        <option value="<%= p.getIdProveedor() %>"><%= p.getNombreComercial() %></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div>
                <label class="block font-medium mb-1">Producto</label>
                <select name="id_producto" class="w-full border p-2 rounded">
                    <%
                        List<Producto> productos = (List<Producto>) request.getAttribute("productos");
                        for (Producto prod : productos) {
                    %>
                        <option value="<%= prod.getIdProducto() %>"><%= prod.getNombre() %></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div>
                <label class="block font-medium mb-1">Cantidad</label>
                <input type="number" name="cantidad" class="w-full border p-2 rounded" required>
            </div>
            <div>
                <label class="block font-medium mb-1">Precio Unitario</label>
                <input type="number" step="0.01" name="precio" class="w-full border p-2 rounded" required>
            </div>
            <button type="submit" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">Guardar Compra</button>
        </form>
    </div>
</body>
</html>
