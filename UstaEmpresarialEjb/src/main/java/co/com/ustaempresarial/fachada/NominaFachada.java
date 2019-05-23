package co.com.ustaempresarial.fachada;

import co.com.UstaEmpresarial.nomina.modelo.*;

import javax.ejb.Remote;
import java.util.List;

import co.com.UstaEmpresarial.nomina.modelo.Nomina;
import co.com.UstaEmpresarial.nomina.modelo.Periodo;

@Remote
public interface NominaFachada {

    // ==================================================================================================================
    // -------------------------------------------------HOJA DE VIDA-----------------------------------------------------
    // ==================================================================================================================

    /**
     * Crea una nueva hoja de vida
     *
     * @param hojaVida Objeto hoja de vida
     * @return
     * @throws Exception
     */
    public HojaVida crearHojaVida(HojaVida hojaVida) throws Exception;

    /**
     * Modifica la información de una hoja de vida
     *
     * @param hojaVida Objeto hoja de vida
     * @return
     * @throws Exception
     */
    public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception;

	/**
	 * borrarNomina
	 * 
	 * @param codigo
	 * @return
	 * @throws Exception
	 */
	
	public boolean borrarNomina(int codigo) throws Exception;

	public boolean borrarPeriodo(int id) throws Exception;

	public void crearPeriodo(Periodo periodo) throws Exception;

	public List<Nomina> buscarPeriodoPorId(int id) throws Exception;

	/**
	 * buscarNominaPorNombre
	 * 
	 * @param nombre
	 * @return
	 * @throws Exception
	 */
	}
