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
import models.Salida;
import services.SalidaService;
import services.impl.SalidaServiceImpl;

/**
 * Servlet implementation class SalidaServlet
 */
@WebServlet("/salidas")
public class SalidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final SalidaService salidaService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalidaServlet() {
        super();
        salidaService = new SalidaServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Salida>  salidas = salidaService.listarSalidas();
		request.setAttribute("salidas", salidas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/salidas.jsp");
		dispatcher.forward(request, response);
		
	}

}
