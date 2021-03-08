package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Breeder;
import model.ListDetails;
import model.ListReptile;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListReptileHelper lrh = new ListReptileHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		String breederName = request.getParameter("breederName");
		String[] selectedReptiles = request.getParameterValues("allReptilesToAdd");
		List<ListReptile> selectedReptilesInList = new ArrayList<ListReptile>();
		if(selectedReptiles != null && selectedReptiles.length > 0) {
			for(int i = 0; i < selectedReptiles.length; i++) {
				System.out.println(selectedReptiles[i]);
				ListReptile r = lrh.searchForSpeciesById(Integer.parseInt(selectedReptiles[i]));
				selectedReptilesInList.add(r);
			}
		}
		
		Breeder breeder = new Breeder(breederName);
		ListDetails ld = new ListDetails(listName, breeder);
		ld.setListOfReptiles(selectedReptilesInList);
		ListDetailsHelper ldh = new ListDetailsHelper();
		ldh.insertNewListDetails(ld);
		
		System.out.println("Success!");
		System.out.println(ld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
