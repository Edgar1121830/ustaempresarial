package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.UstaEmpresarial.nomina.modelo.Nomina;
import co.com.ustaempresarial.servicio.NominaServicio;

@ManagedBean(name = "nm")
@SessionScoped
public class NominaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NominaServicio servicio;

	private List<Nomina> listNomina;
	private Nomina objNomina;
	private Nomina objNominaEdit;

	public NominaController() {
		super();
		listNomina = new ArrayList<>();
		objNomina = new Nomina();
		objNominaEdit = new Nomina();
	}

	@PostConstruct
	public void list() {
		try {
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void create() {
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		try {
			servicio.editarNomina(objNominaEdit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(int cod) {
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Nomina> getListNomina() {
		return listNomina;
	}

	public void setListNomina(List<Nomina> listNomina) {
		this.listNomina = listNomina;
	}

	public Nomina getNomina() {
		return objNomina;
	}

	public void setNomina(Nomina Nomina) {
		this.objNomina = Nomina;
	}

}
