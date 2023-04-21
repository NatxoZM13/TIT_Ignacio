package bl;

import java.io.FileNotFoundException;
import java.io.Serializable;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;

import org.jboss.ejb3.annotation.SecurityDomain;

import dl.Carrito;
import dl.Fichero;
import dl.Producto;

@Stateless
@LocalBean
@DeclareRoles({"admin","user"})
@SecurityDomain("Internal")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@RolesAllowed("admin")
	public void altaProducto(Producto p) {
		try {
			Fichero.altaProducto(p);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	@PermitAll
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
