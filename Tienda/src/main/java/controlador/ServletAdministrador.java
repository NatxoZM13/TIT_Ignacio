package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Fichero;
import modelo.Producto;
import vista.Vista;
import vista.VistaErrorAdmin;
import vista.VistaResultadoAdmin;

@WebServlet("/ServletAdministrador")
public class ServletAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		respuestaHtml(response, new VistaErrorAdmin());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto p = new Producto();
		
		p.setTipo(request.getParameter("tipo"));
		p.setDescripcion(request.getParameter("descripcion"));
		p.setPrecio(request.getParameter("precio"));
		
		respuestaHtml(response, new VistaResultadoAdmin(p));
		
		Fichero.altaProducto(p);
	}
	
	private void respuestaHtml(HttpServletResponse response, Vista vista) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		vista.print(out);
		out.close();
	}

}
