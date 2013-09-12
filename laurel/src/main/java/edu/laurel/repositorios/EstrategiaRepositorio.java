package edu.laurel.repositorios;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EstrategiaRepositorio {

	private EntityManager entityManager;

	public <T> boolean existe(final Map<String, ?> parametros) {
		Class<T> classT = null;
		boolean existe = false;
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(classT);

		Root<T> t = criteriaQuery.from(classT);
		java.util.List<Predicate> predicates = new java.util.ArrayList<Predicate>();
		for (String nombreParametro : parametros.keySet())
			predicates.add(criteriaBuilder.equal(t.get(nombreParametro),
					parametros.get(nombreParametro)));
		criteriaQuery.where(predicates.toArray(new Predicate[] {}));

		TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
		java.util.List<T> results = query.getResultList();

		existe = !results.isEmpty();

		return existe;
	}
}
