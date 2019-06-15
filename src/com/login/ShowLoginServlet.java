package com.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserLoginDao;
import com.model.UserDetails;


public class ShowLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ShowLoginServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*String uname = (String) request.getAttribute("userName");
		String pwd = (String) request.getAttribute("password");*/
		
		String uname = (String) request.getParameter("userName");
		String pwd = (String) request.getParameter("password");
		System.out.println("User name : "+uname+", password : "+pwd);

		UserLoginDao loginDao = new UserLoginDao();
		UserDetails udetails = null;
		try {
			 udetails = loginDao.validateUser(uname, pwd);
		} catch (SQLException e) {
			System.out.println("Exception while validating the user.");
			e.printStackTrace();
		}
		if(udetails != null) {
			request.setAttribute("username", udetails.getUserName());
			request.getRequestDispatcher("WEB-INF/resource/jsp/success.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMessage", "Invalid Credentials");
			request.getRequestDispatcher("WEB-INF/resource/jsp/login.jsp").forward(request, response);
		}
		
		request.setAttribute("userName1", uname);
		request.setAttribute("password1", pwd);
		request.getRequestDispatcher("WEB-INF/resource/jsp/show_login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Calling doGet method....");
		doGet(request, response);
	}

}
