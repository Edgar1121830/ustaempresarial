package co.com.UstaEmpresarial.nomina.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the contrato database table.
 * 
 */
@Entity
@NamedQuery(name="Contrato.findAll", query="SELECT c FROM Contrato c")
public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private Integer cargoCod;
	private Integer dependenciaCod;
	private Date fechaFin;
	private Date fechaInicio;
	private Integer hojaVidaDoc;
	private Integer salario;

	public Contrato() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	@Column(name="cargo_cod")
	public Integer getCargoCod() {
		return this.cargoCod;
	}

	public void setCargoCod(Integer cargoCod) {
		this.cargoCod = cargoCod;
	}


	@Column(name="dependencia_cod")
	public Integer getDependenciaCod() {
		return this.dependenciaCod;
	}

	public void setDependenciaCod(Integer dependenciaCod) {
		this.dependenciaCod = dependenciaCod;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	@Column(name="hoja_vida_doc")
	public Integer getHojaVidaDoc() {
		return this.hojaVidaDoc;
	}

	public void setHojaVidaDoc(Integer hojaVidaDoc) {
		this.hojaVidaDoc = hojaVidaDoc;
	}


	public Integer getSalario() {
		return this.salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

}