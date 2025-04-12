package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Categoria;
import models.Producto;
import services.CategoriaService;
import services.ProductoService;
import services.impl.ProductoServiceImpl;
import services.impl.CategoriaServiceImpl;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        productoService = new ProductoServiceImpl();
        categoriaService = new CategoriaServiceImpl();  // Inicializa el servicio de categorías
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoriaIdStr = request.getParameter("categoriaId");
        List<Producto> productos;

        if (categoriaIdStr != null) {
            try {
                int categoriaId = Integer.parseInt(categoriaIdStr);
                productos = productoService.listarPorCategoria(categoriaId);
            } catch (NumberFormatException e) {
                // Si no es un número válido, carga todos
                productos = productoService.listarProductos();
            }
        } else {
            productos = productoService.listarProductos();
        }

        request.setAttribute("productos", productos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/productos.jsp");
        dispatcher.forward(request, response);
    }
   
}
