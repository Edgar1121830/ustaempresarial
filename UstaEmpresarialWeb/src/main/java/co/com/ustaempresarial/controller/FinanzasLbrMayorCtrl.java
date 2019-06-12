package co.com.ustaempresarial.controller;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.com.ustaempresarial.finanzas.modelo.LibroMayor;
import co.com.ustaempresarial.finanzas.modelo.LibroMayorPK;
import co.com.ustaempresarial.servicio.FinanzasServicio;

@ManagedBean(name = "libroMayorFinanzas")
@SessionScoped
//@ViewScoped
public class FinanzasLbrMayorCtrl implements Serializable {

    private List<LibroMayor> libroMayores;
    private LibroMayor libroMayor;
    private LibroMayorPK id;
    private BigDecimal debe;
    private Boolean estado;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private BigDecimal haber;
    private Properties properties;

    @EJB
    private FinanzasServicio servicio;

    public FinanzasLbrMayorCtrl() throws IOException {
        super();
        libroMayor = new LibroMayor();
        libroMayores = new ArrayList<LibroMayor>();
        properties = new Properties();
        properties.load(LoginControl.class.getResourceAsStream("mensajes.properties"));

    }

    @PostConstruct
    public void cargarLbrMayorPage() {
        try {
            libroMayores = servicio.listarLibroMayor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void crearLibroMayor() {
        try {

//    periodoContable.setCodigo(codigo);
//    periodoContable.setEstado(estado);
//    periodoContable.setFechaInicio(fechaInicio);
//    periodoContable.setFechaFin(fechaFin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificarLibroMayor() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarLibroMayor() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<LibroMayor> getLibroMayores() {
        return libroMayores;
    }

    public void setLibroMayores(List<LibroMayor> libroMayores) {
        this.libroMayores = libroMayores;
    }

    public LibroMayor getLibroMayor() {
        return libroMayor;
    }

    public void setLibroMayor(LibroMayor libroMayor) {
        this.libroMayor = libroMayor;
    }

    public LibroMayorPK getId() {
        return id;
    }

    public void setId(LibroMayorPK id) {
        this.id = id;
    }

    public BigDecimal getDebe() {
        return debe;
    }

    public void setDebe(BigDecimal debe) {
        this.debe = debe;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getHaber() {
        return haber;
    }

    public void setHaber(BigDecimal haber) {
        this.haber = haber;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public FinanzasServicio getServicio() {
        return servicio;
    }

    public void setServicio(FinanzasServicio servicio) {
        this.servicio = servicio;
    }
}