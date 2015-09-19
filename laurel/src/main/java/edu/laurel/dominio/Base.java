package edu.laurel.dominio;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @Override
    public int hashCode() {
	return new HashCodeBuilder(1, 3). // two randomly chosen prime numbers
	// if deriving: appendSuper(super.hashCode()).
	append(oid).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
	if (obj == null)
	    return false;
	if (obj == this)
	    return true;
	if (!(obj instanceof Base))
	    return false;

	final Base rhs = (Base) obj;
	return new EqualsBuilder().
	        // if deriving: appendSuper(super.equals(obj)).
	        append(oid, rhs.oid).isEquals();
    }
}