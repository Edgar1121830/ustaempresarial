package modeloNomina;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the hoja_vida database table.
 * 
 */
@Entity
@Table(name="hoja_vida")
@NamedQuery(name="HojaVida.findAll", query="SELECT h FROM HojaVida h")
public class HojaVida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer documento;

	private String apellido;

	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(name="nacimiento_fecha")
	private Date nacimientoFecha;

	@Column(name="nacimiento_lugar")
	private String nacimientoLugar;

	private String nombre;

	private Integer telefono;

	public HojaVida() {
	}

	public Integer getDocumento() {
		return this.documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getNacimientoFecha() {
		return this.nacimientoFecha;
	}

	public void setNacimientoFecha(Date nacimientoFecha) {
		this.nacimientoFecha = nacimientoFecha;
	}

	public String getNacimientoLugar() {
		return this.nacimientoLugar;
	}

	public void setNacimientoLugar(String nacimientoLugar) {
		this.nacimientoLugar = nacimientoLugar;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

}