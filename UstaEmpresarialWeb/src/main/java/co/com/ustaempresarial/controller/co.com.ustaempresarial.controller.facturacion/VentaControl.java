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
import co.com.facturacion.modelo.Venta;
import co.com.facturacion.modelo.Venta;
import co.com.ustaempresarial.bean.FacturacionBean;
import co.com.ustaempresarial.servicio.FacturacionServicio;

@ManagedBean(name = "fact")
@SessionScoped
public class VentaControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int codigo;
	private Date fecha;
	private int codigoCliente;
	private List<Venta> ventas;

	@EJB
	FacturacionServicio facturacionServicio;

	public VentaControl() {
		super();
		try {
			ventas = facturacionServicio.traerVenta();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearVenta(Venta venta) {
		try {
			facturacionServicio.crearVenta(venta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void borrarVenta(int codigoVenta) {
		try {
			facturacionServicio.borrarVenta(codigoVenta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Venta buscarVentaPorCodigo(int codigo) {
		Venta ventaFinal = new Venta();
		try {
			for (Venta venta:ventas) {
				if (venta.getCodigo()== codigo) {
					ventaFinal = venta;
				} else {
					ventaFinal = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ventaFinal;
	}
	
	public void actualizarVenta(Venta venta) {
		try {
			facturacionServicio.actualizarVenta(venta);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	
	
	
}
