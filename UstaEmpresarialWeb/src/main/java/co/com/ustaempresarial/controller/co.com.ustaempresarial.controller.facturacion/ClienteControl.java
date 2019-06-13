package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.facturacion.modelo.Cliente;
import co.com.ustaempresarial.servicio.FacturacionServicio;

@ManagedBean(name = "fact")
@SessionScoped
public class ClienteControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido;
	private String codigoPostal;
	private Date fechaNacimiento;
	private String poblacion;
	private String sexo;
	private String telefono;
	private List<Cliente> clientes;

	@EJB
	FacturacionServicio facturacionServicio;

	public ClienteControl() {
		super();
		try {
			clientes = facturacionServicio.traerCliente();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearCliente(Cliente cliente) {
		try {
			facturacionServicio.crearCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void borrarCliente(int codigo) {
		try {
			facturacionServicio.borrarCliente(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Cliente buscarClientePorNombre(String nombre) {
		Cliente clienteFinal = new Cliente();
		try {
			for (Cliente cliente:clientes) {
				if (cliente.getNombre().equals(nombre)) {
					clienteFinal = cliente;
				} else {
					clienteFinal = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clienteFinal;
	}
	
	public void actualizarCliente(Cliente cliente) {
		try {
			facturacionServicio.actualizarCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
}
