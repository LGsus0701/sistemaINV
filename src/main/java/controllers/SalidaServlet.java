package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Compra;
import models.Producto;
import models.Salida;
import services.ProductoService;
import services.SalidaService;
import services.impl.ProductoServiceImpl;
import services.impl.SalidaServiceImpl;

/**
 * Servlet implementation class SalidaServlet
 */
@WebServlet("/salidas")
public class SalidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final SalidaService salidaService;
	private final ProductoService productoService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalidaServlet() {
        super();
        salidaService = new SalidaServiceImpl();
        productoService = new ProductoServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("nueva".equalsIgnoreCase(action)) {
        	
        	 // Obtener lista de productos
            List<Producto> productos = productoService.listarProductos();
            request.setAttribute("productos", productos);
            
            // Redireccionar al formulario para agregar una nueva salida
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/crearsalidas.jsp");
            dispatcher.forward(request, response);
        } else {
            // Listar salidas
            List<Salida> salidas = salidaService.listarSalidas();
            request.setAttribute("salidas", salidas);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/salidas.jsp");
            dispatcher.forward(request, response);
        }
    }

	
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		 System.out.println("Entrando al método doPost de SalidaServlet.");
            String fechaSalidaStr = request.getParameter("fechaSalida");
            
            // Validar si la fecha tiene un valor válido y el formato correcto
            if (fechaSalidaStr != null && !fechaSalidaStr.isEmpty() && fechaSalidaStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                java.sql.Date fechaSalida = java.sql.Date.valueOf(fechaSalidaStr);
                Integer idOrdenTrabajo = Integer.parseInt(request.getParameter("idOrdenTrabajo"));
                Integer idProducto = Integer.parseInt(request.getParameter("idProducto"));
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));

                Salida salida = new Salida();
                salida.setFechaSalida(fechaSalida);
                salida.setIdOrdenTrabajo(idOrdenTrabajo);
                salida.setIdProducto(idProducto);
                salida.setCantidad(cantidad);

                boolean registrado = salidaService.registrarSalida(salida);

                if (registrado) {
                    System.out.println("✅ Salida registrada con éxito");
                } else {
                    System.out.println("❌ Error al registrar la salida");
                }

                response.sendRedirect(request.getContextPath() + "/salidas");

            } else {
                // Si la fecha no tiene un valor válido, manejar el error
                request.setAttribute("error", "Fecha de salida no válida");
                doGet(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al registrar la salida");
            doGet(request, response);
        }
    }



}
