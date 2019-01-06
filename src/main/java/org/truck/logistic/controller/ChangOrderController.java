package org.truck.logistic.controller;

import org.truck.logistic.dao.entities.Order;
import org.truck.logistic.dao.entities.User;
import org.truck.logistic.dao.repository.OrderRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangOrderController",urlPatterns = "/update")
public class ChangOrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        HttpSession httpSession = request.getSession();


        User user = (User) httpSession.getAttribute("user");
        if(user==null){
            response.sendRedirect("/login");
        }


//        if(request.getParameter("ID")!=null){
            OrderRepository orderRepository = new OrderRepository();
            Order order = new Order();
          // order.setID(Long.parseLong(request.getParameter("ID")));
            order.setUSER_ID(Long.parseLong(request.getParameter("USER_ID")));
            order.setDeparture(request.getParameter("departure"));
            order.setArrival(request.getParameter("arrival"));
            order.setDistance(request.getParameter("distance"));
            order.setTimeDelivary(request.getParameter("timeDelivary"));

            orderRepository.changOrder(order, Long.valueOf(request.getParameter("ID")));
       // }
        response.sendRedirect("/html/AllOrder.jsp");
    }
    }
