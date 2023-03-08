package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {
	private static final String FILENAME = "datos.csv";
	private static int ultimaReferencia = 0;
	
	public static void altaProducto(Producto p) {
		try {
			FileWriter fw = new FileWriter(FILENAME,true);
			
			ultimaReferencia++;
			int referencia = ultimaReferencia;
			
			fw.append(Integer.toString(referencia));
			fw.append(",");
			fw.append(p.getTipo());
			fw.append(",");
			fw.append(p.getDescripcion());
			fw.append(",");
			fw.append(p.getPrecio());
			fw.append("\n");
			
			fw.close();
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero" + FILENAME + ":" + e.getMessage());
		}
	}
	
	public static String leeFichero() {
		StringBuilder sb = new StringBuilder();
        
		sb.append("<table>\n");
		sb.append("<caption>Listado de productos disponibles</caption>\n");
		sb.append("<tr><th>Nº Referencia</th><th>Tipo de producto</th><th>Descripción</th><th>Precio</th></tr>\n");

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String line;
            
            while((line = br.readLine()) != null) {
                String[] campos = line.split(",");
                String referencia = campos[0];
                String categoria = campos[1];
                String articulo = campos[2];
                String precio = campos[3];
                
                sb.append("<tr><td>");
                sb.append(referencia);
                sb.append("</td><td>");
                sb.append(categoria);
                sb.append("</td><td>");
                sb.append(articulo);
                sb.append("</td><td>");
                sb.append(precio);
                sb.append("</td></tr>\n");
            }
            
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el fichero " + FILENAME + ": " + e.getMessage());
        }

        sb.append("</table>");
        
        return sb.toString();
    }
}
