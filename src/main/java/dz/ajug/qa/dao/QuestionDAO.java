package dz.ajug.qa.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import dz.ajug.qa.model.Question;

public class QuestionDAO {

	@Inject
	EntityManager em;

	public List<Question> getAll() {
		return em.createQuery("select q from Question q", Question.class)
				.setMaxResults(50).getResultList();
	}

	public List<Question> getByString(String str) {
		return em
				.createQuery(
						"select q from Question q "
								+ "where q.title like :str or q.description like :str",
						Question.class).setParameter("str", "%" + str + "%")
				.setMaxResults(50).getResultList();
	}

	public Question getOne(Long id) {
		return em.find(Question.class, id);
	}

	public Question getOne(String title) {
		try {
			return em
					.createQuery(
							"select q from Question q where q.title = :title",
							Question.class).setParameter("title", title)
					.getSingleResult();
		} catch (NoResultException nre) {
			return getNoResultObject();
		}
	}

	public Question insert(Question Question) {
		try {
			em.getTransaction().begin();
			em.persist(Question);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		return Question;
	}

	public Question update(Question Question) {
		try {
			em.getTransaction().begin();
			em.merge(Question);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		return Question;
	}

	public void remove(Long id) {
		Question Question = em.find(Question.class, id);
		try {
			if (Question != null) {
				em.getTransaction().begin();
				em.remove(Question);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	public Question getNoResultObject() {
		return null;
	}

}
