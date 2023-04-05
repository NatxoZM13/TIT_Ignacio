package pl.modelo;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dl.Producto;

@Named
@ViewScoped
public class ShopBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Producto> productos;
	private static int lastReferencia = 0;
	private boolean altaExito;
	
	Consumidor cliente = new Consumidor();
	
	public void add(Producto p) {
		lastReferencia++;

		p.setReferencia(lastReferencia);
		cliente.altaProducto(p);

		altaExito = true;
		productos = null;
	}
	
	public List<Producto> getProductos() {
		if(productos == null)
			productos = cliente.leeFichero().getCarrito();
		
		return productos;
	}

	public boolean getAltaExito() {
		return altaExito;
	}
	
}
