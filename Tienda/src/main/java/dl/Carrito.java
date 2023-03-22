package dl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Carrito implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Producto> carrito;
	
	@XmlElement(name = "producto")
	public List<Producto> getCarrito() {
		if(carrito == null)
			carrito = new ArrayList<Producto>();
		return carrito;
	}
	
	public void setCarrito(List<Producto> carrito) {
		this.carrito = carrito;
	}
	
	
}
