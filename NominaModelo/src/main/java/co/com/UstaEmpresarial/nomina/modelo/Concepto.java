package co.com.UstaEmpresarial.nomina.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the concepto database table.
 * 
 */
@Entity
@NamedQuery(name="Concepto.findAll", query="SELECT c FROM Concepto c")
public class Concepto implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String LISTAR_CONCEPTO="Concepto.Listar_concepto";
	public static final String FIND_ALL = null;
	private Integer codigo;
	private String descripcion;
	private Boolean estado;
	private String formula;
	private String nombre;
	private Boolean tipo;

	public Concepto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}


	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Boolean getTipo() {
		return this.tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

}