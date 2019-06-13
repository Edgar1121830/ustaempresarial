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
import co.com.ustaempresarial.servicio.FacturacionServicio;

@ManagedBean(name = "fact")
@SessionScoped
public class ProductoControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String caracteristica;
	private List<Producto> productos;

	@EJB
	FacturacionServicio facturacionServicio;

	public ProductoControl() {
		super();
		try {
			productos = facturacionServicio.traerProducto();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearProducto(Producto producto) {
		try {
			facturacionServicio.crearProducto(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void borrarProducto(int codigoProducto) {
		try {
			facturacionServicio.borrarProducto(codigoProducto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Producto buscarProductoPorNombre(String nombre) {
		Producto productoFinal = new Producto();
		try {
			for (Producto producto:productos) {
				if (producto.getNombre().equals(nombre)) {
					productoFinal = producto;
				} else {
					productoFinal = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productoFinal;
	}
	
	public void actualizarProducto(Producto producto) {
		try {
			facturacionServicio.actualizarProducto(producto);
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

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	
}
