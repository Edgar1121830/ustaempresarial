//secciòn ediada por Nicolle Vanessa Saavedra Daza
package co.com.ustaempresarial.controller;
import java.io.Serializable;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import co.com.ustaempresarial.seguridad.modelo.UsuarioLog;
import co.com.ustaempresarial.servicio.SeguridadSevicio;
//@ManagedBean(name="LogUsuario")
@ManagedBean(name = "seguridadBean")
@SessionScoped
public class SeguridadUsuarioLogCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private Date fecha;
	private Integer usuario_cod;
	private String proceso;
	private String dml;
	private List<UsuarioLog> usuariosLog;
	private UsuarioLog usuarioLogSeguridad;
	private SeguridadSevicio servicio;
	
	public SeguridadUsuarioLogCtrl() {
		super();
		usuarioLogSeguridad = new UsuarioLog();
		usuariosLog = new ArrayList<UsuarioLog>();
	}
	@PostConstruct
	public void cargarUsuarioLogPage() {
		try {
			usuariosLog = servicio.listarUsuarioLog();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void listarUsuarioLogSeguridad() {
		try {
			usuarioLogSeguridad = new UsuarioLog();
			usuarioLogSeguridad.setCodigo(10);
		//	usuarioLogSeguridad.setFecha(fecha);
			usuarioLogSeguridad.setProceso("....");
			usuarioLogSeguridad.setUsuarioCod(5);
			usuarioLogSeguridad.setDml("...");
			servicio.editarUsuarioLog(usuarioLogSeguridad);
			usuariosLog.addAll(servicio.listarUsuarioLog());
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public void crearUsuarioLogSeguridad() {
		try {
			servicio.crearUsuarioLog(usuarioLogSeguridad);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void eliminarUsuarioLogSeguridad(){
		try {
			servicio.eliminarUsuarioLog(codigo);
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getUsuario_cod() {
		return usuario_cod;
	}

	public void setUsuario_cod(Integer usuario_cod) {
		this.usuario_cod = usuario_cod;
	}

	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	public String getDml() {
		return dml;
	}

	public void setDml(String dml) {
		this.dml = dml;
	}

	public SeguridadSevicio getServicio() {
		return servicio;
	}

	public void setServicio(SeguridadSevicio servicio) {
		this.servicio = servicio;
	}
	
}