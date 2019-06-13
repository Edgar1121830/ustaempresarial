package co.com.ustaempresarial.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import co.com.ustaempresarial.servicio.NominaServicio;

@RequestScoped
@Named("prin")

public class NominaControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private NominaServicio servicio;
	
	
}
