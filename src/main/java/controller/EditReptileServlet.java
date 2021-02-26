package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListReptile;

/**
 * Servlet implementation class EditReptileServlet
 */
@WebServlet("/editReptileServlet")
public class EditReptileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditReptileServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		ListReptileHelper lrh = new ListReptileHelper();
		
		String breeder = request.getParameter("breeder");
		String species = request.getParameter("species");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListReptile reptileToUpdate = lrh.searchForSpeciesById(tempId);
		reptileToUpdate.setSpecies(species);
		reptileToUpdate.setBreeder(breeder);
		
		lrh.updateReptile(reptileToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllReptilesServlet").forward(request, response);
	}

}
