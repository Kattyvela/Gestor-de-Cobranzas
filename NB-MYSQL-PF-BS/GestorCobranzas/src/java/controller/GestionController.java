package controller;

import model.Gestion;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("gestionController")
@SessionScoped
public class GestionController implements Serializable {

    @EJB
    private controller.GestionFacade ejbFacade;
    private List<Gestion> items = null;
    private Gestion selected;

    public GestionController() {
    }

    public Gestion getSelected() {
        return selected;
    }

    public void setSelected(Gestion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getGestionPK().setMoraidMora(selected.getMora().getMoraPK().getIdMora());
        selected.getGestionPK().setResultadoidResultado(selected.getResultado().getIdResultado());
    }

    protected void initializeEmbeddableKey() {
        selected.setGestionPK(new model.GestionPK());
    }

    private GestionFacade getFacade() {
        return ejbFacade;
    }

    public Gestion prepareCreate() {
        selected = new Gestion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("GestionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("GestionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("GestionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Gestion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
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

    public Gestion getGestion(model.GestionPK id) {
        return getFacade().find(id);
    }

    public List<Gestion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Gestion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Gestion.class)
    public static class GestionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GestionController controller = (GestionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "gestionController");
            return controller.getGestion(getKey(value));
        }

        model.GestionPK getKey(String value) {
            model.GestionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new model.GestionPK();
            key.setIdGestion(Integer.parseInt(values[0]));
            key.setMoraidMora(Integer.parseInt(values[1]));
            key.setResultadoidResultado(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(model.GestionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdGestion());
            sb.append(SEPARATOR);
            sb.append(value.getMoraidMora());
            sb.append(SEPARATOR);
            sb.append(value.getResultadoidResultado());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Gestion) {
                Gestion o = (Gestion) object;
                return getStringKey(o.getGestionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Gestion.class.getName()});
                return null;
            }
        }

    }

}
