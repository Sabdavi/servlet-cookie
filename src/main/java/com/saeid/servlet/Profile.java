package com.saeid.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Profile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();


        request.getRequestDispatcher("link.html").include(request, response);

        Cookie ck[]=request.getCookies();
        List<Cookie> cookies = Arrays.stream(ck).filter(cookie -> cookie.getName().equals("userName")).collect(Collectors.toList());
        if(cookies.size()>0) {
            String userName = cookies.get(0).getValue();
            out.print("Welcome: "+userName);
        }
        else{
            out.print("Please login first");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
    }
}
