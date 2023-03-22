package dl;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class FicheroJson {
private static final String FILENAME = "/home/980409/STA/TIT_Ignacio/Tienda/datos.xml";
	
	public static String leeFicheroJson() {
		try {
			File f = new File(FILENAME);
			
			if(f.exists()) {
				Carrito carrito = new Carrito();
				JAXBContext jaxbContext = JAXBContext.newInstance(Carrito.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				carrito = (Carrito) unmarshaller.unmarshal(f);
				
				return buildJson(carrito);
		        
			} else {
				System.out.println("El fichero:" + FILENAME + " no existe.");
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return null;	
	}
	
	private static String buildJson(Carrito carrito) {
		StringBuilder json = new StringBuilder();
		
		json.append("{");
	    json.append("\"name\": \"Tienda\",");
	    json.append("\"children\": [");
	    
	    List<Producto> listaOrdenada = ordenarListaByTipo(carrito.getCarrito());
	    String tipoAnterior = "";
	    
	    for (Producto producto : listaOrdenada) {
	        if (producto.getTipo().equals(tipoAnterior)) {
	            json.append(",");
	            json.append("{\"name\": \"" + producto.getDescripcion() + "\", \"size\": " + producto.getPrecio() + "}");
	        } else {
	            if (!tipoAnterior.equals("")) {
	                json.append("]");
	                json.append("},");
	            }
	            
	            json.append("{");
	            json.append("\"name\": \"" + producto.getTipo() + "\",");
	            json.append("\"children\": [");
	            json.append("{\"name\": \"" + producto.getDescripcion() + "\", \"size\": " + producto.getPrecio() + "}");
	        }
	        
	        tipoAnterior = producto.getTipo();
	    }
	    
	    if (!tipoAnterior.equals("")) {
	        json.append("]");
	        json.append("}");
	    }
		
		json.append("]");
	    json.append("}");

	    return json.toString();
	}
	
	private static List<Producto> ordenarListaByTipo(List<Producto> carrito) {
		Comparator<Producto> comparador = Comparator.comparing(Producto::getTipo);
		Collections.sort(carrito,comparador);
		
		return carrito;
	}
}
