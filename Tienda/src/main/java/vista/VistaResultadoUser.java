package vista;

import java.io.PrintWriter;

import modelo.Fichero;

public class VistaResultadoUser implements Vista {

	@Override
	public void print(PrintWriter pw) {
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("LISTA ARTÍCULOS", "estilo.css"));
		pw.println("<body>");
		pw.println("<h1>¡Bienvenido usuario!</h1>");
		pw.println(Fichero.leeFichero());
		pw.println(Utilidades.FIN);
	}

}
