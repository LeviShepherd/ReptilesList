package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListReptile;

/**
 * Servlet implementation class AddReptileServlet
 */
@WebServlet("/addReptileServlet")
public class AddReptileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReptileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String breeder = request.getParameter("breeder");
		String species = request.getParameter("species");
		ListReptile lr = new ListReptile(breeder, species);
		ListReptileHelper lrh = new ListReptileHelper();
		lrh.insertReptile(lr);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
