package org.truck.logistic.controller;

import org.truck.logistic.dao.entities.Order;
import org.truck.logistic.dao.entities.User;
import org.truck.logistic.dao.repository.OrderRepository;
import org.truck.logistic.view.CreateOrderView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "OrderController",urlPatterns = "/createOrder")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        HttpSession httpSession = request.getSession();
        CreateOrderView createOrderView = new CreateOrderView();

        User user = (User) httpSession.getAttribute("user");
        if(user!=null){
            printWriter.write(createOrderView.getHtml());
        }

        if((request.getParameter("departure"))!=null){
            OrderRepository orderRepository = new OrderRepository();
            Order order = new Order();
            order.setDeparture(request.getParameter("departure"));
            order.setArrival(request.getParameter("arrival"));
            order.setDistance(request.getParameter("distance"));
            order.setTimeDelivary(request.getParameter("timeDelivary"));

            orderRepository.saveOrder(order);
        }
    }
}
