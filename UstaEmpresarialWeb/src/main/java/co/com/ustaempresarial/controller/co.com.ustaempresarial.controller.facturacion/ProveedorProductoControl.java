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
import co.com.facturacion.modelo.ProveedorProducto;
import co.com.ustaempresarial.servicio.FacturacionServicio;

@ManagedBean(name = "fact")
@SessionScoped
public class ProveedorProductoControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int precioUnitario;
	private Date fechaVigencia;
	private int peso;
	private int proveedorCodigo;
	private int productoCodigo;
	private List<ProveedorProducto> proveedoresProductos;

	@EJB
	FacturacionServicio facturacionServicio;

	public ProveedorProductoControl() {
		super();
		try {
			proveedoresProductos = facturacionServicio.traerProveedorProducto();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearProveedor(ProveedorProducto porveedorProducto) {
		try {
			facturacionServicio.crearProveedorProducto(porveedorProducto);
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
	
	public ProveedorProducto buscarProveedorProductoPorCodigoDeProducto(int codigo) {
		ProveedorProducto proveedorProductoFinal = new ProveedorProducto();
		
		try {
			for (ProveedorProducto porveedorProducto:proveedoresProductos) {
				int codigoDelPorducto=porveedorProducto.getId().getProductoCodigo();
				if (codigoDelPorducto == codigo) {
					proveedorProductoFinal = porveedorProducto;
				} else {
					proveedorProductoFinal = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return proveedorProductoFinal;
	}
	
	public void actualizarProveedor(ProveedorProducto porveedorProducto) {
		try {
			facturacionServicio.actualizarProveedorProducto(porveedorProducto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getProveedorCodigo() {
		return proveedorCodigo;
	}

	public void setProveedorCodigo(int proveedorCodigo) {
		this.proveedorCodigo = proveedorCodigo;
	}

	public int getProductoCodigo() {
		return productoCodigo;
	}

	public void setProductoCodigo(int productoCodigo) {
		this.productoCodigo = productoCodigo;
	}

	public List<ProveedorProducto> getProveedoresProductos() {
		return proveedoresProductos;
	}

	public void setProveedoresProductos(List<ProveedorProducto> proveedoresProductos) {
		this.proveedoresProductos = proveedoresProductos;
	}

	
	
}
