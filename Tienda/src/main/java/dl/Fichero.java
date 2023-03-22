package dl;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Fichero {
	private static final String FILENAME = "/home/980409/STA/TIT_Ignacio/Tienda/datos.xml";
	
	public static void altaProducto(Producto p) {
		try {
			File f = new File(FILENAME);
			Carrito carrito = new Carrito();
			JAXBContext jaxbContext = JAXBContext.newInstance(Carrito.class);
			
			if(f.exists()) {
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				carrito = (Carrito) unmarshaller.unmarshal(f);
			}
			
			carrito.getCarrito().add(p);
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(carrito, f);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static Carrito leeFichero() {
		Carrito carrito = new Carrito();
		
		try {
			File f = new File(FILENAME);
			
			if(f.exists()) {
				JAXBContext jaxbContext = JAXBContext.newInstance(Carrito.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				carrito = (Carrito) unmarshaller.unmarshal(f);
				
				return carrito;
			} else {
				System.out.println("El fichero:" + FILENAME + " no existe.");
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return carrito;
    }
}
