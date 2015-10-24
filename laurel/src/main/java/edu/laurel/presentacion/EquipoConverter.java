package edu.laurel.presentacion;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import edu.laurel.constantes.Equipo;

@FacesConverter(value = "equipoConverter")
public class EquipoConverter extends EnumConverter {

    public EquipoConverter() {
	super(Equipo.class);
    }

}
