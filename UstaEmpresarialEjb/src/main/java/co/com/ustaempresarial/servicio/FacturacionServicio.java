package co.com.ustaempresarial.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.facturacion.modelo.Cliente;
import co.com.facturacion.modelo.Producto;
import co.com.facturacion.modelo.Proveedor;
import co.com.facturacion.modelo.ProveedorProducto;
import co.com.facturacion.modelo.ProveedorProductoPK;
import co.com.facturacion.modelo.Venta;
import co.com.facturacion.modelo.VentaDetalle;
import co.com.facturacion.modelo.VentaDetallePK;
import co.com.ustaempresarial.fachada.FacturacionFachada;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class FacturacionServicio {
	
	@EJB
	FacturacionFachada fachada;
	
	public List<CategoriaProducto> buscarPorNombre(String nombre) throws Exception{
		return fachada.buscarCategoriaPorNombre(nombre);
	}
	
	
	public CategoriaProducto editarCategoriaProducto(CategoriaProducto categoriaProducto) throws Exception {
		return fachada.editarCategoriaProducto(categoriaProducto);
	}
	
	public boolean borrarCategoriaProducto(int codigo) throws Exception {
		return fachada.borrarCategoriaProducto(codigo);
	}
	
	public List<CategoriaProducto> traerProductos() throws Exception {
		return fachada.traerProductos();
	}
	
	public void crearCagtegoriaProducto(CategoriaProducto producto) throws Exception {
		fachada.crearCagtegoriaProducto(producto);
	}
	
	//------------------------CRUD DE VENTA-DETALLE - PK--------------------------------
		
		public VentaDetalle actualizarVentaDetalle(VentaDetalle detalle) throws Exception{
			return	fachada.actualizarVentaDetalle(detalle);}
		
	
		public void crearVentaDetalle(VentaDetalle detalle) throws Exception{
			 fachada.crearVentaDetalle(detalle);}
		
		public boolean borrarVentaDetalle(VentaDetallePK id) throws Exception{
			return fachada.borrarVentaDetalle(id);}
	
		public VentaDetalle buscarPorID(VentaDetallePK id) throws Exception{
			return fachada.buscarPorID(id);}
		
		//------------------------CRUD DE CLIENTE--------------------------------
		
		public Cliente actualizarCliente(Cliente cliente) throws Exception{
			return fachada.actualizarCliente(cliente);
		}
		
		public void crearCliente(Cliente cliente) throws Exception{
		fachada.crearCliente(cliente);}
	
		public boolean borrarCliente(int codigo) throws Exception{
			return fachada.borrarCliente(codigo);}
		
		public List<Cliente> traerCliente() throws Exception{
			return fachada.traerCliente();}
		
		//------------------------CRUD DE VENTA--------------------------------
		public Venta actualizarVenta(Venta venta) throws Exception{
			return fachada.actualizarVenta(venta);}
		
		public void crearVenta(Venta venta) throws Exception{
			 fachada.crearVenta(venta);
		}
		
		public boolean borrarVenta(int codigo) throws Exception{
			return fachada.borrarVenta(codigo);	
		}
	
		public List<Venta> traerVenta() throws Exception{
			return fachada.traerVenta();}
		//------------------------CRUD DE PRODUCTO--------------------------------
		
		public Producto actualizarProducto(Producto producto) throws Exception{
			return fachada.actualizarProducto(producto);
		}
	
		public void crearProducto(Producto producto) throws Exception{
		fachada.crearProducto(producto);	
		}
		
		public boolean borrarProducto(int codigo) throws Exception{
			return fachada.borrarProducto(codigo);	
		}
		
		
		public List<Producto> traerProducto() throws Exception{
			return fachada.traerProducto();	
		}
		//------------------------CRUD DE PROVEEDOR--------------------------------
		
		public Proveedor actualizarProveedor(Proveedor proveedor) throws Exception{
			return fachada.actualizarProveedor(proveedor);
		}
	
		public void crearProveedor(Proveedor proveedor) throws Exception{
			fachada.crearProveedor(proveedor);
			
		}
	
		public boolean borrarProveedor(int codigo) throws Exception{
			return fachada.borrarProveedor(codigo);
		}
	
		 
		public List<Proveedor> traerProveedor() throws Exception{
			return fachada.traerProveedor();	
		}
		//------------------------CRUD DE PROVEEDOR-PRODUCTO -PK--------------------------------
	
	
		public ProveedorProducto actualizarProveedorProducto(ProveedorProducto detalle) throws Exception{
			return fachada.actualizarProveedorProducto(detalle);	
		}
		
	
		 
		public void crearProveedorProducto(ProveedorProducto detalle) throws Exception{
		fachada.crearProveedorProducto(detalle);	
		}
	
		  
		public boolean borrarProveedorProducto(ProveedorProductoPK id) throws Exception{
			return fachada.borrarProveedorProducto(id);	
		}
	
		 
		public List<ProveedorProducto> traerProveedorProducto() throws Exception{
			return fachada.traerProveedorProducto();	
		}
	

}
