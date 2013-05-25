package edu.laurel;

public class Proyecto {
	private final String nombre;
	private final java.util.Collection<Item> items;
	private final java.util.Collection<TipoItem> tipoItems;

	private final Usuario lider;
	private final java.util.Collection<Usuario> miembros;

	public Proyecto(final String nombre, final Usuario lider) {
		this.nombre = nombre;
		this.lider = lider;
		items = new java.util.ArrayList<Item>();
		miembros = new java.util.ArrayList<Usuario>();
		tipoItems =  new java.util.HashSet<TipoItem>();
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

	public java.util.Collection<TipoItem> getTipoItems() {
		return tipoItems;
	}

	public java.util.Collection<Item> getItems() {
		return items;
	}

	public void darAltaItem(final Item item) {
		items.add(item);
	}

	public void darAltaTipoItem(final TipoItem tipoItem) {
		tipoItems.add(tipoItem);
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

}
