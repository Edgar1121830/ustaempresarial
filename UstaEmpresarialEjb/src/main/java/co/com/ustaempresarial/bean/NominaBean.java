package co.com.ustaempresarial.bean;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.UstaEmpresarial.nomina.modelo.Nomina;
import co.com.UstaEmpresarial.nomina.modelo.Periodo;
import co.com.ustaempresarial.fachada.NominaFachada;

public class NominaBean implements NominaFachada {

    @PersistenceContext(unitName = "nomina")
    private EntityManager em;

    public NominaBean() {

        super();

    }

	@Override
	public List<Nomina> obtenerNominas() throws Exception {

		   Query q = em.createNamedQuery(Nomina.);
	        nomina = q.getResultList();

	        return cargos;
		return null;
	}

	@Override
	public void crearNomina(Nomina nomina) throws Exception {
		
	}
	

	@Override
	public Nomina editarNomina(Nomina nomina) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrarNomina(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public List<Periodo> obtenerPeriodo() throws Exception {
		
		List<Periodo> periodo = new ArrayList<Periodo>();

		Query query = em.createNamedQuery(periodo.findALL);

		periodo = query.getResultList();

		return periodo;
		return null;
	}

	@Override
	public void crearPeriodo(Periodo periodo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Nomina editarPeriodo(Periodo periodo) throws Exception {
		
		Periodo periodo1 = new Periodo();
		periodo1 =  buscarPeriodoPorId(periodo1.getCodigo());
		if (periodo1.getCodigo() > 0) {
			em.merge(Periodo);
		} else
			periodo1 = null;

		return periodo1;
	}

	@Override
	public boolean borrarPeriodo(int id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Nomina> buscarPeriodoPorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
