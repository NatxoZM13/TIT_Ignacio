package vista;

import java.io.PrintWriter;

public class VistaErrorAdmin implements Vista {
	
	@Override
	public void print(PrintWriter pw) {
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("ERROR ADMIN", "estilo.css"));
		pw.println("<body>");
		pw.println("<h1>ERROR: Este servlet sólo ha de accederse mediante POST</h1>");
		pw.println(Utilidades.FIN);
	}

}
