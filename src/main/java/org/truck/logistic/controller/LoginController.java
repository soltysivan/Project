package org.truck.logistic.controller;

import org.truck.logistic.dao.entities.User;
import org.truck.logistic.dao.repository.UserRepository;
import org.truck.logistic.view.LoginView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession httpSession = request.getSession();
        PrintWriter printWriter = response.getWriter();

        if((request.getParameter("email")!=null)){
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getUserByEmailAndPassword(request.getParameter("email"),request.getParameter("password"));
            if(user==null){
                printWriter.write("Please login again");
            }else {
                httpSession.setAttribute("user",user);
                response.sendRedirect("/html/AllOrder.jsp");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        LoginView loginView = new LoginView();
        HttpSession httpSession = request.getSession();

        User user1 =(User) httpSession.getAttribute("user");
        if (user1 != null){
            response.sendRedirect("/main");
        }

        printWriter.write(loginView.getHtml());
    }
    }
