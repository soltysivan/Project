package org.truck.logistic.controller;

import org.truck.logistic.dao.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutController", urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter printWriter = response.getWriter();
        HttpSession httpSession = request.getSession();
        User user =(User) httpSession.getAttribute("user");

        if (user !=null){
            httpSession.setAttribute("user", null);
            response.sendRedirect("/login");
        }
    }
}
