package pl.modelo;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import bl.Proveedor;
import dl.Producto;

@Named
@ViewScoped
public class ShopBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Producto> productos;
	private static int lastReferencia = 0;
	private boolean altaExito;
	
	@EJB
	private Proveedor proveedor;
	
	public void add(Producto p) {
		lastReferencia++;

		p.setReferencia(lastReferencia);
		proveedor.altaProducto(p);

		altaExito = true;
		productos = null;
	}
	
	public List<Producto> getProductos() {
		if(productos == null)
			productos = proveedor.leeFichero().getCarrito();
			
		return productos;
	}

	public boolean getAltaExito() {
		return altaExito;
	}
	
	public String getRemoteUser() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		
		return context.getRemoteUser();
	}
	
}
