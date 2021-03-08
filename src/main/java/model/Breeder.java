/**
 * @author Levi Shepherd - lshepherd2
 * CIS175 - Spring 2021
 * Mar 7, 2021
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="breeder")
public class Breeder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BREEDER_ID")
	private int id;
	@Column(name="BREEDER_NAME")
	private String breederName;
	
	/**
	 * 
	 */
	public Breeder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param breederName
	 */
	public Breeder(int id, String breederName) {
		super();
		this.id = id;
		this.breederName = breederName;
	}

	/**
	 * @param breederName
	 */
	public Breeder(String breederName) {
		super();
		this.breederName = breederName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBreederName() {
		return breederName;
	}

	public void setBreederName(String breederName) {
		this.breederName = breederName;
	}

	@Override
	public String toString() {
		return "Breeder [id=" + id + ", breederName=" + breederName + "]";
	}
}
