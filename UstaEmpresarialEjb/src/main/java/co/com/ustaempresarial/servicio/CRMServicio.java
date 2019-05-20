package co.com.ustaempresarial.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.ustaempresarial.modelo.crm.Campania;
import co.com.ustaempresarial.modelo.crm.Evento;
import co.com.ustaempresarial.modelo.crm.Medio;
import co.com.ustaempresarial.modelo.crm.Periodo;
import co.com.ustaempresarial.modelo.crm.Recurso;
import co.com.ustaempresarial.modelo.crm.TipoMedio;
import co.com.ustaempresarial.fachada.CRMFachada;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class CRMServicio {

	@EJB
	CRMFachada fachada;

	// Campaña
	public List<Campania> listarCampania() throws Exception {
		return fachada.listarCampania();
	}

	public void crearCampania(Campania campania) throws Exception {
		fachada.crearCampania(campania);
	}

	public Campania editarCampania(Campania campania) throws Exception {
		return fachada.editarCampania(campania);
	}

	public boolean eliminarCampania(int codigo) throws Exception {
		return fachada.eliminarCampania(codigo);
	}

	public List<Campania> buscarCampaniaPorNombre(String nombre) throws Exception {
		return fachada.buscarCampaniaPorNombre(nombre);
	}

	// Medio
	public List<Medio> listarMedio() throws Exception {
		return fachada.listarMedio();
	}

	public void crearMedio(Medio medio) throws Exception {
		fachada.crearMedio(medio);
	}

	public Medio editarMedio(Medio medio) throws Exception {
		return fachada.editarMedio(medio);
	}

	public boolean eliminarMedio(int codigo) throws Exception {
		return fachada.eliminarMedio(codigo);
	}

	public List<Medio> buscarMedioPorNombre(String nombre) throws Exception {
		return fachada.buscarMedioPorNombre(nombre);
	}

	// Evento
	public List<Evento> listarEvento() throws Exception {
		return fachada.listarEvento();
	}

	public void crearEvento(Evento evento) throws Exception {
		fachada.crearEvento(evento);
	}

	public Evento editarEvento(Evento evento) throws Exception {
		return fachada.editarEvento(evento);
	}

	public boolean eliminarEvento(int codigo) throws Exception {
		return fachada.eliminarEvento(codigo);
	}

	public List<Evento> buscarEventoPorNombre(String nombre) throws Exception {
		return fachada.buscarEventoPorNombre(nombre);
	}

	// Periodo
	public List<Periodo> listarPeriodo() throws Exception {
		return fachada.listarPeriodo();
	}

	public void crearPeriodo(Periodo per) throws Exception {
		fachada.crearPeriodo(per);
	}

	public Periodo editarPeriodo(Periodo per) throws Exception {
		return fachada.editarPeriodo(per);
	}

	public boolean eliminarRegistros(int codigo) throws Exception {
		return fachada.eliminarRegistros(codigo);
	}

	// Tipo medio
	public List<TipoMedio> listarTipoMedio() throws Exception {
		return fachada.listarTipoMedio();
	}

	public void crearTipoMedio(TipoMedio name) throws Exception {
		fachada.crearTipoMedio(name);
	}

	public TipoMedio editarTipoMedio(TipoMedio name) throws Exception {
		return fachada.editarTipoMedio(name);
	}

	public boolean eliminarTipoMedio(int codigo) throws Exception {
		return fachada.eliminarTipoMedio(codigo);
	}

	public TipoMedio listarTipoMedioPorNombre(String nombre) throws Exception {
		return fachada.listarTipoMedioPorNombre(nombre);
	}

	// Recurso
	public List<Recurso> listarRecursos() throws Exception {
		return fachada.listarRecursos();
	}

	public void crearRecurso(Recurso puc) throws Exception {
		fachada.crearRecurso(puc);
	}

	public Recurso editarRecurso(Recurso puc) throws Exception {
		return fachada.editarRecurso(puc);
	}

	public boolean eliminarRecurso(int codigo) throws Exception {
		return fachada.eliminarRecurso(codigo);
	}

	public Recurso listarRecursoNombre(String nombre) throws Exception {
		return fachada.listarRecursoNombre(nombre);
	}

}
