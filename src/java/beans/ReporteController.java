package beans;

import beans.util.JsfUtil;
import beans.util.JsfUtil.PersistAction;
import java.io.InputStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

@Named("reporteController")
@SessionScoped
public class ReporteController implements Serializable {

    @EJB
    private UsuariosFacade usuariosFacade;
    @EJB
    private beans.ReporteFacade ejbFacade;
    @EJB
    private beans.ComputadoraFacade compuFacade;
    @EJB
    private beans.DireccionFacade direccionFacade;

    public ComputadoraFacade getCompuFacade() {
        return compuFacade;
    }

    public void setCompuFacade(ComputadoraFacade compuFacade) {
        this.compuFacade = compuFacade;
    }

    private List<Reporte> items = null;
    private List<Reporte> itemsNoatendido = new ArrayList<>();
    private List<Reporte> itemsSolucion = new ArrayList<>();
    private List<Reporte> itemsAtendido = new ArrayList<>();
    private List<Reporte> itemsAplazado = new ArrayList<>();
    private List<Reporte> itemsConformidad = new ArrayList<>();
    private List<Reporte> itemsConfor = new ArrayList<>();
    private List<Reporte> itemsNoConforme = new ArrayList<>();
    private List<Reporte> reportEspecialista = new ArrayList<>();
    private List<Computadora> computadoras = new ArrayList<>();

    private Reporte selected;
    private BarChartModel model;
    private BarChartModel model1;
    private BubbleChartModel bubble;
    private int idLink;
    private List<Direccion> listdir = new ArrayList<>();
    private List<Direccion> listadirecciones = new ArrayList<>();

    public List<Direccion> getListdir() {
        return listdir;
    }

    public void setListdir(List<Direccion> listdir) {
        this.listdir = listdir;
    }

    public List<Direccion> getListadirecciones() {
        return listadirecciones;
    }

    public void setListadirecciones(List<Direccion> listadirecciones) {
        this.listadirecciones = listadirecciones;
    }

    public DireccionFacade getDireccion() {
        return direccionFacade;
    }

    public void setDireccion(DireccionFacade direccion) {
        this.direccionFacade = direccion;
    }

    public void valor() {
        getListdir().clear();
        setListdir(direccionFacade.listado(selected.getLugar().getNombre()));
    }

    public List<Reporte> getItemsNoConforme() {
        return itemsNoConforme;
    }

    public void setItemsNoConforme(List<Reporte> itemsNoConforme) {
        this.itemsNoConforme = itemsNoConforme;
    }

    public List<Reporte> getItemsConfor() {
        return itemsConfor;
    }

    public void setItemsConfor(List<Reporte> itemsConfor) {
        this.itemsConfor = itemsConfor;
    }

    public List<Computadora> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<Computadora> computadoras) {
        this.computadoras = computadoras;
    }

    public int getIdLink() {
        return idLink;
    }

    public void setIdLink(int idLink) {
        this.idLink = idLink;
    }

    public void setItemsConformidad(List<Reporte> itemsConformidad) {
        this.itemsConformidad = itemsConformidad;

    }

    public BarChartModel getModel1() {
        return graf_pie_reportes_conformidad();
    }

    public void setModel1(BarChartModel model1) {
        this.model1 = model1;
    }

    private BarChartModel reporte;

    public BubbleChartModel getBubble() {

        return bubble;
    }

    public void setBubble(BubbleChartModel bubble) {
        this.bubble = bubble;
    }

    public BarChartModel getReporte() {
        // reportes_especialistas();
        return reporte;
    }

    public void setReporte(BarChartModel reporte) {
        this.reporte = reporte;
    }

    public List<Reporte> getReportEspecialista() {

        return reportEspecialista;
    }

    public void setReportEspecialista(List<Reporte> reportEspecialista) {
        this.reportEspecialista = reportEspecialista;
    }

    private PieChartModel pieModel2;
    private StreamedContent image;

    public BarChartModel getModel() {
        return graf_pie_reportes();
    }

    public void setModel(BarChartModel model) {
        this.model = model;
    }

    private HttpServletRequest httpServletRequest;
    private FacesContext facesContext;

    public ReporteController() {

    }

    public List<Reporte> getItemsNoatendido() {
        return itemsNoatendido;
    }

    public void setItemsNoatendido(List<Reporte> itemsNoatendido) {
        this.itemsNoatendido = itemsNoatendido;
    }

    public List<Reporte> getItemsAtendido() {
        return itemsAtendido;
    }

    public void setItemsAtendido(List<Reporte> itemsAtendido) {
        this.itemsAtendido = itemsAtendido;
    }

    public List<Reporte> getItemsSolucion() {
        return itemsSolucion;
    }

    public void setItemsSolucion(List<Reporte> itemsSolucion) {
        this.itemsSolucion = itemsSolucion;
    }

    public List<Reporte> getItemsAplazado() {
        return itemsAplazado;
    }

    public void setItemsAplazado(List<Reporte> itemsAplazado) {
        this.itemsAplazado = itemsAplazado;
    }

    public Reporte getSelected() {
        return selected;
    }

    public void setSelected(Reporte selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ReporteFacade getFacade() {
        return ejbFacade;
    }

    public Reporte prepareCreate() {
        selected = new Reporte();
        initializeEmbeddableKey();
        return selected;
    }

    public void cerrarReporteConforme() {

        selected.setConformidad("Conforme");
        persist(PersistAction.UPDATE, "Elección enviada satisfactoriamente");

    }

    public void cerrarReporteNoConforme() {
        selected.setConformidad("No Conforme");
        persist(PersistAction.UPDATE, "Elección enviada satisfactoriamente");
    }

    public List<Computadora> crearComputadoras() {
        getComputadoras().clear();
        setComputadoras(compuFacade.ListaComputadorasDir(selected.getArea()));
        return getComputadoras();
    }

    public void create() {
        if (selected.getLugar() == null || selected.getArea() == null || selected.getEquipo() == null) {
            JsfUtil.addErrorMessage("No estan todos los campos llenos, cree el reporte  nuevamente");
        } else {

            facesContext = getCurrentInstance();
            httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();

            Date d = new Date();
            selected.setConformidad("Conforme");
            selected.setFechaCreado(d.toLocaleString());
            selected.setEstadoReporte("No atendido");
            selected.setCorreo((String) httpServletRequest.getSession().getAttribute("correoOp"));
            System.out.println(selected.getArea());
           // selected.setArea(selected.getArea());
            if (null == (String) httpServletRequest.getSession().getAttribute("Operario")) {

                selected.setUsuario((String) httpServletRequest.getSession().getAttribute("Especialista"));
            } else {

                selected.setUsuario((String) httpServletRequest.getSession().getAttribute("Operario"));
            }
            mail mail = new mail();
            String usuario = "";
            System.err.println(usuariosFacade.count());
            for (int i = 0; i < usuariosFacade.count() - 1; i++) {
                usuario += usuariosFacade.findAll().get(i).getUsuario() + "@aica.cu,";
            }
            usuario += usuariosFacade.findAll().get(usuariosFacade.count() - 1).getUsuario() + "@aica.cu";
          mail.SendMail(usuario, "Existe una incidencia. Revise el reporte de incidencia para solucionarlo, la interrupción es: " + selected.getObservacion() + " y esta reportado por el usuario: " + selected.getUsuario() + "   http://glassfish.intranet.aica.cu:8080/report/");
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ReporteCreated"));
            if (!JsfUtil.isValidationFailed()) {
                items = null;    // Invalidate list of items to trigger re-query.
            }
        }
    }

    public void DynamicImageController() {
        InputStream stream = this.getClass().getResourceAsStream("barcalogo.jpg");
        image = new DefaultStreamedContent(stream, "resources/img/logo");
    }

    public StreamedContent getImage() {
        DynamicImageController();
        return this.image;
    }

    public void setImage(StreamedContent image) {
        this.image = image;
    }

    public BarChartModel graf_pie_reportes() {

        model = new BarChartModel();

        ChartSeries atendidos = new BarChartSeries();

        ChartSeries noatendidos = new BarChartSeries();
        ChartSeries aplazados = new BarChartSeries();
        noatendidos.setLabel("No atendidos");
        noatendidos.set("", getItemsNoAtendidos().size());
        atendidos.setLabel("No atendidos");
        atendidos.setLabel("Atendidos");
        atendidos.set("Estado", getItemsAtendidos().size());
        aplazados.setLabel("Aplazados");
        aplazados.set("", getItemsAplazados().size());
        model.setTitle("Reportes");
        model.setLegendPosition("ne");
        model.addSeries(aplazados);
        model.addSeries(atendidos);
        model.addSeries(noatendidos);
        model.setShowDatatip(true);
        model.setDatatipFormat("%2$d");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax(400);

        return model;
    }

    public BarChartModel graf_pie_reportes_conformidad() {

        model1 = new BarChartModel();

        ChartSeries conforme = new BarChartSeries();
        ChartSeries noconforme = new BarChartSeries();
        conforme.setLabel("Conforme");
        conforme.set("", getItemsConforme().size());
        noconforme.setLabel("No Conforme");
        noconforme.set("", getItemsNoConform().size());
        model1.setTitle("Conformidad");
        model1.setLegendPosition("ne");
        model1.addSeries(conforme);
        model1.addSeries(noconforme);

        model1.setShowDatatip(true);
        Axis yAxis = model1.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin(0);
        yAxis.setMax((int) getItemsConforme().size() + 10);
        Axis xAxis = model1.getAxis(AxisType.X);
        xAxis.setLabel("");
        model1.setShowPointLabels(false);
        model1.setDatatipFormat("%2$d");

        return model1;
    }
    private BubbleChartModel bubbleModel1;
    private BubbleChartModel bubbleModel2;

    @PostConstruct
    public void init() {
        createBubbleModels();
    }

    public BubbleChartModel getBubbleModel1() {
        return bubbleModel1;
    }

    public BubbleChartModel getBubbleModel2() {
        return bubbleModel2;
    }

    private void createBubbleModels() {
        bubbleModel1 = initBubbleModel();
        bubbleModel1.setTitle("Bubble Chart");
        bubbleModel1.getAxis(AxisType.X).setLabel("Especialistas");
        Axis yAxis = bubbleModel1.getAxis(AxisType.Y);
        bubbleModel1.setBubbleAlpha(0.8);
        yAxis.setMin(0);
        yAxis.setMax(getItemsAtendidos().size() + 2);
        yAxis.setLabel("Cantidad reportes");
        bubbleModel2 = initBubbleModel();
        bubbleModel2.setTitle("Custom Options");
        bubbleModel2.setShadow(false);
        bubbleModel2.setBubbleGradients(true);
        bubbleModel2.setBubbleAlpha(0.8);
        bubbleModel2.getAxis(AxisType.X).setTickAngle(-50);
        yAxis = bubbleModel2.getAxis(AxisType.Y);
        yAxis.setMin(-getItemsAplazados().size());
        yAxis.setMax(getItemsAplazados().size());
        yAxis.setTickAngle(50);
    }

    private BubbleChartModel initBubbleModel() {
        BubbleChartModel modelo = new BubbleChartModel();

        int i = 0;
        for (Usuarios findAll : usuariosFacade.findAll()) {
            BubbleChartSeries especialista = new BubbleChartSeries();
            especialista.setLabel(findAll.getUsuario());
            especialista.setY(getReportesEspecialistas(findAll.getNombre() + " " + findAll.getApellidos()).size());
            especialista.setRadius(12);
            especialista.setX(i);
            i++;
            modelo.add(especialista);
        }

        return modelo;
    }

    public List<Reporte> report(String num) {
        return ejbFacade.ListaReporte(num);

    }

    public BarChartModel reportes_especialistas() {
        reporte = new BarChartModel();
        Axis yAxis = reporte.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(getItemsAtendidos().size() + 10);
        yAxis.setLabel("Cantidad reportes");

        for (Usuarios findAll : usuariosFacade.findAll()) {
            ChartSeries especialist = new BarChartSeries();
            especialist.setLabel(findAll.getUsuario());
            especialist.set("", getReportesEspecialistas(findAll.getNombre() + " " + findAll.getApellidos()).size());
            reporte.setTitle("Bar Chart");
            reporte.setLegendPosition("ne");
            reporte.addSeries(especialist);
            reporte.setShowDatatip(true);
            reporte.setDatatipFormat("%2$d");
            yAxis = bubbleModel2.getAxis(AxisType.Y);
            yAxis.setMin(-getItemsAplazados().size());
            yAxis.setMax(getItemsAplazados().size());
            yAxis.setTickAngle(50);
        }

        return reporte;
    }

    public PieChartModel pieModel() {
        pieModel2 = new PieChartModel();
        pieModel2.set("Aplazados", getItemsAplazados().size());
        pieModel2.set("Atendidos", getItemsAtendidos().size());
        pieModel2.set("No atendidos", getItemsNoAtendidos().size());
        pieModel2.setLegendPosition("w");
        pieModel2.setTitle("Porciento Reportes");
        pieModel2.setLegendPosition("ne");
        pieModel2.setDatatipFormat("%2$d");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
        return pieModel2;
    }

    public String valores() {

        for (int i = 0; i < ejbFacade.findAll().size(); i++) {
            System.out.println(ejbFacade.ListaPC(ejbFacade.findAll().get(i).getEquipo()).get(0).getId() + "," + ejbFacade.ListaPC(ejbFacade.findAll().get(i).getEquipo()).get(0).getNombrePc());
            ejbFacade.findAll().get(i).setComputadoraid(ejbFacade.ListaPC(ejbFacade.findAll().get(i).getEquipo()).get(0));
            ejbFacade.edit(ejbFacade.findAll().get(i));
            //    ejbFacade.update(ejbFacade.ListaPC(ejbFacade.findAll().get(i).getEquipo()).get(0).getNombrePc(), ejbFacade.ListaPC(ejbFacade.findAll().get(i).getEquipo()).get(0).getId());
        }
        return "List_admin";
    }

    public void update_aplazado() {
        facesContext = getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        String usuario = "";

        for (Usuarios findAll : usuariosFacade.findAll()) {
            if (findAll.getUsuario().equals(selected.getEspecialista())) {
                usuario = findAll.getNombre() + " " + findAll.getApellidos();
            }
        }
        selected.setEspecialista(usuario);
        mail mail = new mail();
        mail.SendMail(selected.getCorreo(), "La solución al reporte fue ejecutada por el especialista: " + selected.getEspecialista() + ", por favor entre al sitio http://192.168.101.3:8080/reportesAICA/ para confirmar la solución del reporte.");
        Date d = new Date();
        selected.setFechaSolucion(d.toLocaleString());
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ReporteAplazado"));
    }

    public void update() {
        facesContext = getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();

        String usuario = "";

        for (Usuarios findAll : usuariosFacade.findAll()) {
            if (findAll.getUsuario().equals(selected.getEspecialista())) {
                usuario = findAll.getNombre() + " " + findAll.getApellidos();
            }
        }
        selected.setEspecialista(usuario);

        if (!selected.getEstadoReporte().equals("Aplazado")) {
            mail mail = new mail();
            mail.SendMail(selected.getCorreo(), "La solución al reporte fue ejecutada por el especialista: " + selected.getEspecialista() + ", por favor entre al sitio http://glassfish.intranet.aica.cu:8080/report/faces/reporte/List_conformidad.xhtml?id=" + selected.getId() + "  para confirmar la solución del reporte.");
        }
        Date d = new Date();
        selected.setFechaSolucion(d.toLocaleString());
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ReporteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ReporteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Reporte> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public List<Reporte> getItemsNoAtendidos() {
        itemsNoatendido.clear();
        /* for (int i = 0; i < getItems().size(); i++) {
            
            if (getItems().get(i).getEstadoReporte().equals("No atendido")) {
                itemsNoatendido.add(getItems().get(i));
            }
        }*/

        return ejbFacade.listadoReporte("No atendido");
    }

    public List<Reporte> getItemsSoluciones() {
        itemsSolucion.clear();
        facesContext = getCurrentInstance();
        httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getFechaSolucion() != null && getItems().get(i).getEstadoReporte().equals("Atendido") && getItems().get(i).getUsuario().equals((String) httpServletRequest.getSession().getAttribute("Operario"))) {
                itemsSolucion.add(getItems().get(i));
            }
        }
        return itemsSolucion;
    }

    public List<Reporte> getItemsConformidad() {
        itemsConformidad.clear();
        for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getConformidad() == null && Objects.equals(getIdLink(), getFacade().findAll().get(i).getId())) {
                itemsConformidad.add(getItems().get(i));
            }
        }
        return itemsConformidad;
    }

    public List<Reporte> getItemsAtendidos() {
        itemsAtendido.clear();

        return ejbFacade.listadoReporte("Atendido");
    }

    public List<Reporte> getReportesEspecialistas(String especialista) {
        reportEspecialista.clear();
        for (int i = 0; i < getItemsAtendidos().size(); i++) {
            if (getItemsAtendidos().get(i).getEspecialista().equals(especialista)) {
                reportEspecialista.add(getItemsAtendidos().get(i));
            }
        }
        return reportEspecialista;
    }

    public List<Reporte> getItemsAplazados() {
        itemsAplazado.clear();

        return ejbFacade.listadoReporte("Aplazado");
    }

    public List<Reporte> getItemsConforme() {
        itemsConfor.clear();
        itemsConfor = ejbFacade.conforme("Conforme");
        /*  for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getEstadoReporte().equals("Aplazado")) {
                itemsAplazado.add(getItems().get(i));
            }
        }*/
        return itemsConfor;
    }

    public List<Reporte> getItemsNoConform() {
        itemsNoConforme.clear();
        itemsNoConforme = ejbFacade.conforme("No Conforme");
        /*  for (int i = 0; i < getItems().size(); i++) {
            if (getItems().get(i).getEstadoReporte().equals("Aplazado")) {
                itemsAplazado.add(getItems().get(i));
            }
        }*/
        return itemsNoConforme;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    private void persist1(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Reporte getReporte(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Reporte> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Reporte> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    /**
     * @return the pieModel2
     */
    public PieChartModel getPieModel2() {
       pieModel2= pieModel();
        return pieModel2;
    }

    /**
     * @param pieModel2 the pieModel2 to set
     */
    public void setPieModel2(PieChartModel pieModel2) {
        this.pieModel2 = pieModel2;
    }

    @FacesConverter(forClass = Reporte.class)
    public static class ReporteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ReporteController controller = (ReporteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "reporteController");
            return controller.getReporte(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Reporte) {
                Reporte o = (Reporte) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Reporte.class.getName()});
                return null;
            }
        }

    }

}
