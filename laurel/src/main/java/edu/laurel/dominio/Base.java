package edu.laurel.dominio;

public abstract class Base {
	protected int oid;

	public Base() {
		super();
	}

	public int getOid() {
		return oid;
	}

	public void setOid(final int oid) {
		this.oid = oid;
	}
}