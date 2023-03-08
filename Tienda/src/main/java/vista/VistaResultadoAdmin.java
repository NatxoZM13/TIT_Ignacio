package vista;

import java.io.PrintWriter;

import modelo.Producto;

public class VistaResultadoAdmin implements Vista {
	private final Producto p;
	
	public VistaResultadoAdmin(Producto p) {
		this.p = p;
	}
	
	@Override
	public void print(PrintWriter pw) {
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("ARTÍCULO AÑADIDO", "estilo.css"));
		pw.println("<body>");
		pw.println("<h1>Artículo " + p.getDescripcion() + " dado de alta en la categoría " + p.getTipo() +" con un precio de " + p.getPrecio() + " euros</h1>");
		pw.println(Utilidades.FIN);
	}
	

}
