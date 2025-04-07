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
import models.Proveedor;
import services.CompraService;
import services.impl.CompraServiceIml;
import services.impl.CompraServiceImpl;

/**
 * Servlet implementation class CompraServlet
 */
@WebServlet("/compras")
public class CompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final CompraService compraService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraServlet() {
        super();
        compraService = new CompraServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Compra>  compras = compraService.listarCompras();
		request.setAttribute("compras", compras);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/compras.jsp");
		dispatcher.forward(request, response);
	}

}
