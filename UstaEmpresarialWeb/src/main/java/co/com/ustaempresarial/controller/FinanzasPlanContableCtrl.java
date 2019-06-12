package co.com.ustaempresarial.controller;

import co.com.ustaempresarial.finanzas.modelo.PlanContable;
import co.com.ustaempresarial.servicio.FinanzasServicio;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@ManagedBean(name = "planContableFinananzas")
@SessionScoped
//@ViewScoped
public class FinanzasPlanContableCtrl implements Serializable {

    private static final long serialVersionUID = 1L;
    private Properties properties;
    private List<PlanContable> planContables;
    private int buscarCodPlanContable;
    private PlanContable planContable;

    @EJB
    private FinanzasServicio servicio;

    public FinanzasPlanContableCtrl() throws Exception {
        super();
        properties = new Properties();
        properties.load(LoginControl.class.getResourceAsStream("mensajes.properties"));
    }

    @PostConstruct
    public void cargarPlanContablePage() {
        try {
            planContable = new PlanContable();
            planContables = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarDatos() throws Exception {
        try{
            planContables = servicio.listarPlanContable();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void limpiarDatos() throws Exception {
        planContable  = new PlanContable();
        cargarDatos();
    }

    public void crearPlanContable() {
        try {
            if (this.planContable.getCodigo() != null && this.planContable.getCodigoPadre() != null && this.planContable.getDescripcion() != null && this.planContable.getNombre() != null && this.planContable.getTipo() != null && this.planContable.getVigencia() != null) {
                if (servicio.crearPlanContable(this.planContable)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", properties.getProperty("exitoGuardado")));
                }
                planContables = servicio.listarPlanContable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<PlanContable> getPlanContables() {
        return planContables;
    }


    public PlanContable getPlanContable() {
        return planContable;
    }

    public void setPlanContable(PlanContable planContable) {
        this.planContable = planContable;
    }
}
