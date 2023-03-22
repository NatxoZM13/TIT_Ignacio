package pl.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.modelo.Consumidor;
import pl.vista.Vista;
import pl.vista.VistaErrorUser;
import pl.vista.VistaResultadoUser;

@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Consumidor cliente = new Consumidor();
		
		respuestaHtml(response, new VistaResultadoUser(cliente.leeFichero().getCarrito()));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		respuestaHtml(response, new VistaErrorUser());
	}
	
	private void respuestaHtml(HttpServletResponse response, Vista vista) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		vista.print(out);
		out.close();
	}

}
