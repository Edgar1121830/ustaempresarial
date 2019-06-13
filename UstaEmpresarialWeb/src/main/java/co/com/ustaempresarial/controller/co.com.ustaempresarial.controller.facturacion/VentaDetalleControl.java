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
import co.com.facturacion.modelo.VentaDetalle;
import co.com.facturacion.modelo.VentaDetallePK;
import co.com.facturacion.modelo.VentaDetalle;
import co.com.ustaempresarial.bean.FacturacionBean;
import co.com.ustaempresarial.servicio.FacturacionServicio;

@ManagedBean(name = "fact")
@SessionScoped
public class VentaDetalleControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int cantidad;
	private int descuento;
	private int proveedorCodigo;
	private int productoCodigo;
	private boolean estado;
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
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

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public VentaDetallePK getId() {
		return id;
	}

	public void setId(VentaDetallePK id) {
		this.id = id;
	}

	public List<VentaDetalle> getVentaDetalles() {
		return ventaDetalles;
	}

	public void setVentaDetalles(List<VentaDetalle> ventaDetalles) {
		this.ventaDetalles = ventaDetalles;
	}

	private int codigoVenta;
	private VentaDetallePK id;
	private List<VentaDetalle> ventaDetalles;

	@EJB
	FacturacionServicio facturacionServicio;

	public VentaDetalleControl() {
		super();
		try {
			id = new VentaDetallePK();
			id.setVentaCodigo(codigoVenta);
			VentaDetalle ventaDetalle =facturacionServicio.buscarPorID(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearVentaDetalle(VentaDetalle ventaDetalle) {
		try {
			facturacionServicio.crearVentaDetalle(ventaDetalle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void borrarVentaDetalle(int codigoVentaDetalle) {
		try {
			facturacionServicio.borrarVentaDetalle(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public VentaDetalle buscarVentaDetallePorCodigoDeLaVenta(int codigo) {
		VentaDetalle ventaDetalleFinal = new VentaDetalle();
		try {
			for (VentaDetalle ventaDetalle:ventaDetalles) {
				if (ventaDetalle.getId().getVentaCodigo()== codigo) {
					ventaDetalleFinal = ventaDetalle;
				} else {
					ventaDetalleFinal = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ventaDetalleFinal;
	}
	
	public void actualizarVentaDetalle(VentaDetalle ventaDetalle) {
		try {
			facturacionServicio.actualizarVentaDetalle(ventaDetalle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
}
