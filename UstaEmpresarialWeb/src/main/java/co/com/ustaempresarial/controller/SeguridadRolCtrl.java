//secciòn ediada por Erika Marcela Rincon Rico
package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import co.com.ustaempresarial.seguridad.modelo.Rol;
import co.com.ustaempresarial.servicio.SeguridadSevicio;


//@ManagedBean(name = "rolSeguridad")
@ManagedBean(name = "seguridadBean")
@SessionScoped
public class SeguridadRolCtrl implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer codigo;

	private String descripcion;

	private Boolean estado;

	private String nombre;
	private List<Rol> rol;
	private Rol rolSeg;
	private SeguridadSevicio roles;
	
   public SeguridadRolCtrl() {
	   super();
	   
	   rolSeg = new Rol();
	   rol= new ArrayList<Rol>();
	}
   @PostConstruct
   public void cargarPermisoPage() {
   	try {
   		rol=roles.listarRol();	
   	} catch (Exception e) {
   		e.printStackTrace();
   	}
       
   }

   public void listarRolSeguridad() {
		try {
			rolSeg = new Rol();
			rolSeg.setCodigo(10);
			rolSeg.setDescripcion("......");
			rolSeg.setEstado(true);
			rolSeg.setNombre("borrame edit");
			roles.editarRol(rolSeg);
			rol.addAll(roles.listarRol());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void crearPermisoSeguridad() {
	    try {
	    	roles.crearRol(rolSeg);;

	    } catch (Exception e) {
	    	// TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	public void eliminarPermisoSeguridad() {
	    try {
	    roles.eliminarRol(codigo);
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
	public List<Rol> getRol() {
		return rol;
	}
	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}
	public Rol getRolSeg() {
		return rolSeg;
	}
	public void setRolSeg(Rol rolSeg) {
		this.rolSeg = rolSeg;
	}

}
