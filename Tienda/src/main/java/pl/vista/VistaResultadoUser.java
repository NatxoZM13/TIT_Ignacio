package pl.vista;

import java.io.PrintWriter;
import java.util.List;

import dl.Producto;

public class VistaResultadoUser implements Vista {
	private final List<Producto> carrito;
	
	public VistaResultadoUser(List<Producto> carrito) {
		this.carrito = carrito;
	}

	@Override
	public void print(PrintWriter pw) {
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("LISTA ARTÍCULOS", "estilo.css"));
		pw.println("<body>");
		pw.println("<h1>¡Bienvenido usuario!</h1>");
		pw.println(printTable(carrito));
		pw.println(Utilidades.FIN);
	}
	
	private String printTable(List<Producto> carrito) {
		StringBuilder sb = new StringBuilder();
	    
		sb.append("<table>\n");
		sb.append("<caption>Listado de productos disponibles</caption>\n");
		sb.append("<tr><th>Nº Referencia</th><th>Tipo de producto</th><th>Descripción</th><th>Precio</th></tr>\n");

	    for(Producto p : carrito) {
	    	sb.append("<tr><td>");
            sb.append(p.getReferencia());
            sb.append("</td><td>");
            sb.append(p.getTipo());
            sb.append("</td><td>");
            sb.append(p.getDescripcion());
            sb.append("</td><td>");
            sb.append(p.getPrecio());
            sb.append("</td></tr>\n");
	    }

	    sb.append("</table>");
	    
	    return sb.toString();
	}

}
