/**
 * @author Levi Shepherd - lshepherd2
 * CIS175 - Spring 2021
 * Feb 13, 2021
 */

import java.util.List;
import java.util.Scanner;

import controller.ListReptileHelper;
import model.ListReptile;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static ListReptileHelper lrh = new ListReptileHelper();
	
	private static void addAReptile() {
		System.out.println("Enter the breeder's name or company: ");
		String breeder = in.nextLine();
		System.out.println("Enter the species of the reptile: ");
		String species = in.nextLine();
		ListReptile toAdd = new ListReptile(breeder, species);
		lrh.insertReptile(toAdd);
	}
	
	private static void deleteAReptile() {
		System.out.println("Enter the breeder/company to delete: ");
		String breeder = in.nextLine();
		System.out.println("Enter the species of reptile to delete: ");
		String species = in.nextLine();
		ListReptile toDelete = new ListReptile(breeder, species);
		lrh.deleteReptile(toDelete);
	}
	
	private static void editAReptile() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Breeder or Company");
		System.out.println("2 : Search by Reptile Species");
		int searchBy = in.nextInt();
		in.nextLine();
		List<ListReptile> foundReptile;
		if (searchBy == 1) {
			System.out.print("Enter the breeder/company name: ");
			String breederName = in.nextLine();
			foundReptile = lrh.searchForSpeciesByBreeder(breederName);
		} else {
			System.out.print("Enter the Reptile Species: ");
			String speciesName = in.nextLine();
			foundReptile = lrh.searchForSpeciesBySpecies(speciesName);

		}

		if (!foundReptile.isEmpty()) {
			System.out.println("Found Results.");
			for (ListReptile l : foundReptile) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			ListReptile toEdit = lrh.searchForSpeciesById(idToEdit);
			System.out.println("Retrieved " + toEdit.getSpecies() + " from " + toEdit.getBreeder());
			System.out.println("1 : Update Breeder");
			System.out.println("2 : Update Species");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Breeder/Company: ");
				String newBreeder = in.nextLine();
				toEdit.setBreeder(newBreeder);
			} else if (update == 2) {
				System.out.print("New Species: ");
				String newSpecies = in.nextLine();
				toEdit.setSpecies(newSpecies);
			}

			lrh.updateReptile(toEdit);

		} else {
			System.out.println("Sorry, no results were found.");
		}
	}
	
	public static void main(String[] args) {
		runMenu();

	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("Welcome to the Reptile classified list!");
		while (goAgain) {
			System.out.println("| Select a menu item: ");
			System.out.println("| 1 -- Add a reptile");
			System.out.println("| 2 -- Edit a reptile");
			System.out.println("| 3 -- Delete a reptile");
			System.out.println("| 4 -- View the current list of available reptiles");
			System.out.println("| 5 -- Exit the program");
			System.out.println("|  Your Selection: ");
			int selection = in.nextInt();
			in.nextLine();
			
			if (selection == 1) {
				addAReptile();
			} else if (selection == 2) {
				editAReptile();
			} else if (selection == 3) {
				deleteAReptile();
			} else if (selection == 4) {
				viewReptileList();
			} else {
				lrh.cleanUp();
				System.out.println("  Thank you for using the program!  ");
				goAgain = false;
			}
		}
	}
	
	private static void viewReptileList() {
		List<ListReptile> allReptiles = lrh.showAllReptiles();
		for(ListReptile singleReptile : allReptiles) {
			System.out.println(singleReptile.returnReptileDetails());
		}
	}
}
