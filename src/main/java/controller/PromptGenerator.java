package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PromptGenerator
 */
@WebServlet("/PromptGenerator")
public class PromptGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public PromptGenerator() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String attribute = "";
		attribute = request.getParameter("subject");
		//System.out.println("L'ATTRIBUTO è:" + attribute);
		
		if(attribute.equals("personA")) {
			try {
				ConnectionToDatabase connectz = new ConnectionToDatabase();
				response.getWriter().append(connectz.getRandomEntryFromTable("persona"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(attribute.equals("personB")) {
			try {
				ConnectionToDatabase connectz = new ConnectionToDatabase();
				response.getWriter().append(connectz.getRandomEntryFromTable("personb"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(attribute.equals("place")) {
			try {
				ConnectionToDatabase connectz = new ConnectionToDatabase();
				response.getWriter().append(connectz.getRandomEntryFromTable("places"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(attribute.equals("time")) {
			try {
				ConnectionToDatabase connectz = new ConnectionToDatabase();
				response.getWriter().append(connectz.getRandomEntryFromTable("times"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(attribute.equals("object")) {
			try {
				ConnectionToDatabase connectz = new ConnectionToDatabase();
				response.getWriter().append(connectz.getRandomEntryFromTable("objects"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(attribute.equals("song")) {
			try {
				ConnectionToDatabase connectz = new ConnectionToDatabase();
				response.getWriter().append(connectz.getRandomSongFromTable("songs"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(attribute.equals("relationship")) {
			try {
				ConnectionToDatabase connectz = new ConnectionToDatabase();
				response.getWriter().append(connectz.getRandomEntryFromTable("relationships"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 

		response.setContentType("text/html; charset=UTF-8");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
