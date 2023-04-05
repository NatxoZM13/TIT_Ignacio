package bl;

import java.io.FileNotFoundException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import dl.Carrito;
import dl.Fichero;
import dl.Producto;

@Path("/proveedor")
public class Proveedor {
	
	@POST
	@Path("/altaProducto")
	@Consumes(MediaType.APPLICATION_JSON)
	public void altaProducto(Producto p) {
		try {
			Fichero.altaProducto(p);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/leeFichero")
	@Produces(MediaType.APPLICATION_JSON)
	public Carrito leeFichero() {
		Carrito carrito = new Carrito();
		
		try {
			carrito = Fichero.leeFichero();
			
			return carrito;
		} catch (FileNotFoundException | JAXBException e) {
			e.printStackTrace();
		}
		
		return carrito;
	}
	
}
