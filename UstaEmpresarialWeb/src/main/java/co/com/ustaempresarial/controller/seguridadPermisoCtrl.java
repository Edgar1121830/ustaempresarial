//secciòn ediada por Erika Marcela Rincon Rico
package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.ustaempresarial.seguridad.modelo.Permiso;
import co.com.ustaempresarial.servicio.SeguridadSevicio;

//@ManagedBean(name = "permisoSeguridad")
@ManagedBean(name = "seguridadBean")
@SessionScoped
public class seguridadPermisoCtrl implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String descripcion;
	private Boolean estado;
	private List<Permiso> permisos;
	private String nombre;
	private Permiso permisoSeguridadAdm;

	private SeguridadSevicio servicios;

	public seguridadPermisoCtrl() {
		super();
		permisoSeguridadAdm = new Permiso();
		permisos = new ArrayList<Permiso>();
	}

	@PostConstruct
	public void cargarPermisoPage() {
		try {
			permisos = servicios.listarPermiso();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void listarPermisoSeguridad() {
		try {
			permisoSeguridadAdm = new Permiso();
			permisoSeguridadAdm.setCodigo(10);
			permisoSeguridadAdm.setDescripcion("......");
			permisoSeguridadAdm.setEstado(true);
			permisoSeguridadAdm.setNombre("borrame edit");
			servicios.editarPermiso(permisoSeguridadAdm);
			permisos.addAll(servicios.listarPermiso());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void crearPermisoSeguridad() {
		try {
			servicios.crearPermiso(permisoSeguridadAdm);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eliminarPermisoSeguridad() {
		try {
			servicios.eliminarPermiso(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public SeguridadSevicio getServicio() {
		return servicios;
	}

	public void setServicio(SeguridadSevicio servicio) {
		this.servicios = servicio;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public Permiso getPermisoSeguridadAdm() {
		return permisoSeguridadAdm;
	}

	public void setPermisoSeguridadAdm(Permiso permisoSeguridadAdm) {
		this.permisoSeguridadAdm = permisoSeguridadAdm;
	}

	public SeguridadSevicio getServicios() {
		return servicios;
	}

	public void setServicios(SeguridadSevicio servicios) {
		this.servicios = servicios;
	}

}
