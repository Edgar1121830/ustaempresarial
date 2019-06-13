//secciòn ediada por Maria Fernanda Molina Gonzalez
package co.com.ustaempresarial.controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


import co.com.ustaempresarial.servicio.SeguridadSevicio;
import co.com.ustaempresarial.seguridad.modelo.Usuario;


@ManagedBean(name = "seguridadBean")
@SessionScoped

public class SeguridadUsuarioCtrl implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String nombre;
	private String email;
	private Usuario usuarioSeguridad;
	private List<Usuario> usuarios;
	private String password;
	private Date fechaInicio;
	private Date fechaFin;
	private Integer tipo;
	private SeguridadSevicio Servicio;

	public SeguridadUsuarioCtrl() {
		super();
		usuarioSeguridad = new Usuario();
		usuarios = new ArrayList<Usuario>();

	}

	@PostConstruct
	public void cargarUsuarioPages() {
		try {
			usuarios = Servicio.traerUsuarios();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void listarUsuarioSeguridad() {
		try {
			usuarioSeguridad = new Usuario();

			usuarioSeguridad.setCodigo(10);
			usuarioSeguridad.setNombre("borrame editame");
			usuarioSeguridad.setEmail("......");
			usuarioSeguridad.setPassword("...");
	//		usuarioSeguridad.setFechaInicio();
	//		usuarioSeguridad.setFechaFin(fechaFin);
			usuarioSeguridad.setTipo(tipo);
			Servicio.editarUsuario(usuarioSeguridad);
	    	usuarios.addAll(Servicio.traerUsuarios());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void crearUsuarioSeguridad() {
		try {
			Servicio.crearUsuario(usuarioSeguridad);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void eliminarUsuarioSeguridad() {
		try {
			Servicio.borrarUsuario(codigo);
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public SeguridadSevicio getServicio() {
		return Servicio;
	}

	public void setServicio(SeguridadSevicio servicio) {
		Servicio = servicio;
	}

}