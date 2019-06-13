package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
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
public class CategoriaProductoControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String caracteristica;
	private List<CategoriaProducto> categorias;

	@EJB
	FacturacionServicio facturacionServicio;

	public CategoriaProductoControl() {
		super();
		try {
			categorias = facturacionServicio.traerProductos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void crearCagtegoriaProducto(CategoriaProducto producto) {
		try {
			facturacionServicio.crearCagtegoriaProducto(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public CategoriaProducto buscarCategoriaPorNombre(String nombre) {
		CategoriaProducto categoriaFinal = new CategoriaProducto();
		try {
			for (CategoriaProducto categoria:categorias) {
				if (categoria.getNombre().equals(nombre)) {
					categoriaFinal = categoria;
				} else {
					categoriaFinal = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoriaFinal;
	}

	public void editarCategoriaProducto(CategoriaProducto categoriaProducto) {
		try {
			facturacionServicio.editarCategoriaProducto(categoriaProducto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void borrarCategoriaProducto(int codigo) {
		try {
			facturacionServicio.borrarCategoriaProducto(codigo);
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
