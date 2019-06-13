package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.UstaEmpresarial.nomina.modelo.Dependencia;
import co.com.ustaempresarial.servicio.NominaServicio;
@ManagedBean(name= "planDependencia")
@SessionScoped
public class NominaDependenciaCtrl implements Serializable{
	private Integer codigo;
	private Integer dependenciaPadre;
	private boolean estado;
	private String nombre;
	private List<Dependencia> listaDependencia;
	private int buscarCodDependencia;
	private Dependencia objDependencia;

	@EJB
	private NominaServicio servicio;

	public NominaDependenciaCtrl() {
		super();
		objDependencia = new Dependencia();
			}

	@PostConstruct
	public void cargarDependenciaPage() {
		try {
			listaDependencia = new ArrayList<Dependencia>();
			listaDependencia = servicio.traerDependencia();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void crearDependencia() {
		try {
			objDependencia.setCodigo(codigo);
			objDependencia.setDependenciaPadre(dependenciaPadre);
			objDependencia.setEstado(estado);
			objDependencia.setNombre(nombre);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificarHojaVidaContable() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void eliminarHojaViaContable() {
		try {
			
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

	public Integer getDependenciaPadre() {
		return dependenciaPadre;
	}

	public void setDependenciaPadre(Integer dependenciaPadre) {
		this.dependenciaPadre = dependenciaPadre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Dependencia> getListaDependencia() {
		return listaDependencia;
	}

	public void setListaDependencia(List<Dependencia> listaDependencia) {
		this.listaDependencia = listaDependencia;
	}

	public int getBuscarCodDependencia() {
		return buscarCodDependencia;
	}

	public void setBuscarCodDependencia(int buscarCodDependencia) {
		this.buscarCodDependencia = buscarCodDependencia;
	}

	public Dependencia getObjDependencia() {
		return objDependencia;
	}

	public void setObjDependencia(Dependencia objDependencia) {
		this.objDependencia = objDependencia;
	}

	public NominaServicio getServicio() {
		return servicio;
	}

	public void setServicio(NominaServicio servicio) {
		this.servicio = servicio;
	}
	
	
}
