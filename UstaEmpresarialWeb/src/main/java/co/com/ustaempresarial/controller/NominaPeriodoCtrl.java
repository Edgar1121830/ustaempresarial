package co.com.ustaempresarial.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.UstaEmpresarial.nomina.modelo.Periodo;
import co.com.ustaempresarial.servicio.NominaServicio;

@ManagedBean(name="periodoNomina")
@SessionScoped
public class NominaPeriodoCtrl {
	private Integer codigo;
	private Date fechaInicio;
	private Date fechaFin;
	private boolean estado;
	private List<Periodo> periodos;
	private int buscarCodPeriodo;
	private Periodo periodoContable;

	@EJB
	private NominaServicio servicio;

	public NominaPeriodoCtrl() {
		super();
		periodoContable= new Periodo();
		periodos= new ArrayList<Periodo>();
	}

	@PostConstruct
	public void cargarPeriodoPage() {
		try {
			periodos=servicio.listaPeriodo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}

	public void crearPeriodoContable() {
		try {
			
	periodoContable.setCodigo(codigo);
	periodoContable.setEstado(estado);
	periodoContable.setFechaInicio(fechaInicio);
	periodoContable.setFechaFin(fechaFin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void modificarPeriodoContable() {
	    try {

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void eliminarPeriodoContable() {
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

	public int getBuscarCodPeriodo() {
		return buscarCodPeriodo;
	}

	public void setBuscarCodPeriodo(int buscarCodPeriodo) {
		this.buscarCodPeriodo = buscarCodPeriodo;
	}

	public Periodo getPeriodoContable() {
		return periodoContable;
	}

	public void setPeriodoContable(Periodo periodoContable) {
		this.periodoContable = periodoContable;
	}

	public NominaServicio getServicio() {
		return servicio;
	}

	public void setServicio(NominaServicio servicio) {
		this.servicio = servicio;
	}



}
