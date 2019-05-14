package co.com.ustaempresarial.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import co.com.ustaempresarial.fachada.NominaFachada;
import co.com.UstaEmpresarial.nomina.modelo.Cargo;
import co.com.UstaEmpresarial.nomina.modelo.Nomina;
import co.com.UstaEmpresarial.nomina.modelo.Dependencia;
import co.com.UstaEmpresarial.nomina.modelo.HojaVida;
import co.com.UstaEmpresarial.nomina.modelo.Contrato;
import co.com.UstaEmpresarial.nomina.modelo.Concepto;
import co.com.UstaEmpresarial.nomina.modelo.Periodo;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)

public class NominaBean implements NominaFachada {

	@PersistenceContext(unitName = "nomina")
	private EntityManager em;

	public NominaBean() {

		super();
/**
 * @autor Oscar Gomez 
 */
	}
	@Override
	public HojaVida crearHojaVida(HojaVida hojaVida) throws Exception {
		if (hojaVida.getDocumento() != null && !hojaVida.getDocumento().equals("")) {
			em.persist(hojaVida);
		}
		return null;
	}

	@Override
	public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception {
		HojaVida hojaVida1 = new HojaVida();
		hojaVida1 = buscarPorIdHojaVida(hojaVida.getDocumento());
		if (hojaVida1.getDocumento() > 0) {
			em.merge(hojaVida);
		} else {
			hojaVida1 = null;
		}
		return hojaVida1;
	}

	@Override
	public boolean eliminarHojaVida(int codigoHojaVida) throws Exception {
		HojaVida hojaVida = buscarPorIdHojaVida(codigoHojaVida);
		boolean flag = false;
		if (hojaVida.getDocumento() > 0) {
			em.remove(hojaVida);
			flag = true;
		}
		return flag;
	}

	@Override
	public List<HojaVida> listarHojasVida() throws Exception {
		List<HojaVida> hojaVidas = new ArrayList<>();
		Query query = em.createNamedQuery(HojaVida.FILL_ALL);
		return null;
	}

	private HojaVida buscarPorIdHojaVida(int idHojaVida) throws Exception {
		HojaVida hojaVida = new HojaVida();
		hojaVida = em.find(HojaVida.class, idHojaVida);
		return hojaVida;
	}

	/**
	 * @autor Angie Suarez
	 */
	@Override
	public List<Cargo> listarCargos() throws Exception {

		List<Cargo> cargos;

		Query q = em.createNamedQuery(Cargo.LISTAR_CARGO);
		cargos = q.getResultList();

		return cargos;

	}

	@Override
	public void crearCargo(Cargo cargo) throws Exception {

		if (cargo != null) {
			em.persist(cargo);
			em.flush();
		}
	}

	// @Override
	public void editarCargo(Cargo cargos) throws Exception {
		if (cargos != null) {
			if (cargos.getCodigo() > 0) {
				em.merge(cargos);
				em.flush();
			}
		}
	}

	@Override
	public boolean eliminarCargo(Cargo cargos) throws Exception {
		if (cargos.getCodigo() > 0) {
			em.remove(cargos);
			return true;
		}
		return false;
	}
	/**
	 * @autor Christian Mejia
	 */
	@Override
	public List<Dependencia> traerDependencia() throws Exception {
		List<Dependencia> dependencias = new ArrayList<Dependencia>();
		Query query = em.createNamedQuery(Dependencia.FIND_ALL);
		dependencias = query.getResultList();
		return dependencias;
	}

	@Override
	public void crearDependencia(Dependencia dep) throws Exception {
		if (dep.getNombre() != null && !dep.getNombre().equals("")) {
			em.persist(dep);
		}
	}

	private Dependencia buscarPorCod(int codigoDependencia) throws Exception {
		Dependencia p = new Dependencia();
		p = em.find(Dependencia.class, codigoDependencia);
		return p;
	}

	@Override
	public void editarDependencia(Dependencia depen) throws Exception {
		Dependencia dep = new Dependencia();
		dep = buscarPorCod(depen.getCodigo());
		if (dep.getCodigo() > 0) {
			em.merge(depen);
		} else {
			dep = null;
		}

	}

	@Override
	public boolean borrarDependencia(int codigo) throws Exception {
		Dependencia dependencias = buscarPorCod(codigo);
		Contrato contrato = new Contrato();
		boolean flag = false;
		if (dependencias.getCodigo() > 0) {
			if (contrato.getDependenciaCod() == dependencias.getCodigo()) {
				em.remove(dependencias);
				flag = true;
			}
		}
		return flag;
	}
	/**
	 * @autor Mario Murcia
	 */
	public void crearContrato(Contrato contrato) throws Exception {

		if (contrato.getCodigo() != null && !contrato.getCodigo().equals("")) {
			em.persist(contrato);
		}
		// TODO Auto-generated method stub

	}

	public Contrato modificarContrato(Contrato contrato) throws Exception {
		Contrato dep = new Contrato();
		dep = buscarPorCodigo(contrato.getCodigo());
		if (dep.getCodigo() > 0) {
			em.merge(contrato);
		} else {
			dep = null;
		}

		return dep;
	}

	public boolean eliminarContrato(int codigo) throws Exception {
		Contrato contrato = buscarPorCodigo(codigo);
		boolean flag = false;
		if (contrato.getCodigo() > 0) {
			em.remove(contrato);
			flag = true;
		}
		return flag;
	}

    @Override
    public List<Contrato> listaContratoDependecia() throws Exception {
        return null;
    }

    @Override
    public List<Contrato> listaContratoCargo() throws Exception {
        return null;
    }

    @Override
	public List<Contrato> buscarContratoPorCargo(String cargo) throws Exception {
		List<Contrato> car = new ArrayList<Contrato>();
		Query query = em.createNamedQuery(Contrato.ENCONTRAR_POR_CARGO);
		if (query != null) {
			query.setParameter("cargo", cargo);
			car = query.getResultList();
		}
		return car;
	}
	@Override
	public List<Contrato> buscarContratoPorDependencia(String dependencia) throws Exception {
		List<Contrato> car = new ArrayList<Contrato>();
		Query query = em.createNamedQuery(Contrato.ENCONTRAR_POR_DEPENDENCIA);
		if (query != null) {
			query.setParameter("dependenciacod", dependencia);
			car = query.getResultList();
		}
		return car;
	}

	public List<Contrato> listaContratoAll() throws Exception {
		List<Contrato> dependencias = new ArrayList<>();
		Query query = em.createNamedQuery(Contrato.FIND_ALL);
		dependencias = query.getResultList();
		return dependencias;
	}

	private Contrato buscarPorCodigo(int codigoContrato) throws Exception {
		Contrato p = new Contrato();
		p = em.find(Contrato.class, codigoContrato);
		return p;
	}
	/**
	 * @autor Alejandro Parra
	 */
	public List<Concepto> traerConcepto() throws Exception {
		List<Concepto> conceptos = new ArrayList<Concepto>();
		Query query = em.createNamedQuery(Concepto.FIND_ALL);
		conceptos = query.getResultList();
		return conceptos;
	}

	@Override
	public void crearConcepto(Concepto con) throws Exception {
		if (con.getNombre() != null && !con.getNombre().equals("")) {
			em.persist(con);
		}
	}

	public Concepto editarConcepto(Concepto concep) throws Exception {
		Concepto con = new Concepto();
		con = buscarPorIdConcepto(concep.getCodigo());
		if (con.getCodigo() > 0) {
			em.merge(concep);
		} else {
			con = null;
		}

		return con;
	}

	@Override
	public boolean borrarConcepto(int codigo) throws Exception {
		Concepto conceptos = buscarPorIdConcepto(codigo);
		boolean flag = false;
		if (conceptos.getCodigo() > 0) {
			em.remove(conceptos);
			flag = true;
		}
		return flag;
	}

	private Concepto buscarPorIdConcepto(int codigoConcepto) throws Exception {
		Concepto c = new Concepto();
		c = em.find(Concepto.class, codigoConcepto);
		return c;
	}

	public List<Periodo> traerPeriodo() throws Exception {
		List<Periodo> periodos = new ArrayList<Periodo>();
		Query query = em.createNamedQuery(Periodo.FIND_ALL);
		periodos = query.getResultList();
		return periodos;
	}

	@Override
	public boolean crearPeriodo(Periodo per) throws Exception {
		if (per.getCodigo() != null && !per.getCodigo().equals("")) {
			em.persist(per);
			return true;
		}
		return false;
	}

	public boolean editarPeriodo(Periodo per) throws Exception {
		if (per != null) {
			if (per.getCodigo() > 0) {
				em.merge(per);
				em.flush();
				return true;
			}
		}
		return false;

	}

	public boolean borrarPeriodo(int codigo) throws Exception {
		Periodo periodos = buscarPorCodigoPeriodo(codigo);
		boolean flag = false;
		if (periodos.getCodigo() > 0) {
			em.remove(periodos);
			flag = true;
		}
		return flag;
	}

	private Periodo buscarPorCodigoPeriodo(int codigoPeriodo) throws Exception {
		Periodo p = new Periodo();
		p = em.find(Periodo.class, codigoPeriodo);
		return p;
	}
	/**
	 * @autor Johan Bernal
	 */
	@Override
	public void LiquidarNomina(Nomina nomina) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Nomina editarNomina(Nomina nomina) throws Exception {

		Nomina nomina1 = new Nomina();
		// nomina1 = buscarPorIdHojaVida(hojaVida.getDocumento());
		if (nomina1 != null) {
			em.merge(nomina);
		} else {
			nomina1 = null;
		}
		return nomina1;

	}

	public boolean conceptosLiquidadosNomina(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean conceptosPagadosNomina(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Nomina> obtenerNominas() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}