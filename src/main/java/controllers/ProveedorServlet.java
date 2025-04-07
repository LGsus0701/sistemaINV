package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Proveedor;
import services.ProveedorService;
import services.impl.ProveedorServiceImpl;

/**
 * Servlet implementation class ProveedorServlet
 */
@WebServlet("/proveedores")
public class ProveedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ProveedorService proveedorService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorServlet() {
        super();
        proveedorService = new ProveedorServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Proveedor>  proveedores = proveedorService.listarProveedores();
		request.setAttribute("proveedores", proveedores);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/proveedores.jsp");
		dispatcher.forward(request, response);
		
	}

}
