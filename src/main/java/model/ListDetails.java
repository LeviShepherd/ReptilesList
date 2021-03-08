/**
 * @author Levi Shepherd - lshepherd2
 * CIS175 - Spring 2021
 * Mar 7, 2021
 */
package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@ManyToOne(cascade=CascadeType.PERSIST)
		@JoinColumn(name="BREEDER_ID")
		private Breeder breeder;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable(name="reptiles_on_list",
		joinColumns={ @JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID") }, 
		inverseJoinColumns={ @JoinColumn(name="REPTILE_ID", referencedColumnName="ID", unique=true) })
	private List<ListReptile> listOfReptiles;

	/**
	 * 
	 */
	public ListDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param listName
	 * @param breeder
	 * @param listOfReptiles
	 */
	public ListDetails(int id, String listName, Breeder breeder, List<ListReptile> listOfReptiles) {
		super();
		this.id = id;
		this.listName = listName;
		this.breeder = breeder;
		this.listOfReptiles = listOfReptiles;
	}
	
	/**
	 * @param listName
	 * @param breeder
	 * @param listOfReptiles
	 */
	public ListDetails(String listName, Breeder breeder, List<ListReptile> listOfReptiles) {
		super();
		this.listName = listName;
		this.breeder = breeder;
		this.listOfReptiles = listOfReptiles;
	}

	/**
	 * @param listName
	 * @param breeder
	 */
	public ListDetails(String listName, Breeder breeder) {
		super();
		this.listName = listName;
		this.breeder = breeder;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public Breeder getBreeder() {
		return breeder;
	}

	public void setBreeder(Breeder breeder) {
		this.breeder = breeder;
	}

	public List<ListReptile> getListOfReptiles() {
		return listOfReptiles;
	}

	public void setListOfReptiles(List<ListReptile> listOfReptiles) {
		this.listOfReptiles = listOfReptiles;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", breeder=" + breeder + ", listOfReptiles="
				+ listOfReptiles + "]";
	}
	
	
}
