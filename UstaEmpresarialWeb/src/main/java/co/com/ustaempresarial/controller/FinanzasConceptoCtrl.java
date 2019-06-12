package co.com.ustaempresarial.controller;

import co.com.ustaempresarial.finanzas.modelo.PlanContable;
import co.com.ustaempresarial.servicio.FinanzasServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
//@ViewScoped
public class FinanzasConceptoCtrl implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private Integer codigoPadre;
    private String descripcion;
    private String nombre;
    private Integer tipo;
    private List<PlanContable> planContables;
    private int buscarCodPlanContable;

    @Temporal(TemporalType.DATE)
    private Date vigencia;

    @EJB
//    @ManagedProperty("#{finanzasService}")
    private FinanzasServicio servicio;

    public void crearPlanContable() {
        try {
            PlanContable planContable = new PlanContable();
            planContable.setCodigo(codigo);
            planContable.setCodigoPadre(codigoPadre);
            planContable.setDescripcion(descripcion);
            planContable.setNombre(nombre);
            planContable.setTipo(tipo);
            planContable.setVigencia(vigencia);
            servicio.crearPlanContable(planContable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarPlanContable() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarPlanContable() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void cargarPlanContablePage() throws Exception {
        planContables = servicio.listarPlanContable();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigoPadre() {
        return codigoPadre;
    }

    public void setCodigoPadre(Integer codigoPadre) {
        this.codigoPadre = codigoPadre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(vigencia);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.vigencia = fecha;
    }

    public List<PlanContable> getPlanContables() {
        return planContables;
    }

    public void setService(FinanzasServicio servicio) {
        this.servicio = servicio;
    }

    public int getBuscarCodPlanContable() {
        return buscarCodPlanContable;
    }

    public void setBuscarCodPlanContable(int buscarCodPlanContable) {
        this.buscarCodPlanContable = buscarCodPlanContable;
    }

    public PlanContable buscarPlanContable() throws Exception {
        PlanContable planContable = servicio.buscarPlanContable(this.buscarCodPlanContable);
        //como hacer para llenar los inputs con los datos que trae la consulta. ¿Seria limpiar las variables actuales?
        return planContable;
    }
}
