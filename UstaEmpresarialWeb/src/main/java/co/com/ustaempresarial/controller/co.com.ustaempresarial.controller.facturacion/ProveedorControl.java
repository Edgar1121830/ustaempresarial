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
import co.com.facturacion.modelo.Producto;
import co.com.facturacion.modelo.Proveedor;
import co.com.ustaempresarial.servicio.FacturacionServicio;

@ManagedBean(name = "fact")
@SessionScoped
public class ProveedorControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String direccion;
	private String telefono;
	private String paginaWeb;
	private List<Proveedor> proveedores;

	@EJB
	FacturacionServicio facturacionServicio;

	public ProveedorControl() {
		super();
		try {
			proveedores = facturacionServicio.traerProveedor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearProveedor(Proveedor proveedor) {
		try {
			facturacionServicio.crearProveedor(proveedor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void borrarProveedor(int codigoProveedor) {
		try {
			facturacionServicio.borrarProveedor(codigoProveedor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Proveedor buscarProveedorPorNombre(String nombre) {
		Proveedor proveedorFinal = new Proveedor();
		try {
			for (Proveedor proveedor:proveedores) {
				if (proveedor.getNombre().equals(nombre)) {
					proveedorFinal = proveedor;
				} else {
					proveedorFinal = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proveedorFinal;
	}
	
	public void actualizarProveedor(Proveedor proveedor) {
		try {
			facturacionServicio.actualizarProveedor(proveedor);
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	private int proveedorCodigo;

	
	
	
}
