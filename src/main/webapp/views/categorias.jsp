<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="models.Categoria" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema - Inventario</title>
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
                    <li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Productos</a></li>
                    <li class="mb-2"><a href="/SistemaINV/categorias" class="block p-2 hover:bg-blue-700 rounded-md cursor-pointer border border-white border-solid">Categorias</a></li>
                    <li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Ingresos</a></li>
                    <li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Salidas</a></li>
                    <li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Proveedores</a></li>
                    <li class="mb-2"><a href="#" class="block p-2 hover:bg-blue-700 rounded">Reportes</a></li>
                </ul>
            </nav>
        </aside>
        
       <main class="p-4">
    <div class="flex w-full justify-center p-4 gap-4 flex-wrap">
        <%
            List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
            if (categorias != null && !categorias.isEmpty()) {
                for(Categoria categoria: categorias) {
        %>
            <div class="flex bg-gray-200 w-[200px] justify-center flex-col p-4 gap-2 items-center rounded-md border border-gray-300 border-solid hover:border-green-600 cursor-pointer">
                <img class="rounded-sm" src="<%= categoria.getImagenUrl() %>" width="150px">
                <p class="text-center font-bold text-gray-600"><%= categoria.getNombre() %></p>
                
                <!-- Botones -->
                <div class="flex flex-col gap-2 w-full">
                    <button class="bg-blue-500 text-white px-4 py-1 rounded-md w-full hover:bg-blue-600">
                        Ver Producto
                    </button>
                    <button class="bg-yellow-500 text-white px-4 py-1 rounded-md w-full hover:bg-yellow-600">
                        Editar
                    </button>
                    <button class="bg-red-500 text-white px-4 py-1 rounded-md w-full hover:bg-red-600">
                        Eliminar
                    </button>
                </div>
            </div>
        <%  } %>
        <%  } else { %>
            <p>No se encontraron registros</p>
        <% } %>
    </div>
    <div>Total registros: <%= categorias.size() %></div>
</main>

</body>
</html>