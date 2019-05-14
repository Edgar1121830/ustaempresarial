package co.com.ustaempresarial.bean;

import co.com.ustaempresarial.fachada.FinanzasFachada;
import co.com.ustaempresarial.finanzas.modelo.LibroDiario;
import co.com.ustaempresarial.finanzas.modelo.LibroMayor;

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
    private EntityManager em;

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
        if (LibroDiario.getAsiento() > 0) {
            em.remove(LibroDiario);
            retorno = true;
        }
        return retorno;
    }

    private LibroDiario buscarLibroDiarioById(int codigo) throws Exception {
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


    @Override
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


    @Override
    public boolean eliminarLibroMayor(int codigo) throws Exception {
        LibroMayor LibroMayor = buscarLibroMayorById(codigo);
        boolean retorno = false;
        if (LibroMayor.getId().getPeriodoCod() > 0) {
            em.remove(LibroMayor);
            retorno = true;
        }
        return retorno;
    }

    private LibroMayor buscarLibroMayorById(int codigo) throws Exception {
        LibroMayor p = new LibroMayor();
        p = em.find(LibroMayor.class, codigo);
        return p;
    }
    
}
        
