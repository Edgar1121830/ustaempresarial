//secciòn ediada por Maria Fernanda Molina Gonzalez
package co.com.ustaempresarial.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.ustaempresarial.seguridad.modelo.Permiso;
import co.com.ustaempresarial.seguridad.modelo.RolPermiso;
import co.com.ustaempresarial.seguridad.modelo.RolPermisoPK;
import co.com.ustaempresarial.servicio.SeguridadSevicio;

//@ManagedBean(name = "rolPermisoSeguridadPk")
@ManagedBean(name = "seguridadBean")
@SessionScoped
public class SeguridadRolPermisoPkCtrl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer permisoCod;
	private Integer rolCod;
	private List<RolPermiso> permisoPk;
	private RolPermisoPK rolPermisoSeguridad;
	private SeguridadSevicio servicios;
	
	
	public SeguridadRolPermisoPkCtrl() {
		super();
		rolPermisoSeguridad = new RolPermisoPK();
		permisoPk = new ArrayList<RolPermiso>();
	}
	
	public void cargarPermisoPage() {
		try {
			permisoPk=servicios.traerRolPermisos();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}


	public void listarRolPermiso() {
		try {
			rolPermisoSeguridad = new RolPermisoPK();
			rolPermisoSeguridad.setPermisoCod(10);
			rolPermisoSeguridad.setRolCod(10);
		 //   permisoPk.add( servicios.traerRolUsuario());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void crearRolPermiso() {
	    try {
	    //	servicios.crearRolPermisos(rolPermisoSeguridad);

	    } catch (Exception e) {
	    	// TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	public Integer getPermisoCod() {
		return permisoCod;
	}

	public void setPermisoCod(Integer permisoCod) {
		this.permisoCod = permisoCod;
	}

	public Integer getRolCod() {
		return rolCod;
	}

	public void setRolCod(Integer rolCod) {
		this.rolCod = rolCod;
	}

	public List<RolPermiso> getPermiso() {
		return permisoPk;
	}

	public void setPermisoPk(List<RolPermiso> permisoPk) {
		this.permisoPk = permisoPk;
	}

	public RolPermisoPK getRolPermisoSeguridad() {
		return rolPermisoSeguridad;
	}

	public void setRolPermisoSeguridad(RolPermisoPK rolPermisoSeguridad) {
		this.rolPermisoSeguridad = rolPermisoSeguridad;
	}

	public SeguridadSevicio getServicios() {
		return servicios;
	}

	public void setServicios(SeguridadSevicio servicios) {
		this.servicios = servicios;
	}
}
