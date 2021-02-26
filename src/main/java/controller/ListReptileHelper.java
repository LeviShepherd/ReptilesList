/**
 * @author Levi Shepherd - lshepherd2
 * CIS175 - Spring 2021
 * Feb 13, 2021
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListReptile;

public class ListReptileHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebReptilesList");
	
	public void insertReptile(ListReptile lr) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lr);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListReptile> showAllReptiles(){
		EntityManager em = emfactory.createEntityManager();
		List<ListReptile> allReptiles = em.createQuery("SELECT i FROM ListReptile i").getResultList();
		return allReptiles;
	}
	
	public void deleteReptile(ListReptile toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListReptile> typedQuery = em.createQuery("select lr from ListReptile lr where lr.breeder = :selectedBreeder and lr.species = :selectedSpecies", ListReptile.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedBreeder", toDelete.getBreeder());
		typedQuery.setParameter("selectedSpecies", toDelete.getSpecies());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		ListReptile result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * @param idToEdit
	 * @return
	 */
	public ListReptile searchForSpeciesById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListReptile found = em.
		find(ListReptile.class, idToEdit);
		em.close();
		return found;
	}
	
	/**
	 * @param toEdit
	 */
	public void updateReptile(ListReptile toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}
	
	/**
	 * @param breederName
	 * @return
	 */
	public List<ListReptile> searchForSpeciesByBreeder(String breederName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListReptile> typedQuery = em.createQuery("select lr from ListReptile lr where lr.breeder = :selectedBreeder", ListReptile.class);
		typedQuery.setParameter("selectedBreeder", breederName);
		List<ListReptile> foundSpecies = typedQuery.getResultList();
		em.close();
		return foundSpecies;
	}
	
	/**
	 * @param speciesName
	 * @return
	 */
	public List<ListReptile> searchForSpeciesBySpecies(String speciesName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListReptile> typedQuery = em.createQuery("select lr from ListReptile lr where lr.species = :selectedSpecies", ListReptile.class);
		typedQuery.setParameter("selectedSpecies", speciesName);
		List<ListReptile> foundSpecies = typedQuery.getResultList();
		em.close();
		return foundSpecies;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
