package co.com.ustaempresarial.seguridad.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the rol_permiso database table.
 * 
 */
@Entity
@Table(name = "rol_permiso")
@NamedQuery(name = "RolPermiso.findAll", query = "SELECT r FROM RolPermiso r")
public class RolPermiso implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String LISTAR_PERMISOS = "RolPermiso.LISTAR_PERMISOS";

	@EmbeddedId
	private RolPermisoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp fecha;

	public RolPermiso() {
	}

	public RolPermisoPK getId() {
		return this.id;
	}

	public void setId(RolPermisoPK id) {
		this.id = id;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = (Timestamp) fecha;
	}

}