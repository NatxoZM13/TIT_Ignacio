package pl.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dl.Producto;
import pl.modelo.Consumidor;
import pl.vista.Vista;
import pl.vista.VistaErrorAdmin;
import pl.vista.VistaResultadoAdmin;


@WebServlet("/ServletAdministrador")
public class ServletAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		respuestaHtml(response, new VistaErrorAdmin());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		String descripcion = request.getParameter("descripcion");
		float precio = Float.valueOf(request.getParameter("precio"));
		
		Producto p = new Producto(tipo, descripcion, precio);
		
		Consumidor cliente = new Consumidor();
		
		String mensaje = cliente.altaProducto(p);
		
		respuestaHtml(response, new VistaResultadoAdmin(p, mensaje));
	}
	
	private void respuestaHtml(HttpServletResponse response, Vista vista) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		vista.print(out);
		out.close();
	}

}
