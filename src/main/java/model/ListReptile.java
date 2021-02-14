/**
 * @author Levi Shepherd - lshepherd2
 * CIS175 - Spring 2021
 * Feb 13, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="reptiles")
public class ListReptile {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="ID")
	private int id;
	@Column (name="BREEDER")
	private String breeder;
	@Column (name="SPECIES")
	private String species;
	
	/**
	 * Default no-arg constructor
	 */
	public ListReptile() {
		super();
	}

	/**
	 * @param breeder
	 * @param species
	 */
	public ListReptile(String breeder, String species) {
		super();
		this.breeder = breeder;
		this.species = species;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBreeder() {
		return breeder;
	}

	public void setBreeder(String breeder) {
		this.breeder = breeder;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	public String returnReptileDetails() {
		return breeder + ": " + species;
	}
}
