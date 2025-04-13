package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Ingreso;
import services.IngresoService;
import services.impl.IngresoServiceImpl;

/**
 * Servlet implementation class IngresoServlet
 */
@WebServlet("/ingresos")
public class IngresoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final IngresoService ingresoService;
	
       
    
    public IngresoServlet() {
        super();
        ingresoService = new IngresoServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("nuevo".equals(accion)) {
            // Ir a formulario para registrar ingreso
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/crearingresos.jsp");
            dispatcher.forward(request, response);
        } else {
            // Mostrar listado de ingresos
            List<Ingreso> ingresos = ingresoService.listarIngresos();
            request.setAttribute("ingresos", ingresos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/ingresos.jsp");
            dispatcher.forward(request, response);
        }
    }

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        java.sql.Date fechaIngreso = java.sql.Date.valueOf(request.getParameter("fechaIngreso"));
	        int idCompra = Integer.parseInt(request.getParameter("idCompra"));
	        java.sql.Date fechaCreacion = new java.sql.Date(System.currentTimeMillis());

	        Ingreso ingreso = new Ingreso();
	        ingreso.setFechaIngreso(fechaIngreso);
	        ingreso.setIdCompra(idCompra);
	        ingreso.setFechaCreacion(fechaCreacion);

	        ingresoService.insertarIngreso(ingreso);

	        response.sendRedirect("ingresos"); // redireccionar para evitar reenvíos
	    } catch (Exception e) {
	        request.setAttribute("error", "Error al registrar ingreso: " + e.getMessage());
	        doGet(request, response); // recarga la vista con mensaje de error
	    }
	}


	

}
