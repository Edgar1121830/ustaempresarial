package modeloNomina;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the nomina database table.
 * 
 */
@Entity
@NamedQuery(name="Nomina.findAll", query="SELECT n FROM Nomina n")
public class Nomina implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NominaPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_insert")
	private Date fechaInsert;

	@Column(name="fecha_update")
	private String fechaUpdate;

	@Column(name="usuario_insert")
	private String usuarioInsert;

	@Column(name="usuario_update")
	private String usuarioUpdate;

	private Integer valor;

	public Nomina() {
	}

	public NominaPK getId() {
		return this.id;
	}

	public void setId(NominaPK id) {
		this.id = id;
	}

	public Date getFechaInsert() {
		return this.fechaInsert;
	}

	public void setFechaInsert(Date fechaInsert) {
		this.fechaInsert = fechaInsert;
	}

	public String getFechaUpdate() {
		return this.fechaUpdate;
	}

	public void setFechaUpdate(String fechaUpdate) {
		this.fechaUpdate = fechaUpdate;
	}

	public String getUsuarioInsert() {
		return this.usuarioInsert;
	}

	public void setUsuarioInsert(String usuarioInsert) {
		this.usuarioInsert = usuarioInsert;
	}

	public String getUsuarioUpdate() {
		return this.usuarioUpdate;
	}

	public void setUsuarioUpdate(String usuarioUpdate) {
		this.usuarioUpdate = usuarioUpdate;
	}

	public Integer getValor() {
		return this.valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}