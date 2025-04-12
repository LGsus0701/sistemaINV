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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Ingreso> ingresos = ingresoService.listarIngresos();
		request.setAttribute("ingresos", ingresos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/ingresos.jsp");
		dispatcher.forward(request, response);
	}

	

}
