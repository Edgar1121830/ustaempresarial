package modeloNomina;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dependencia database table.
 * 
 */
@Entity
@NamedQuery(name="Dependencia.findAll", query="SELECT d FROM Dependencia d")
public class Dependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer codigo;

	@Column(name="dependencia_padre")
	private Integer dependenciaPadre;

	private Boolean estado;

	private String nombre;

	public Dependencia() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getDependenciaPadre() {
		return this.dependenciaPadre;
	}

	public void setDependenciaPadre(Integer dependenciaPadre) {
		this.dependenciaPadre = dependenciaPadre;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}