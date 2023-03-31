package com.dzvonik.webapp.web;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

public class ResumeServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // response.sendRedirect("resume.html");
        response.getWriter().write("Hello, " + request.getParameter("name"));
    }

}
