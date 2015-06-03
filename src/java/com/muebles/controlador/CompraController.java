package com.muebles.controlador;

import com.muebles.modelo.Compra;
import com.muebles.controlador.util.JsfUtil;
import com.muebles.controlador.util.PaginationHelper;
import com.muebles.ejb.CompraFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("compraController")
@SessionScoped
public class CompraController implements Serializable {

    private Compra current;
    private DataModel items = null;
    @EJB
    private com.muebles.ejb.CompraFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public CompraController() {
    }

    public Compra getSelected() {
        if (current == null) {
            current = new Compra();
            current.setCompraPK(new com.muebles.modelo.CompraPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private CompraFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Compra) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Compra();
        current.setCompraPK(new com.muebles.modelo.CompraPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getCompraPK().setIdMateriaPrima(current.getMateriaPrima().getIdMateriaPrima());
            current.getCompraPK().setIdProveedor(current.getProveedor().getIdProveedor());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CompraCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Compra) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getCompraPK().setIdMateriaPrima(current.getMateriaPrima().getIdMateriaPrima());
            current.getCompraPK().setIdProveedor(current.getProveedor().getIdProveedor());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CompraUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Compra) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CompraDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Compra getCompra(com.muebles.modelo.CompraPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Compra.class)
    public static class CompraControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CompraController controller = (CompraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "compraController");
            return controller.getCompra(getKey(value));
        }

        com.muebles.modelo.CompraPK getKey(String value) {
            com.muebles.modelo.CompraPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.muebles.modelo.CompraPK();
            key.setIdProveedor(Integer.parseInt(values[0]));
            key.setIdMateriaPrima(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.muebles.modelo.CompraPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdProveedor());
            sb.append(SEPARATOR);
            sb.append(value.getIdMateriaPrima());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Compra) {
                Compra o = (Compra) object;
                return getStringKey(o.getCompraPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Compra.class.getName());
            }
        }

    }

}
