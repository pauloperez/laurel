package edu.laurel.dominio;

import java.io.Serializable;

public abstract class Base implements Serializable {

	private static final long serialVersionUID = 5804447291928835348L;

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