package co.com.ustaempresarial.bean;

import co.com.ustaempresarial.fachada.FinanzasFachada;
import co.com.ustaempresarial.finanzas.modelo.Concepto;
import co.com.ustaempresarial.finanzas.modelo.LibroDiario;
import co.com.ustaempresarial.finanzas.modelo.LibroMayor;
import co.com.ustaempresarial.finanzas.modelo.Periodo;
import co.com.ustaempresarial.finanzas.modelo.PlanContable;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FinanzasBean implements FinanzasFachada {

    @PersistenceContext(unitName = "FinanzasModelo")
    public EntityManager em;

    public FinanzasBean() {
        super();
    }

    @Override
    public void crearLibroDiario(LibroDiario libroDiario) throws Exception {
        if (libroDiario.getAsiento() != null && libroDiario.getValor() != null) {
            em.persist(libroDiario);
            em.flush();
        }
    }

    @Override
    public List<LibroDiario> listarLibroDiario() throws Exception {
        List<LibroDiario> libroDiario = new ArrayList<>();
        Query q = em.createNamedQuery(LibroDiario.LISTARLibroDiario);
        libroDiario = q.getResultList();
        return libroDiario;
    }

    @Override
    public LibroDiario listalibroDiarioByNombre(String nombre) throws Exception {
        LibroDiario objlibroDiario = new LibroDiario();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery

                    (LibroDiario.LISTARLibroDiarioBYNAME).setParameter("nombre", nombre);
            Object obj = q.getSingleResult();
            objlibroDiario = (LibroDiario) obj;
        }

        return objlibroDiario;
    }

    @Override
    public List<LibroDiario> listarLibroDiariosByNombre(String nombre) throws Exception {
        List<LibroDiario> listLibroDiario = new ArrayList<>();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery

                    (LibroDiario.LISTARLibroDiarioBYNAME).setParameter("nombre", nombre);

            listLibroDiario = q.getResultList();
        }
        return listLibroDiario;
    }

    @Override
    public LibroDiario listarLibroDiarioById(int id) throws Exception {
        return null;
    }

    @Override
    public LibroDiario editarLibroDiario(LibroDiario libroDiario) throws Exception {
        new LibroDiario();
        LibroDiario p;
        if (libroDiario != null) {
            p = buscarLibroDiarioById(libroDiario.getAsiento());
            if (p.getAsiento() > 0) {
                em.merge(libroDiario);
                em.flush();
            } else {
                libroDiario = null;
            }
        }
        return libroDiario;
    }

    @Override
    public boolean eliminarLibroDiario(int codigo) throws Exception {
        LibroDiario LibroDiario = buscarLibroDiarioById(codigo);
        boolean retorno = false;
        LibroDiario.setEstado(false);
        if (LibroDiario.getAsiento() > 0) {
            em.merge(LibroDiario);
            retorno = true;
        }
        return retorno;
    }

    public LibroDiario buscarLibroDiarioById(int codigo) throws Exception {
        LibroDiario p = new LibroDiario();
        p = em.find(LibroDiario.class, codigo);
        return p;
    }

    @Override
    public void crearLibroMayor(LibroMayor libroMayor) throws Exception {
        if (libroMayor.getId() != null && libroMayor.getDebe() != null) {
            em.persist(libroMayor);
            em.flush();
        }
    }

    @Override
    public List<LibroMayor> listarLibroMayor() throws Exception {
        List<LibroMayor> libroMayor;
        Query q = em.createNamedQuery(LibroMayor.LISTARLibroMayor);
        libroMayor = q.getResultList();
        return libroMayor;
    }

    @Override
    public LibroMayor listarLibroMayorByNombre(String nombre) throws Exception {
        LibroMayor objLibroMayor = new LibroMayor();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery(LibroMayor.LISTARLibroMayorBYNAME).setParameter("nombre", nombre);
            Object obj = q.getSingleResult();
            objLibroMayor = (LibroMayor) obj;
        }
        return objLibroMayor;
    }

    @Override
    public List<LibroMayor> listarLibroMayorsByNombre(String nombre) throws Exception {
        List<LibroMayor> listLibroMayor = new ArrayList<>();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery(LibroMayor.LISTARLibroMayorBYNAME).setParameter("nombre", nombre);
            listLibroMayor = q.getResultList();
        }
        return listLibroMayor;
    }

    @Override
    public LibroMayor listarLibroMayorById(int id) throws Exception {
        return null;
    }

    public LibroMayor editarLibroMayor(LibroMayor libroMayor) throws Exception {
        LibroMayor p = new LibroMayor();
        if (libroMayor != null) {
            p = buscarLibroMayorById(libroMayor.getId().getPeriodoCod());
            if (p.getId().getPeriodoCod() > 0) {
                em.merge(libroMayor);
                em.flush();
            } else {
                libroMayor = null;
            }
        }
        return libroMayor;
    }

    public boolean eliminarLibroMayor(int codigo) throws Exception {
        LibroMayor LibroMayor = buscarLibroMayorById(codigo);
        boolean retorno = false;
        LibroMayor.setEstado(false);
        if (LibroMayor.getId().getPeriodoCod() > 0) {
            em.merge(LibroMayor);
            retorno = true;
        }
        return retorno;
    }

    public LibroMayor buscarLibroMayorById(int codigo) throws Exception {
        LibroMayor p = new LibroMayor();
        p = em.find(LibroMayor.class, codigo);
        return p;
    }
    

    public Periodo buscarPeriodoPorCodigo(int codigo) throws Exception {
    	Periodo p = new Periodo();
		p = em.find(Periodo.class, codigo);
		return p;
	}
    
    public void crearPeriodo(Periodo periodo) throws Exception{
    	if (periodo.getCodigo() != null ) {
            em.persist(periodo);
            em.flush();
        }
    }
       
	public Periodo editarPeriodo(Periodo periodo) throws Exception {
		Periodo newcampania = new Periodo();
		newcampania = buscarPeriodoPorCodigo(periodo.getCodigo());
			if (newcampania.getCodigo()>0) {
				em.merge(periodo);
			}else newcampania = null;

		return newcampania;		
	}

    public boolean eliminarPeriodo(int codigo) throws Exception {
    	Periodo periodo = buscarPeriodoPorCodigo(codigo);
        boolean retorno = false;
        periodo.setEstado(false);
        if (periodo.getCodigo() > 0) {
            em.merge(periodo);
            retorno = true;
        }
        return retorno;
    }
    
    public List<Periodo> listarPeriodo() throws Exception {

        List<Periodo> periodo;
        Query q = em.createNamedQuery(Periodo.LISTARPERIODO);
        periodo = q.getResultList();
        return periodo;
    }

    public Periodo listarPeriodoPorNombre(String nombre) throws Exception {
    	Periodo objPeriodo = new Periodo();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery(Periodo.LISTARPERIODOBYNAME).setParameter("nombre", nombre);
            Object obj = q.getSingleResult();
            objPeriodo = (Periodo) obj;
        }
        return objPeriodo;
    }

    public Concepto buscarConceptoPorCodigo(int codigo) throws Exception {
    	Concepto p = new Concepto();
		p = em.find(Concepto.class, codigo);
		return p;
	}
    
    public void crearConcepto(Concepto concepto) throws Exception{
    	if (concepto.getCodigo() != null ) {
            em.persist(concepto);
            em.flush();
        }
    }
       
	public Concepto editarConcepto(Concepto concepto) throws Exception {
		Concepto newcampania = new Concepto();
		newcampania = buscarConceptoPorCodigo(concepto.getCodigo());
			if (newcampania.getCodigo()>0) {
				em.merge(concepto);
			}else newcampania = null;

		return newcampania;		
	}
    
    public boolean eliminarConcepto(int codigo) throws Exception {
    	Concepto concepto = buscarConceptoPorCodigo(codigo);
        boolean retorno = false;
        if (concepto.getCodigo() > 0) {
            em.remove(concepto);;
            retorno = true;
        }
        return retorno;
    }
    
    public List<Concepto> listarConcepto() throws Exception {
        List<Concepto> concepto;
        Query q = em.createNamedQuery(Concepto.LISTARCONCEPTO);
        concepto = q.getResultList();
        return concepto;
    }
    
    public Concepto listarConceptoPorNombre(String nombre) throws Exception {
    	Concepto objConcepto = new Concepto();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery(Concepto.LISTARCONCEPTOBYNAME).setParameter("nombre", nombre);
            Object obj = q.getSingleResult();
            objConcepto = (Concepto) obj;
        }
        return objConcepto;
    }

    public PlanContable buscarPlanContablePorCodigo(int codigo) throws Exception {
    	PlanContable p = new PlanContable();
		p = em.find(PlanContable.class, codigo);
		return p;
	}
    
    public void crearPlanContable(PlanContable plan_contable) throws Exception{
    	if (plan_contable.getCodigo() != null ) {
            em.persist(plan_contable);
            em.flush();
        }
    }
       
	public PlanContable editarPlanContable(PlanContable plan_contable) throws Exception {
		PlanContable newcampania = new PlanContable();
		newcampania = buscarPlanContablePorCodigo(plan_contable.getCodigo());
			if (newcampania.getCodigo()>0) {
				em.merge(plan_contable);
			}else newcampania = null;

		return newcampania;		
	}
      
    public boolean eliminarPlanContable(int codigo) throws Exception {
    	PlanContable plan_contable = buscarPlanContablePorCodigo(codigo);
        boolean retorno = false;
        if (plan_contable.getCodigo() > 0) {
            em.merge(plan_contable);
            retorno = true;
        }
        return retorno;
    }
    
    public List<PlanContable> listarPlanContable() throws Exception {
        List<PlanContable> plan_contable;
        Query q = em.createNamedQuery(PlanContable.LISTARPLANCONTABLE);
        plan_contable = q.getResultList();
        return plan_contable;
    }
    
    public PlanContable listarPlanContablePorNombre(String nombre) throws Exception {
    	PlanContable objPlanContable = new PlanContable();
        if (nombre != null && !nombre.equals("")) {
            Query q = em.createNamedQuery(PlanContable.LISTARPLANCONTABLEBYNAME).setParameter("nombre", nombre);
            Object obj = q.getSingleResult();
            objPlanContable = (PlanContable) obj;
        }
        return objPlanContable;
    }

	
}
