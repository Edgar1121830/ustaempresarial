package co.com.ustaempresarial.fachada;

import co.com.ustaempresarial.finanzas.modelo.LibroDiario;
import co.com.ustaempresarial.finanzas.modelo.LibroMayor;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface FinanzasFachada {

    /**
     * Metodo que lista las LibroDiarios de los productos
     *
     * @return List<LibroDiario> Lista de las LibroDiarios de producto
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    List<LibroDiario> listarLibroDiario() throws Exception;

    /**
     * Metodo que crea las LibroDiarios de producto
     *
     * @param LibroDiario
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    void crearLibroDiario(LibroDiario LibroDiario) throws Exception;

    /**
     * Metodo que actualiza la LibroDiario producto
     *
     * @param LibroDiario
     * @return Objeto LibroDiario
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    LibroDiario editarLibroDiario(LibroDiario LibroDiario) throws Exception;

    /**
     * Metodo que elimina la LibroDiario producto
     *
     * @param codigo
     * @return true: Si se borro y false si no se borra
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    boolean eliminarLibroDiario(int codigo) throws Exception;

    /**
     * Metodo que busca LibroDiario producto por nombre
     *
     * @param nombre de la categor�a
     * @return Objeto categor�a producto
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    LibroDiario listalibroDiarioByNombre(String nombre) throws Exception;

    /**
     * Metodo que busca LibroDiario producto por nombre
     *
     * @param nombre de la categor�a
     * @return Objeto categor�a producto
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    List<LibroDiario> listarLibroDiariosByNombre(String nombre) throws Exception;

    /**
     * Metodo que busca LibroDiario producto por id
     *
     * @param id de la categor�a
     * @return Objeto categor�a producto
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    LibroDiario listarLibroDiarioById(int id) throws Exception;

    /**
     * Metodo que lista los LibroMayors
     *
     * @return List<LibroMayor> Lista de los LibroMayors
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    List<LibroMayor> listarLibroMayor() throws Exception;

    /**
     * Metodo que crea los LibroMayors
     *
     * @param LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    void crearLibroMayor(LibroMayor LibroMayor) throws Exception;

    /**
     * Metodo que actualiza un LibroMayor
     *
     * @param LibroMayor
     * @return Objeto LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    LibroMayor editarLibroMayor(LibroMayor LibroMayor) throws Exception;

    /**
     * Metodo que elimina la LibroMayor
     *
     * @param codigo
     * @return true: Si se borro y false si no se borra
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    boolean eliminarLibroMayor(int codigo) throws Exception;

    /**
     * Metodo que busca LibroMayor por nombre
     *
     * @param nombre del LibroMayor
     * @return Objeto LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    LibroMayor listarLibroMayorByNombre(String nombre) throws Exception;

    /**
     * Metodo que busca LibroMayor por nombre
     *
     * @param nombre del LibroMayor
     * @return Objeto LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    List<LibroMayor> listarLibroMayorsByNombre(String nombre) throws Exception;

    /**
     * Metodo que busca LibroMayor por id
     *
     * @param id del LibroMayor
     * @return Objeto LibroMayor
     * @throws Exception Capturar errores posibles osbre ejecuci�n
     */
    LibroMayor listarLibroMayorById(int id) throws Exception;


}
