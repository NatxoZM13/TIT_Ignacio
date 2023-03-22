package bl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dl.Carrito;
import dl.Fichero;
import dl.FicheroJson;
import dl.Producto;

@Path("/proveedor")
public class Proveedor {
	
	@POST
	@Path("/altaProducto")
	@Consumes(MediaType.APPLICATION_JSON)
	public void altaProducto(Producto p) {
		Fichero.altaProducto(p);
	}
	
	@GET
	@Path("/leeFichero")
	@Produces(MediaType.APPLICATION_JSON)
	public Carrito leeFichero() {
		return Fichero.leeFichero();
	}
	
	@GET
	@Path("/leeFicheroJson")
	@Produces(MediaType.APPLICATION_JSON)
	public String leeFicheroJson() {
		return FicheroJson.leeFicheroJson();
	}
}
