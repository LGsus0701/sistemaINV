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
        List<Producto> productos = productoService.listarProductos();
        request.setAttribute("productos", productos);
        RequestDispatcher dispather = request.getRequestDispatcher("/views/productos.jsp");
        dispather.forward(request, response);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }

    /**
     * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
     */
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }

    /**
     * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
     */
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
