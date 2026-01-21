package com.va.assign1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String userId = request.getParameter("userid");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String country = request.getParameter("country");
        String zipCode = request.getParameter("zip");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String[] language = request.getParameterValues("lang");
        String about = request.getParameter("about");

        // 🔹 Create Model object
        RegisterForm reg = new RegisterForm();
        reg.setUserId(userId);
        reg.setPassword(password);
        reg.setName(name);
        reg.setAddress(address);
        reg.setCountry(country);
        reg.setZipCode(zipCode);
        reg.setEmail(email);
        reg.setSex(sex);
        reg.setLanguage(language);
        reg.setAbout(about);
	}

}
