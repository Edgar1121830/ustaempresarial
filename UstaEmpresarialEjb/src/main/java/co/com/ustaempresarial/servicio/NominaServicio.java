package co.com.ustaempresarial.servicio;

import co.com.UstaEmpresarial.nomina.modelo.*;
import co.com.ustaempresarial.fachada.NominaFachada;

import javax.ejb.EJB;
import java.util.List;

public class NominaServicio {
    @EJB
    NominaFachada nominaFachada;

    //==================================================================================================================
    //-------------------------------------------------HOJA DE VIDA-----------------------------------------------------
    //==================================================================================================================
    public HojaVida crearHojaVida(HojaVida hojaVida) throws Exception {
        return nominaFachada.crearHojaVida(hojaVida);
    }

    public HojaVida modificarHojaVida(HojaVida hojaVida) throws Exception {
        return nominaFachada.modificarHojaVida(hojaVida);
    }

    public boolean eliminarHojaVida(int codigoHojaVida) throws Exception {
        return nominaFachada.eliminarHojaVida(codigoHojaVida);
    }

    public List<HojaVida> listarHojasVida() throws Exception {
        return nominaFachada.listarHojasVida();
    }
    //==================================================================================================================
    //-------------------------------------------------CARGOS-----------------------------------------------------
    //==================================================================================================================
    public List<Cargo> listarCargos() throws Exception {
        return nominaFachada.listarCargos();
    }

    public void crearCargo(Cargo cargo) throws Exception {
        nominaFachada.crearCargo(cargo);
    }

    public void editarCargo(Cargo cargo) throws Exception {
        nominaFachada.editarCargo(cargo);
    }

    public boolean eliminarCargo(Cargo cargo) throws Exception {
        return nominaFachada.eliminarCargo(cargo);
    }

    //==================================================================================================================
    //-------------------------------------------------DEPENDENCIA-----------------------------------------------------
    //==================================================================================================================
    public List<Dependencia> traerDependencia() throws Exception {
        return nominaFachada.traerDependencia();
    }

    public void crearDependencia(Dependencia depen) throws Exception {
        nominaFachada.crearDependencia(depen);
    }

    public void editarDependencia(Dependencia depen) throws Exception {
        nominaFachada.editarDependencia(depen);
    }

    public boolean borrarDependencia(int codigo) throws Exception {
        return nominaFachada.borrarDependencia(codigo);
    }
    //==================================================================================================================
    //-------------------------------------------------CONTRATO-----------------------------------------------------
    //==================================================================================================================
    public Contrato modificarContrato(Contrato contrato) throws Exception {
        return nominaFachada.modificarContrato(contrato);
    }

    public boolean eliminarContrato(int codigo) throws Exception {
        return nominaFachada.eliminarContrato(codigo);
    }

    public List<Contrato> listaContratoDependecia() throws Exception {
        return nominaFachada.listaContratoDependecia();
    }

    public List<Contrato> listaContratoCargo() throws Exception {
        return nominaFachada.listaContratoCargo();
    }

    public List<Contrato> listaContratoAll() throws Exception {
        return nominaFachada.listaContratoAll();
    }

    public Concepto editarConcepto(Concepto concep) throws Exception {
        return nominaFachada.editarConcepto(concep);

    }
    //==================================================================================================================
    //-------------------------------------------------CONCEPTO-----------------------------------------------------
    //==================================================================================================================
    public boolean borrarConcepto(int codigo) throws Exception {
        return nominaFachada.borrarConcepto(codigo);
    }

    public List<Concepto> traerConcepto() throws Exception {
        return nominaFachada.traerConcepto();
    }
    //==================================================================================================================
    //-------------------------------------------------PERIODO-----------------------------------------------------
    //==================================================================================================================
    public boolean editarPeriodo(Periodo per) throws Exception {
        return nominaFachada.editarPeriodo(per);
    }

    public boolean eliminarPeriodo(int codigo) throws Exception {
        return nominaFachada.borrarPeriodo(codigo);
    }

    public List<Periodo> listaPeriodo() throws Exception {
        return nominaFachada.traerPeriodo();
    }

}
