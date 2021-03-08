/**
 * @author Levi Shepherd - lshepherd2
 * CIS175 - Spring 2021
 * Mar 7, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Breeder;

public class BreederHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebReptilesList");
	
	public void insertBreeder(Breeder b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Breeder> showAllBreeders(){
		EntityManager em = emfactory.createEntityManager();
		List<Breeder> allBreeders = em.createQuery("SELECT b from Breeder b").getResultList();
		return allBreeders;
	}
	
	public Breeder findBreeder(String breederName) {
		EntityManager em =
		emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Breeder> typedQuery = em.createQuery("select br from Breeder br where br.breederName = :selectedName", Breeder.class);
		typedQuery.setParameter("selectedName", breederName);
		Breeder foundBreeder;
		try {
			foundBreeder = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundBreeder = new Breeder(breederName);
		}
		em.close();
		return foundBreeder;
	}
}
