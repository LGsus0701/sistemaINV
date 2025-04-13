package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Compra;
import models.Producto;
import models.Proveedor;
import services.CompraService;
import services.ProductoService;
import services.ProveedorService;
import services.impl.CompraServiceIml;
import services.impl.CompraServiceImpl;
import services.impl.ProductoServiceImpl;
import services.impl.ProveedorServiceImpl;

/**
 * Servlet implementation class CompraServlet
 */
@WebServlet("/compras")
public class CompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final CompraService compraService;
	private final ProveedorService proveedorService;
	private final ProductoService productoService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraServlet() {
        super();
        compraService = new CompraServiceImpl();
        proveedorService = new ProveedorServiceImpl();
        productoService = new ProductoServiceImpl();
    }

	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("nueva".equals(action)) {
        	List<Proveedor> proveedores = proveedorService.listarProveedores();
        	request.setAttribute("proveedores", proveedores);
        	List<Producto> productos = productoService.listarProductos();
        	request.setAttribute("productos", productos);
        	
            // Mostrar formulario para nueva compra
            request.getRequestDispatcher("/views/crearcompras.jsp").forward(request, response);
        } else {
            // Listar compras por defecto
            List<Compra> compras = compraService.listarCompras();
            request.setAttribute("compras", compras);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/compras.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("👉 Entrando al método doPost() de CompraServlet");

        Compra compra = new Compra();
        compra.setIdProveedor(Integer.parseInt(request.getParameter("id_proveedor"))); // 👈 nombre correcto
        compra.setIdProducto(Integer.parseInt(request.getParameter("id_producto")));   // 👈 nombre correcto
        compra.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        compra.setPrecioUnd(Double.parseDouble(request.getParameter("precio")));       // 👈 nombre correcto

        double subtotal = compra.getCantidad() * compra.getPrecioUnd();
        double igv = subtotal * 0.18;
        double total = subtotal + igv;

        compra.setSubtotal(subtotal);
        compra.setTotal(total);
        

        compraService.registrarCompra(compra);
        response.sendRedirect("compras");
    }


	
	

}
