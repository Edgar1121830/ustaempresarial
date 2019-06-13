package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.UstaEmpresarial.nomina.modelo.HojaVida;
import co.com.ustaempresarial.servicio.NominaServicio;
@ManagedBean(name= "planContableHojaDeVida")
@SessionScoped
public class NominaHojaDeVidaCtrl implements Serializable{
private Integer documento;
private String apellido;
private Date fecha_nacimiento;
private String lugar_nacimiento;
private String direccion;
private Integer numero;
private String nombre_hoja_de_vida;
private List<HojaVida> lista_hoja_de_vida;
private int buscarCodHojaVida;
private HojaVida hojaVidaContable;

@EJB
private NominaServicio servicio;

public NominaHojaDeVidaCtrl() {
	super();
	hojaVidaContable = new HojaVida();
}
@PostConstruct
public void cargarHojaVidaPage() {
	try {
		lista_hoja_de_vida = new ArrayList<HojaVida>();
		lista_hoja_de_vida = servicio.listarHojasVida();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void crearHojaVidaContable() {
	try {
		hojaVidaContable.setDocumento(documento);
		hojaVidaContable.setApellido(apellido);
		hojaVidaContable.setNacimientoFecha(fecha_nacimiento);
		hojaVidaContable.setNacimientoLugar(lugar_nacimiento);
		hojaVidaContable.setDireccion(direccion);
		hojaVidaContable.setTelefono(numero);
		hojaVidaContable.setNombre(nombre_hoja_de_vida);
		
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
public Integer getDocumento() {
	return documento;
}
public void setDocumento(Integer documento) {
	this.documento = documento;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public Date getFecha_nacimiento() {
	return fecha_nacimiento;
}
public void setFecha_nacimiento(Date fecha_nacimiento) {
	this.fecha_nacimiento = fecha_nacimiento;
}
public String getLugar_nacimiento() {
	return lugar_nacimiento;
}
public void setLugar_nacimiento(String lugar_nacimiento) {
	this.lugar_nacimiento = lugar_nacimiento;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public Integer getNumero() {
	return numero;
}
public void setNumero(Integer numero) {
	this.numero = numero;
}
public String getNombre_hoja_de_vida() {
	return nombre_hoja_de_vida;
}
public void setNombre_hoja_de_vida(String nombre_hoja_de_vida) {
	this.nombre_hoja_de_vida = nombre_hoja_de_vida;
}
public List<HojaVida> getLista_hoja_de_vida() {
	return lista_hoja_de_vida;
}
public void setLista_hoja_de_vida(List<HojaVida> lista_hoja_de_vida) {
	this.lista_hoja_de_vida = lista_hoja_de_vida;
}
public int getBuscarCodHojaVida() {
	return buscarCodHojaVida;
}
public void setBuscarCodHojaVida(int buscarCodHojaVida) {
	this.buscarCodHojaVida = buscarCodHojaVida;
}
public HojaVida getHojaVidaContable() {
	return hojaVidaContable;
}
public void setHojaVidaContable(HojaVida hojaVidaContable) {
	this.hojaVidaContable = hojaVidaContable;
}
public NominaServicio getServicio() {
	return servicio;
}
public void setServicio(NominaServicio servicio) {
	this.servicio = servicio;
}


}
