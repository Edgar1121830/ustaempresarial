package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import co.com.ustaempresarial.finanzas.modelo.Periodo;
import co.com.ustaempresarial.servicio.FinanzasServicio;

@ManagedBean(name="periodoFinanzas")
@SessionScoped
public class FinanzasPeriodoCtrl implements Serializable {
private Integer codigo;
private boolean estado;
private Date fechaFin;
private Date fechaInicio;
private List<Periodo> periodos;
private int buscarCodPeriodo;
private Periodo periodoContable;

@EJB
private FinanzasServicio servicio;

public FinanzasPeriodoCtrl() {
	super();
	periodoContable= new Periodo();
	periodos= new ArrayList<Periodo>();
}

@PostConstruct
public void cargarPeriodoPage() {
	try {
		periodos=servicio.listarPeriodo();	
	} catch (Exception e) {
		e.printStackTrace();
	}
    
}

public void crearPeriodoContable() {
	try {
		
//		periodoContable.setCodigo(codigo);
//		periodoContable.setEstado(estado);
//		periodoContable.setFechaInicio(fechaInicio);
//		periodoContable.setFechaFin(fechaFin);
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

public boolean isEstado() {
	return estado;
}

public void setEstado(boolean estado) {
	this.estado = estado;
}

public Date getFechaFin() {
	return fechaFin;
}

public void setFechaFin(Date fechaFin) {
	this.fechaFin = fechaFin;
}

public Date getFechaInicio() {
	return fechaInicio;
}

public void setFechaInicio(Date fechaInicio) {
	this.fechaInicio = fechaInicio;
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

public FinanzasServicio getServicio() {
	return servicio;
}

public void setServicio(FinanzasServicio servicio) {
	this.servicio = servicio;
}
public Periodo getPeriodoContable() {
	return periodoContable;
}
public void setPeriodoContable(Periodo periodoContable) {
	this.periodoContable = periodoContable;
}

}

