package com.saeid.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        req.getRequestDispatcher("link.html").include(req, resp);

        String username = req.getParameter("userName");
        String password = req.getParameter("password");

        if (password.equals("admin123")) {
            out.print("You Successfully Login");
            out.print("Welcome: " + username);

            Cookie cookie = new Cookie("userName",username);
            resp.addCookie(cookie);
        } else {
            out.print("sorry, the username or password is incorrect");
            req.getRequestDispatcher("link.html").include(req, resp);
        }
        out.close();
    }


}
