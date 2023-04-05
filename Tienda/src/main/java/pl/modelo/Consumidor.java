package pl.modelo;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import dl.Carrito;
import dl.Producto;

public class Consumidor {

	public String altaProducto(Producto p) {
		return ClientBuilder.newClient().target("http://localhost:8080/Tienda/rest/proveedor/altaProducto").request()
				.post(Entity.entity(p, MediaType.APPLICATION_JSON)).readEntity(String.class); 
		// Devuelve un Strig notificando si se ha dado de alta el producto (null) o no (mensaje errror)
	}

	public Carrito leeFichero() {
		return ClientBuilder.newClient().target("http://localhost:8080/Tienda/rest/proveedor/leeFichero").request(MediaType.APPLICATION_JSON)
				.get(Carrito.class);
	}

}
