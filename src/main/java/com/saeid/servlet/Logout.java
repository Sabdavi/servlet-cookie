package com.saeid.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("link.html").include(req,resp);
        Cookie cookie = new Cookie("userName","");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        out.print("you successfully log out! ");
    }
}
