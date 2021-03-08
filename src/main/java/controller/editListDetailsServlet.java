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
 * Servlet implementation class editListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class editListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListReptileHelper lrh = new ListReptileHelper();
		BreederHelper bh = new BreederHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = ldh.searchForListDetailsById(tempId);
		
		String newListName = request.getParameter("listName");
		
		String breederName = request.getParameter("breederName");
		Breeder newBreeder = bh.findBreeder(breederName);
		
		try {
			String[] selectedReptiles = request.getParameterValues("allReptilesToAdd");
			List<ListReptile> selectedReptilesInList = new ArrayList<ListReptile>();
			for(int i = 0; i < selectedReptiles.length; i++) {
				System.out.println(selectedReptiles[i]);
				ListReptile lr = lrh.searchForSpeciesById(Integer.parseInt(selectedReptiles[i]));
				selectedReptilesInList.add(lr);
			}
			listToUpdate.setListOfReptiles(selectedReptilesInList);
		} catch (NullPointerException ex) {
			// no items selected in list, set to an empty list
			List<ListReptile> selectedReptilesInList = new ArrayList<ListReptile>();
			listToUpdate.setListOfReptiles(selectedReptilesInList);
		}
		listToUpdate.setListName(newListName);
		listToUpdate.setBreeder(newBreeder);
		ldh.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

}
