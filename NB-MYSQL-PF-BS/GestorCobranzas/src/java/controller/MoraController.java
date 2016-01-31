package controller;

import model.Mora;
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

@Named("moraController")
@SessionScoped
public class MoraController implements Serializable {

    @EJB
    private controller.MoraFacade ejbFacade;
    private List<Mora> items = null;
    private Mora selected;

    public MoraController() {
    }

    public Mora getSelected() {
        return selected;
    }

    public void setSelected(Mora selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getMoraPK().setClienteidCliente(selected.getCliente().getIdCliente());
        selected.getMoraPK().setUsuariounidadnegocioidUsuariounidadnegocio(selected.getUsuarioUnidadNegocio().getIdUsuariounidadnegocio());
    }

    protected void initializeEmbeddableKey() {
        selected.setMoraPK(new model.MoraPK());
    }

    private MoraFacade getFacade() {
        return ejbFacade;
    }

    public Mora prepareCreate() {
        selected = new Mora();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MoraCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MoraUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MoraDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Mora> getItems() {
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

    public Mora getMora(model.MoraPK id) {
        return getFacade().find(id);
    }

    public List<Mora> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Mora> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Mora.class)
    public static class MoraControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MoraController controller = (MoraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "moraController");
            return controller.getMora(getKey(value));
        }

        model.MoraPK getKey(String value) {
            model.MoraPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new model.MoraPK();
            key.setIdMora(Integer.parseInt(values[0]));
            key.setUsuariounidadnegocioidUsuariounidadnegocio(Integer.parseInt(values[1]));
            key.setClienteidCliente(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(model.MoraPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdMora());
            sb.append(SEPARATOR);
            sb.append(value.getUsuariounidadnegocioidUsuariounidadnegocio());
            sb.append(SEPARATOR);
            sb.append(value.getClienteidCliente());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Mora) {
                Mora o = (Mora) object;
                return getStringKey(o.getMoraPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Mora.class.getName()});
                return null;
            }
        }

    }

}
