package edu.laurel.repositorios.estrategias;

import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import edu.laurel.dominio.Laurel;

public class EstrategaJPARepositorio<T> extends EstrategaRepositorio<T> {

	private static final long serialVersionUID = 5665161464546963089L;

	@Inject
	private EntityManager entityManager;

	@Override
	public T encontrar(final Class<T> clase, final int oid) {
		return entityManager.find(clase, oid);
	}

	@Override
	public boolean existe(final Collection<T> coleccion, final Class<T> clase, final Map<String, ?> parametros) {
		boolean existe = false;
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(clase);
		final Root<T> t = criteriaQuery.from(clase);
		final java.util.List<Predicate> predicates = new java.util.ArrayList<Predicate>();

		for (final String nombreParametro : parametros.keySet())
			predicates.add(criteriaBuilder.equal(t.get(nombreParametro), parametros.get(nombreParametro)));
		criteriaQuery.select(t).where(predicates.toArray(new Predicate[] {}));

		final TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		final java.util.List<T> results = query.getResultList();

		existe = !results.isEmpty();

		return existe;
	}

	@Override
	public Laurel crearRaiz() {
		final Laurel raiz = super.crearRaiz();
		entityManager.persist(raiz);
		return raiz;
	}
}
