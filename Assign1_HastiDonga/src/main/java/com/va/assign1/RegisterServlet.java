package com.va.assign1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userid");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String country = request.getParameter("country");
        String zip = request.getParameter("zip");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String[] language = request.getParameterValues("lang");
        String about = request.getParameter("about");

        // Create Model object
        RegisterForm reg = new RegisterForm();
        reg.setUserId(userId);
        reg.setPassword(password);
        reg.setName(name);
        reg.setAddress(address);
        reg.setCountry(country);
        reg.setZipCode(zip);
        reg.setEmail(email);
        reg.setSex(sex);
        reg.setLanguage(language);
        reg.setAbout(about);

        // Keep values so user doesn't retype on error
        request.setAttribute("form_userid", userId);
        request.setAttribute("form_name", name);
        request.setAttribute("form_address", address);
        request.setAttribute("form_country", country);
        request.setAttribute("form_zip", zip);
        request.setAttribute("form_email", email);
        request.setAttribute("form_sex", sex);
        request.setAttribute("form_about", about);

        RegisterDao dao = new RegisterDao();

        try {
            // ✅ Assignment 2 DB Validation
            if (dao.userIdExists(userId)) {
                request.setAttribute("uidErrServer", "User id already exists.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }

            if (dao.emailExists(email)) {
                request.setAttribute("emailErrServer", "Email already exists.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }

            // Insert into DB
            int status = dao.registerUser(reg);

            if (status > 0) {
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.setAttribute("generalErr", "Insert failed (status=0). Check DB table/columns.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("generalErr", "DB Error: " + e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
