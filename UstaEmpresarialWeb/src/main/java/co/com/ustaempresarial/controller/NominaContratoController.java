package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import co.com.UstaEmpresarial.nomina.modelo.Contrato;
import co.com.ustaempresarial.servicio.NominaServicio;

@ManagedBean(name= "nmcontrato")
@SessionScoped
public class NominaContratoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NominaServicio servicio;
	
	
	private List<Contrato> listContrato;
	private Contrato objContrato;
	private Contrato objContratoEdit;
	
	public NominaContratoController() {
		super();
		listContrato = new ArrayList<>();
		objContrato = new Contrato();
		objContratoEdit = new Contrato();
	}
	
	   @PostConstruct
	    public void list() {
	        try {
	        	listContrato = servicio.listaContratoTodo();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
	   public void create() {
	        try {
	            servicio.crearContrato(objContrato);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	   
	    public void update() {
	        try {
	            servicio.modificarContrato(objContratoEdit);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	   public void delete(int cod) {
	        try {
	            servicio.eliminarContrato(cod);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }

	   	   public List<Contrato> getListContrato() {
	        return listContrato;
	    }
	   	 
	   	 public void setListContrato(List<Contrato> listContrato) {
	         this.listContrato = listContrato;
	     }

	     public Contrato getContrato() {
	         return objContrato;
	     }

	     public void setContrato(Contrato contrato) {
	         this.objContrato = contrato;
	     }   
	   	   
	   	   
	


	
	
}
