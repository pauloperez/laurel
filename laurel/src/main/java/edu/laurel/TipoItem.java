package edu.laurel;

public class TipoItem {
	private String nombre;
	private final java.util.Set<SecuenciaEstado> cicloDeVida;

	public TipoItem(final String nombre) {
		this.nombre = nombre;
		cicloDeVida = new java.util.HashSet<SecuenciaEstado>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public void agregarSecuencia(final EstadoItem inicio, final EstadoItem fin) {
		if (cicloDeVida.isEmpty())
			cicloDeVida.add(new SecuenciaEstado(null, inicio));
		cicloDeVida.add(new SecuenciaEstado(inicio, fin));
	}

	public boolean tieneConfigurado(final EstadoItem estado) {
		for (final SecuenciaEstado secuenciaEstado : cicloDeVida)
			if (secuenciaEstado.getFin().equals(estado))
				return true;
		return false;
	}

	public boolean puedeRealizarSecuencia(final EstadoItem actual,
			final EstadoItem siguiente) {
		return cicloDeVida.contains(new SecuenciaEstado(actual, siguiente));
	}
}
