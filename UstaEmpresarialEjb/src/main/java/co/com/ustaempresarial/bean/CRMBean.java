package co.com.ustaempresarial.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.ustaempresarial.modelo.crm.Campania;
import co.com.ustaempresarial.modelo.crm.Evento;
import co.com.ustaempresarial.modelo.crm.Medio;
import co.com.ustaempresarial.modelo.crm.Periodo;
import co.com.ustaempresarial.modelo.crm.Recurso;
import co.com.ustaempresarial.modelo.crm.TipoMedio;
import co.com.ustaempresarial.fachada.CRMFachada;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CRMBean implements CRMFachada {

	@PersistenceContext(unitName = "UstaEmpresarialCRM")
	private EntityManager em;

	public CRMBean() {
		super();
	}
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Campania> obtenerCampania() throws Exception {
		List<Campania> campania = new ArrayList<Campania>();
		Query query = em.createNamedQuery(Campania.TRAER_CAMPANIA);
		campania = query.getResultList();
		return campania;
	}

	@Override
	public void crearCampania(Campania campania) throws Exception {
		if (campania.getNombre() != null && !campania.getNombre().equals("")) {
			em.persist(campania);
		}

	}

	private Campania buscarCampaniaPorId(int codigo) throws Exception {
		Campania p = new Campania();
		p = em.find(Campania.class, codigo);
		return p;
	}
	
	@Override
	public Campania editarCampania(Campania campania) throws Exception {
		Campania newCampania = new Campania();
		newCampania = buscarCampaniaPorId(campania.getCodigo());
			if (newCampania.getCodigo()>0) {
				em.merge(campania);
			}else newCampania = null;
		
		return newCampania;		
	}

	@Override
	public boolean borrarCampania(int codigo) throws Exception {
		Campania campania = buscarCampaniaPorId(codigo);
		boolean retorno = false;
		if (campania.getCodigo() > 0) {
			em.remove(campania);
			retorno = true;
		}

		return retorno;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Campania> buscarCampaniaPorNombre(String nombre) throws Exception {
		List<Campania> campania = new ArrayList<Campania>();
		Query query = em.createNamedQuery(Campania.ENCONTRAR_POR_NOMBRE);
		if (nombre != null) {
			query.setParameter("nombre", nombre);
			campania =query.getResultList();
		}
		return campania;
	}

	//Recurso
	@Override
	@SuppressWarnings("unchecked")
	public List<Recurso> listarRecursos() throws Exception {
		List<Recurso> recursos = new ArrayList<>();
		Query q = em.createNamedQuery(Recurso.TRAER_RECURSO);
		recursos = q.getResultList();
		return recursos;
	}

	@Override
	public void crearRecurso(Recurso recurso) throws Exception {
		if (recurso.getNombre().equals("") && recurso.getNombre() != null ) {	
			em.persist(recurso);
			em.flush();
		}
	}

	@Override
	public Recurso editarRecurso(Recurso recurso) throws Exception {
		Recurso p = new Recurso();
		if (recurso != null) {
			p = buscarRecursoID(recurso.getCodigo());
			if (p.getCodigo()> 0) {
				em.merge(recurso);
				em.flush();
			}else {
				recurso=null;
			}
		}
		return recurso;
	}

	@Override
	public boolean eliminarRecurso(int codigo) throws Exception {
		Recurso rec = buscarRecursoID(codigo);
		boolean retorno = false;
		if (rec.getCodigo() > 0) {
			em.remove(rec);
			retorno = true;
		}
		return retorno;
	}

	@Override
	public Recurso listarRecursoNombre(String nombre) throws Exception {
		Recurso objRecurso = new Recurso();
		if (nombre != null && !nombre.equals("")) {
			Query q = em.createNamedQuery(Recurso.ENCONTRAR_POR_NOMBRE).setParameter("nombre", nombre);
			Object obj = q.getSingleResult();
			objRecurso = (Recurso) obj;
		}
		return objRecurso;
	}


	private Recurso buscarRecursoID(int cod) throws Exception {
		Recurso p = new Recurso();
		p = em.find(Recurso.class, cod);
		return p;
	}
	
	//Tipo_medio
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TipoMedio> listarTipoMedio() throws Exception {
		List<TipoMedio> tipos = new ArrayList<>();
		Query q = em.createNamedQuery(TipoMedio.TRAER_TIPOMEDIO);
		tipos = q.getResultList();
		return tipos;
	}

	@Override
	public void crearTipoMedio(TipoMedio tipo) throws Exception {
		if (tipo.getNombre() != null && !tipo.getNombre().equals("")) {
			em.persist(tipo);
			em.flush();
		}
	}

	@Override
	public TipoMedio editarTipoMedio(TipoMedio tipo) throws Exception {
		TipoMedio T = new TipoMedio();
		if (tipo != null) {
			T = buscarTipoPorId(tipo.getCodigo());
			if (T.getCodigo()> 0) {
				em.merge(tipo);
				em.flush();
			}else {
				tipo=null;
			}
		}
		return tipo;
	}

	@Override
	public boolean eliminarTipoMedio(int codigo) throws Exception {
		TipoMedio cod = buscarTipoPorId(codigo);
		boolean retorno = false;
		if (cod.getCodigo() > 0) {
			em.remove(cod);
			retorno = true;
		}
		return retorno;
	}


	@Override
	public TipoMedio listarTipoMedioByNombre(String nombre) throws Exception {
		TipoMedio objMedio = new TipoMedio();
		if (nombre != null && !nombre.equals("")) {
			Query q = em.createNamedQuery(TipoMedio.ENCONTRAR_POR_NOMBRE).setParameter("nombre", nombre);
			Object obj = q.getSingleResult();
			objMedio = (TipoMedio) obj;
		}
		return objMedio;
	}
	
	private TipoMedio buscarTipoPorId(int codigo) throws Exception {
		TipoMedio p = new TipoMedio();
		p = em.find(TipoMedio.class, codigo);
		return p;
	}
	
	
	//Periodo
	@Override
	public void crearPeriodo(Periodo per) throws Exception {
		if ( per.getCodigo() >0){
			em.persist(per);
			em.flush();
		}
	}
	

	@Override
	public Periodo editarPeriodo(Periodo per) throws Exception {
		Periodo periodo = new Periodo();
		if (per != null) {
			periodo = buscarPeriodoPorId(per.getCodigo());
			if (periodo.getCodigo()> 0) {
				em.merge(per);
				em.flush();
			}else {
				periodo=null;
			}
		}
		return periodo;
	}

	@Override
	public boolean eliminarRegistros (int codigo) throws Exception {
		Periodo periodo = buscarPeriodoPorId(codigo);
		boolean retorno = true;
		if (periodo.getCodigo() > 0) {
			retorno = false;
		}
		return retorno;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Periodo> listarPeriodo() throws Exception {
		List<Periodo> periodos = new ArrayList<>();
		Query q = em.createNamedQuery(Periodo.TRAER_PERIODO);
		periodos = q.getResultList();
		return periodos;
	}
	
	private Periodo buscarPeriodoPorId(int codigo) throws Exception {
		Periodo p = new Periodo();
		p = em.find(Periodo.class, codigo);
		return p;
	}
	
	//Medio
	@Override
	@SuppressWarnings("unchecked")
	public List<Medio> obtenerMedio() throws Exception {
		List<Medio> medio = new ArrayList<Medio>();
		Query query = em.createNamedQuery(Medio.TRAER_MEDIO);
		medio = query.getResultList();
		return medio;
	}

	@Override
	public void crearMedio(Medio medio) throws Exception {
		if (medio.getNombre() != null && !medio.getNombre().equals("")) {
			em.persist(medio);
		}

	}

	private Medio buscarMedioPorId(int codigo) throws Exception {
		Medio p = new Medio();
		p = em.find(Medio.class, codigo);
		return p;
	}
	
	@Override
	public Medio editarMedio(Medio medio) throws Exception {
		Medio newMedio = new Medio();
		newMedio = buscarMedioPorId(medio.getCodigo());
			if (newMedio.getCodigo()>0) {
				em.merge(medio);
			}else newMedio = null;
		
		return newMedio;		
	}

	@Override
	public boolean borrarMedio(int codigo) throws Exception {
		Medio medio = buscarMedioPorId(codigo);
		boolean retorno = false;
		if (medio.getCodigo() > 0) {
			em.remove(medio);
			retorno = true;
		}

		return retorno;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Medio> buscarMedioPorNombre(String nombre) throws Exception {
		List<Medio> medio = new ArrayList<Medio>();
		Query query = em.createNamedQuery(Medio.ENCONTRAR_POR_NOMBRE);
		if (nombre != null) {
			query.setParameter("nombre", nombre);
			medio =query.getResultList();
		}
		return medio;
	}
	
	//Evento
	@Override
	@SuppressWarnings("unchecked")
	public List<Evento> obtenerEvento() throws Exception {
		List<Evento> evento = new ArrayList<Evento>();
		Query query = em.createNamedQuery(Evento.TRAER_EVENTO);
		evento = query.getResultList();
		return evento;
	}

	@Override
	public void crearEvento(Evento evento) throws Exception {
		if (evento.getNombre() != null && !evento.getNombre().equals("")) {
			em.persist(evento);
		}

	}

	
	private Evento buscarPorId(int codigo) throws Exception {
		Evento p = new Evento();
		p = em.find(Evento.class, codigo);
		return p;
	}
	
	@Override
	public Evento editarEvento(Evento evento) throws Exception {
		Evento newEvento = new Evento();
		newEvento = buscarPorId(evento.getCodigo());
			if (newEvento.getCodigo()>0) {
				em.merge(evento);
			}else newEvento = null;
		
		return newEvento;		
	}

	@Override
	public boolean borrarEvento(int codigo) throws Exception {
		Evento evento = buscarPorId(codigo);
		boolean retorno = false;
		if (evento.getCodigo() > 0) {
			em.remove(evento);
			retorno = true;
		}

		return retorno;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Evento> buscarEventoPorNombre(String nombre) throws Exception {
		List<Evento> evento = new ArrayList<Evento>();
		Query query = em.createNamedQuery(Evento.ENCONTRAR_POR_NOMBRE);
		if (nombre != null) {
			query.setParameter("nombre", nombre);
			evento =query.getResultList();
		}
		return evento;
	}

}
