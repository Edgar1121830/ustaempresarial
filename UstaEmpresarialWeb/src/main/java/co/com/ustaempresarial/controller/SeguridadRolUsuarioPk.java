//secciòn ediada por Erika Marcela Rincon Rico
package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import co.com.ustaempresarial.seguridad.modelo.RolUsuarioPK;
import co.com.ustaempresarial.servicio.SeguridadSevicio;

//@ManagedBean(name = "rolUsuarioPK")
@ManagedBean(name = "seguridadBean")
@SessionScoped
public class SeguridadRolUsuarioPk implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer usuario_cod;
	private Integer rol_cod;
	private Timestamp fecha;
	private List<RolUsuarioPK> rolUsuarios;
	private RolUsuarioPK rolUsuarioSeguridad;
	private SeguridadSevicio servicio;

	public SeguridadRolUsuarioPk() {
		super();
		rolUsuarioSeguridad = new RolUsuarioPK();
		rolUsuarios = new ArrayList<RolUsuarioPK>();
	}

	@PostConstruct
    public void cargarRolUsuarioPKSeguridad() {
		try {
		//	rolUsuarios =servicio.traerRolUsuarioPK();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void listarRolusuarioPKSeguridad() {
		try {
			rolUsuarioSeguridad = new RolUsuarioPK();
		//	rolUsuarioSeguridad.setFecha(Date(00:00:00));
			rolUsuarioSeguridad.setRolCod(10);
			rolUsuarioSeguridad.setUsuarioCod(10);
		//	servicio.editarRolUsuarioPK(rolUsuarioSeguridad);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void crearRolUsuarioPKSeguridad() {
		try {
		//	servicio.crearRolUsuariosPK(rolUsuarioSeguridad);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public void eliminarRolUsuarioPKSeguridad() {
		try {
			//servicio.eliminarRolUsuarioPK(rol_cod);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Integer getUsuario_cod() {
		return usuario_cod;
	}

	public void setUsuario_cod(Integer usuario_cod) {
		this.usuario_cod = usuario_cod;
	}

	public Integer getRol_cod() {
		return rol_cod;
	}

	public void setRol_cod(Integer rol_cod) {
		this.rol_cod = rol_cod;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public List<RolUsuarioPK> getRolUsuarios() {
		return rolUsuarios;
	}

	public void setRolUsuarios(List<RolUsuarioPK> rolUsuarios) {
		this.rolUsuarios = rolUsuarios;
	}

	public RolUsuarioPK getRolUsuarioSeguridad() {
		return rolUsuarioSeguridad;
	}

	public void setRolUsuarioSeguridad(RolUsuarioPK rolUsuarioSeguridad) {
		this.rolUsuarioSeguridad = rolUsuarioSeguridad;
	}

	public SeguridadSevicio getServicio() {
		return servicio;
	}

	public void setServicio(SeguridadSevicio servicio) {
		this.servicio = servicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
