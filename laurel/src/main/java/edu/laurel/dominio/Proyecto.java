package edu.laurel.dominio;

public class Proyecto extends Base {
    private static final long serialVersionUID = 3927912902439221137L;

    private String nombre;
    private java.util.Collection<EstadoItem> estadosItem;
    private java.util.Collection<TipoItem> tiposItem;

    private Usuario lider;
    private java.util.Collection<Usuario> miembros;

    private java.util.Collection<Item> items;

    public Proyecto() {
	super();
	estadosItem = new java.util.HashSet<EstadoItem>();
	tiposItem = new java.util.HashSet<TipoItem>();
	miembros = new java.util.ArrayList<Usuario>();
	items = new java.util.ArrayList<Item>();
    }

    public Proyecto(final String nombre, final Usuario lider) {
	this();
	this.nombre = nombre;
	this.lider = lider;
    }

    public String getNombre() {
	return nombre;
    }

    public Usuario getLider() {
	return lider;
    }

    public boolean esLider(final Usuario usuario) {
	boolean esLider = false;
	if (lider != null & usuario != null)
	    esLider = lider.equals(usuario);
	return esLider;
    }

    public java.util.Collection<TipoItem> getTiposItem() {
	return tiposItem;
    }

    public void darAltaTipoItem(final TipoItem tipoItem) {
	tiposItem.add(tipoItem);
    }

    public java.util.Collection<EstadoItem> getEstadosItem() {
	return estadosItem;
    }

    public void setEstadosItem(final EstadoItem... estados) {
	for (final EstadoItem estadoItem : estados)
	    estadosItem.add(estadoItem);
    }

    public java.util.Collection<Usuario> getMiembros() {
	return miembros;
    }

    public void adherir(final Usuario usuario) {
	miembros.add(usuario);
    }

    public void desligar(final Usuario usuario) {
	miembros.remove(usuario);
    }

    public java.util.Collection<Item> getItems() {
	return items;
    }

    public void darAltaItem(final Item item) {
	items.add(item);
    }

}
