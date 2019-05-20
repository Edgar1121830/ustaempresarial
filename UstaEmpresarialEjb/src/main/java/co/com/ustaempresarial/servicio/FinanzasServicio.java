package co.com.ustaempresarial.servicio;

import co.com.ustaempresarial.fachada.FinanzasFachada;
import co.com.ustaempresarial.finanzas.modelo.LibroDiario;
import co.com.ustaempresarial.finanzas.modelo.LibroMayor;

import javax.ejb.*;
import java.util.List;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class FinanzasServicio {

    FinanzasFachada fachada;

    public List<LibroDiario> listarLibroDiario() throws Exception{
        return fachada.listarLibroDiario();
    }

    public void crearLibroDiarior(LibroDiario LibroDiario) throws Exception{
        fachada.crearLibroDiario(LibroDiario);
    }

    public LibroDiario editarLibroDiario(LibroDiario LibroDiario) throws Exception{
        return fachada.editarLibroDiario(LibroDiario);
    }

    public boolean eliminarLibroDiario(int cod) throws Exception{
        return fachada.eliminarLibroDiario(cod);
    }

    public LibroDiario listarLibroDiarioById(int cod) throws Exception{
        return fachada.listarLibroDiarioById(cod);
    }

    public List<LibroDiario> listarLibroDiariosByNombre(String nombre) throws Exception{
        return fachada.listarLibroDiariosByNombre(nombre);
    }

    public List<LibroMayor> listarLibroMayor() throws Exception{
        return fachada.listarLibroMayor();
    }

    public void crearLibroMayorr(LibroMayor LibroMayor) throws Exception{
        fachada.crearLibroMayor(LibroMayor);
    }

    public LibroMayor editarLibroMayor(LibroMayor LibroMayor) throws Exception{
        return fachada.editarLibroMayor(LibroMayor);
    }

    public boolean eliminarLibroMayor(int cod) throws Exception{
        return fachada.eliminarLibroMayor(cod);
    }

    public LibroMayor listarLibroMayorById(int cod) throws Exception{
        return fachada.listarLibroMayorById(cod);
    }

    public List<LibroMayor> listarLibroMayorsByNombre(String nombre) throws Exception{
        return fachada.listarLibroMayorsByNombre(nombre);
    }

}