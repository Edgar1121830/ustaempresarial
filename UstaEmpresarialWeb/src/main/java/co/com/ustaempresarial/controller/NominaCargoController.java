package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import co.com.UstaEmpresarial.nomina.modelo.Cargo;
import co.com.ustaempresarial.servicio.NominaServicio;

@ManagedBean(name= "nmcargo")
@SessionScoped
public class NominaCargoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
private NominaServicio servicio;
	
	
	private List<Cargo> listCargo;
	private Cargo objCargo;
	private Cargo objCargoEdit;
	
	public NominaCargoController() {
		super();
		listCargo = new ArrayList<>();
		objCargo = new Cargo();
		objCargoEdit = new Cargo();
	}
	
	
	
	   @PostConstruct
	    public void list() {
	        try {
	        	listCargo = servicio.listarCargos();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
	   public void create() {
	        try {
	            servicio.crearCargo(objCargo);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	   
	    public void update() {
	        try {
	            servicio.editarCargo(objCargoEdit);
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
	    

	   	   public List<Cargo> getListCargo() {
	        return listCargo;
	    }
	   	 
	   	 public void setListCargo(List<Cargo> listCargo) {
	         this.listCargo = listCargo;
	     }

	     public Cargo getCargo() {
	         return objCargo;
	     }

	     public void setCargo(Cargo Cargo) {
	         this.objCargo = Cargo;
	     }   
	   	   
	   	   
	
}
