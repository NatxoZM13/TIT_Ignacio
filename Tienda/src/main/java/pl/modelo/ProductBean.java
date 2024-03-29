package pl.modelo;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import dl.Producto;

@Named
@RequestScoped
public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final Producto entity = new Producto();
	private static final String[] TIPO = {"libro", "electronica", "deporte"}; 
	
	public Producto getEntity() {
		return entity;
	}

	public String[] getTipo() {
		return TIPO;
	}

}
