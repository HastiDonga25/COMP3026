package com.assign3.servlet;

import com.assign3.dao.UserDAO;
import com.assign3.model.User;
import com.assign3.util.HashUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UserDAO dao = new UserDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String mobile = req.getParameter("mobile");
        String email = req.getParameter("email");

        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            req.setAttribute("msg", "Username and password are required.");
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
            return;
        }

        String hash = HashUtil.hash(password, "SHA-256");

        User user = new User(username.trim(), hash, mobile, email);
        boolean ok = dao.insertUser(user);

        if (ok) {
            req.setAttribute("msg", "Saved! Password stored as SHA hash: " + hash);
        } else {
            req.setAttribute("msg", "Save failed.");
        }

        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }
}
