<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar Ingreso</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">

    <div class="max-w-2xl mx-auto mt-10 p-6 bg-white rounded-lg shadow-lg">
        <h2 class="text-3xl font-semibold text-center text-blue-600 mb-6">Registrar nuevo ingreso</h2>

        <form action="ingresos" method="post" class="space-y-4">
            
            <!-- Fecha de Ingreso -->
            <div class="flex flex-col">
                <label for="fechaIngreso" class="text-lg font-medium text-gray-700">Fecha de Ingreso:</label>
                <input type="date" name="fechaIngreso" id="fechaIngreso" required class="mt-2 p-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>

            <!-- ID de Compra -->
            <div class="flex flex-col">
                <label for="idCompra" class="text-lg font-medium text-gray-700">ID de Compra:</label>
                <input type="number" name="idCompra" id="idCompra" required class="mt-2 p-3 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500">
            </div>

            <!-- Botón de Enviar -->
            <div class="text-center">
                <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-6 rounded-full">
                    Registrar
                </button>
            </div>
        </form>

        <!-- Volver al listado -->
        <div class="text-center mt-4">
            <a href="ingresos" class="text-blue-500 hover:text-blue-700 text-lg">⬅ Volver al listado</a>
        </div>
    </div>

</body>
</html>
