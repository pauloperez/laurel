package edu.laurel.repositorios.estrategias;

import java.util.Collection;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class EstrategaJPARepositorio extends EstrategaRepositorio {

	private EntityManager entityManager;

	@Override
	public <T> boolean existe(final Collection<T> coleccion,
			final Map<String, ?> parametros) {
		final Class<T> classT = null;
		boolean existe = false;
		final CriteriaBuilder criteriaBuilder = entityManager
				.getCriteriaBuilder();
		final CriteriaQuery<T> criteriaQuery = criteriaBuilder
				.createQuery(classT);
		final Root<T> t = criteriaQuery.from(classT);
		final java.util.List<Predicate> predicates = new java.util.ArrayList<Predicate>();

		for (final String nombreParametro : parametros.keySet())
			predicates.add(criteriaBuilder.equal(t.get(nombreParametro),
					parametros.get(nombreParametro)));
		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		final TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		final java.util.List<T> results = query.getResultList();

		existe = !results.isEmpty();

		return existe;
	}

}
