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
	
	public Producto() { 

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
