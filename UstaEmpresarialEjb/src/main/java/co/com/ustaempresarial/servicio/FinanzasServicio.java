package co.com.ustaempresarial.servicio;

import co.com.ustaempresarial.fachada.*;
import co.com.ustaempresarial.finanzas.modelo.Concepto;
import co.com.ustaempresarial.finanzas.modelo.LibroDiario;
import co.com.ustaempresarial.finanzas.modelo.LibroMayor;
import co.com.ustaempresarial.finanzas.modelo.Periodo;
import co.com.ustaempresarial.finanzas.modelo.PlanContable;

import javax.ejb.*;
import javax.persistence.Query;

import java.util.List;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class FinanzasServicio {

	FinanzasFachada fachada;

	public List<LibroDiario> listarLibroDiario() throws Exception {
		return fachada.listarLibroDiario();
	}

	public void crearLibroDiarior(LibroDiario LibroDiario) throws Exception {
		fachada.crearLibroDiario(LibroDiario);
	}

	public LibroDiario editarLibroDiario(LibroDiario LibroDiario) throws Exception {
		return fachada.editarLibroDiario(LibroDiario);
	}

	public boolean eliminarLibroDiario(int cod) throws Exception {
		return fachada.eliminarLibroDiario(cod);
	}

	public LibroDiario listarLibroDiarioById(int cod) throws Exception {
		return fachada.listarLibroDiarioById(cod);
	}

	public List<LibroDiario> listarLibroDiariosByNombre(String nombre) throws Exception {
		return fachada.listarLibroDiariosByNombre(nombre);
	}

	public List<LibroMayor> listarLibroMayor() throws Exception {
		return fachada.listarLibroMayor();
	}

	public void crearLibroMayorr(LibroMayor LibroMayor) throws Exception {
		fachada.crearLibroMayor(LibroMayor);
	}

	public LibroMayor editarLibroMayor(LibroMayor LibroMayor) throws Exception {
		return fachada.editarLibroMayor(LibroMayor);
	}

	public boolean eliminarLibroMayor(int cod) throws Exception {
		return fachada.eliminarLibroMayor(cod);
	}

	public LibroMayor listarLibroMayorById(int cod) throws Exception {
		return fachada.listarLibroMayorById(cod);
	}

	public List<LibroMayor> listarLibroMayorsByNombre(String nombre) throws Exception {
		return fachada.listarLibroMayorsByNombre(nombre);
	}
	    
    
       
	public Periodo editarPeriodo(Periodo periodo) throws Exception {
		return fachada.editarPeriodo(periodo);
	}

    public boolean eliminarPeriodo(int codigo) throws Exception {
		return fachada.eliminarPeriodo(codigo);
    	
    }
    
    public List<Periodo> listarPeriodo() throws Exception {
    	return fachada.listarPeriodo();
    }

    public Periodo listarPeriodoPorNombre(String nombre) throws Exception {
    	return fachada.listarPeriodoPorNombre(nombre);
    }

       
    
       
	public Concepto editarConcepto(Concepto concepto) throws Exception {
		return fachada.editarConcepto(concepto);
	}
    
    public boolean eliminarConcepto(int codigo) throws Exception {
    	return fachada.eliminarConcepto(codigo);
    }
    
    public List<Concepto> listarConcepto() throws Exception {
    	return fachada.listarConcepto();
    }
    
    public Concepto listarConceptoPorNombre(String nombre) throws Exception {
    	return fachada.listarConceptoPorNombre(nombre);
    }

    
   
       
	public PlanContable editarPlanContable(PlanContable plan_contable) throws Exception {
		return fachada.editarPlanContable(plan_contable);
	}
      
    public boolean eliminarPlanContable(int codigo) throws Exception {
    	return fachada.eliminarPlanContable(codigo);
    }
    
    public List<PlanContable> listarPlanContable() throws Exception {
    	return fachada.listarPlanContable();
    }
    
    public PlanContable listarPlanContablePorNombre(String nombre) throws Exception {
    	return fachada.listarPlanContablePorNombre(nombre);
    }

}
