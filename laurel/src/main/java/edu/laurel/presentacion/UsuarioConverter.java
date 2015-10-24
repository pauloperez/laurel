package edu.laurel.presentacion;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import edu.laurel.dominio.Usuario;
import edu.laurel.frontera.EntradaUsuario;

@Named
@RequestScoped
public class UsuarioConverter implements Converter {

    @Inject
    EntradaUsuario entradaUsuario;

    @Override
    public Object getAsObject(final FacesContext facesContext, final UIComponent component, final String value)
	    throws ConverterException {
	if (value != null && value.trim().length() > 0)
	    try {
		return entradaUsuario.buscar(Integer.parseInt(value));
	    } catch(final NumberFormatException e) {
		e.printStackTrace();
		throw new ConverterException(
			new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid user."));
	    }
	else
	    return null;
    }

    @Override
    public String getAsString(final FacesContext facesContext, final UIComponent component, final Object object)
	    throws ConverterException {
	if (object != null)
	    return String.valueOf(((Usuario) object).getOid());
	else
	    return null;
    }

}
