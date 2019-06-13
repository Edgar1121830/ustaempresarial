package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.UstaEmpresarial.nomina.modelo.Concepto;
import co.com.ustaempresarial.servicio.NominaServicio;

@ManagedBean(name = "nmconcepto")
@SessionScoped
public class NominaConceptoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NominaServicio servicio;

	private List<Concepto> listConcepto;
	private Concepto objConcepto;
	private Concepto objConceptoEdit;

	public NominaConceptoController() {
		super();
		listConcepto = new ArrayList<>();
		objConcepto = new Concepto();
		objConceptoEdit = new Concepto();
	}

	@PostConstruct
	public void list() {
		try {
			listConcepto = servicio.listarConceptos();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void create() {
		try {
			servicio.crearConcepto(objConcepto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			servicio.editarConcepto(objConceptoEdit);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int cod) {
		try {
			servicio.borrarConcepto(cod);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Concepto> getListConcepto() {
		return listConcepto;
	}

	public void setListConcepto(List<Concepto> listConcepto) {
		this.listConcepto = listConcepto;
	}

	public Concepto getConcepto() {
		return objConcepto;
	}

	public void setConcepto(Concepto Concepto) {
		this.objConcepto = Concepto;
	}

}
