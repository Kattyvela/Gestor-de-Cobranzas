package controller;

import model.AbonoDeuda;
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

@Named("abonoDeudaController")
@SessionScoped
public class AbonoDeudaController implements Serializable {

    @EJB
    private controller.AbonoDeudaFacade ejbFacade;
    private List<AbonoDeuda> items = null;
    private AbonoDeuda selected;

    public AbonoDeudaController() {
    }

    public AbonoDeuda getSelected() {
        return selected;
    }

    public void setSelected(AbonoDeuda selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getAbonoDeudaPK().setFormaPagoidFormaPago(selected.getFormaPago().getIdFormaPago());
        selected.getAbonoDeudaPK().setMoraidMora(selected.getMora().getMoraPK().getIdMora());
        selected.getAbonoDeudaPK().setMoraUsuariounidadnegocioidUsuariounidadnegocio(selected.getMora().getMoraPK().getUsuariounidadnegocioidUsuariounidadnegocio());
        selected.getAbonoDeudaPK().setMoraClienteidCliente(selected.getMora().getMoraPK().getClienteidCliente());
    }

    protected void initializeEmbeddableKey() {
        selected.setAbonoDeudaPK(new model.AbonoDeudaPK());
    }

    private AbonoDeudaFacade getFacade() {
        return ejbFacade;
    }

    public AbonoDeuda prepareCreate() {
        selected = new AbonoDeuda();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AbonoDeudaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AbonoDeudaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AbonoDeudaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AbonoDeuda> getItems() {
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

    public AbonoDeuda getAbonoDeuda(model.AbonoDeudaPK id) {
        return getFacade().find(id);
    }

    public List<AbonoDeuda> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AbonoDeuda> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AbonoDeuda.class)
    public static class AbonoDeudaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AbonoDeudaController controller = (AbonoDeudaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "abonoDeudaController");
            return controller.getAbonoDeuda(getKey(value));
        }

        model.AbonoDeudaPK getKey(String value) {
            model.AbonoDeudaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new model.AbonoDeudaPK();
            key.setIdAbonoDeuda(Integer.parseInt(values[0]));
            key.setMoraidMora(Integer.parseInt(values[1]));
            key.setMoraUsuariounidadnegocioidUsuariounidadnegocio(Integer.parseInt(values[2]));
            key.setMoraClienteidCliente(Integer.parseInt(values[3]));
            key.setFormaPagoidFormaPago(Integer.parseInt(values[4]));
            return key;
        }

        String getStringKey(model.AbonoDeudaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdAbonoDeuda());
            sb.append(SEPARATOR);
            sb.append(value.getMoraidMora());
            sb.append(SEPARATOR);
            sb.append(value.getMoraUsuariounidadnegocioidUsuariounidadnegocio());
            sb.append(SEPARATOR);
            sb.append(value.getMoraClienteidCliente());
            sb.append(SEPARATOR);
            sb.append(value.getFormaPagoidFormaPago());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AbonoDeuda) {
                AbonoDeuda o = (AbonoDeuda) object;
                return getStringKey(o.getAbonoDeudaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AbonoDeuda.class.getName()});
                return null;
            }
        }

    }

}
