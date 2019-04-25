package co.com.facturacion.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the producto_stock database table.
 * 
 */
@Entity
@Table(name="producto_stock")
@NamedQuery(name="ProductoStock.findAll", query="SELECT p FROM ProductoStock p")
public class ProductoStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"CODIGO\"")
	private Integer codigo;

	@Column(name="\"AVERIADO\"")
	private Integer averiado;

	@Column(name="\"BODEGA\"")
	private Integer bodega;

	@Column(name="\"DESPENSA\"")
	private Integer despensa;

	@Temporal(TemporalType.DATE)
	@Column(name="\"FECHA_INVENTARIO\"")
	private Date fechaInventario;

	@Column(name="\"PRODUCTO_CODIGO\"")
	private Integer productoCodigo;

	@Column(name="\"PROVEEDOR_CODIGO\"")
	private Integer proveedorCodigo;

	public ProductoStock() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getAveriado() {
		return this.averiado;
	}

	public void setAveriado(Integer averiado) {
		this.averiado = averiado;
	}

	public Integer getBodega() {
		return this.bodega;
	}

	public void setBodega(Integer bodega) {
		this.bodega = bodega;
	}

	public Integer getDespensa() {
		return this.despensa;
	}

	public void setDespensa(Integer despensa) {
		this.despensa = despensa;
	}

	public Date getFechaInventario() {
		return this.fechaInventario;
	}

	public void setFechaInventario(Date fechaInventario) {
		this.fechaInventario = fechaInventario;
	}

	public Integer getProductoCodigo() {
		return this.productoCodigo;
	}

	public void setProductoCodigo(Integer productoCodigo) {
		this.productoCodigo = productoCodigo;
	}

	public Integer getProveedorCodigo() {
		return this.proveedorCodigo;
	}

	public void setProveedorCodigo(Integer proveedorCodigo) {
		this.proveedorCodigo = proveedorCodigo;
	}

}