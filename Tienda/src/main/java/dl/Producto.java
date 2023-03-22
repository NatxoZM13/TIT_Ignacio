package dl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int referencia;
	private String tipo;
	private String descripcion;
	private float precio;
	private static int lastReferencia = 0;
	
	/*  Cuando intentamos deserializar un objeto JSON en un objeto Java de la clase Producto, pero no se construye una instancia 
    de Producto correctamente se debe a que no se puede construir una instancia de Producto porque no existe un 
	constructor predeterminado en la clase. Es decir, la clase Producto no tiene un constructor 
	sin parámetros que pueda ser utilizado por la biblioteca de deserialización para construir el objeto.
	Para solucionar este error, debemos agregar un constructor sin argumentos a la clase Producto. Puede ser un constructor 
	vacío o un constructor que inicialice algunos o todos los campos de la clase.
	Con esto se podrá construir una instancia de Producto correctamente durante la deserialización.*/
	
	public Producto() { 
		
	}
	
	public Producto(String tipo, String descripcion, float precio) {
		lastReferencia++;
		this.referencia = lastReferencia;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	@XmlAttribute
	public int getReferencia() {
		return referencia;
	}

	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
	
	@XmlElement
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@XmlElement
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descriipcion) {
		this.descripcion = descriipcion;
	}
	
	@XmlElement
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
