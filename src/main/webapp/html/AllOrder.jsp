<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 02.01.2019
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="org.truck.logistic.dao.entities.Order" %>
<%@ page import="org.truck.logistic.dao.repository.OrderRepository" %>
<%@ page import="org.truck.logistic.dao.entities.User" %>
<%@ page import="javax.servlet.http.HttpSession" %>


<html >
<head>
    <%HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");

        if (user == null){
            response.sendRedirect("/login");
        }%>
    <style><%@include file="/css/mainstyles.css"%></style>
    <style><%@include file="/css/welcome.css"%></style>
    <title>Order</title>
</head>
<body>
<div class="container">
    <div class="heading clearfix">
        <img src="logo1.png" alt="SafeDelivery" class="logo">
        <nav>
            <ul class="menu">
                <li>
                    <a href="/main">Home</a>
                </li>
                <li>
                    <a href="/login">Login</a>
                </li>
                <li>
                    <a href="/logout">LogOut</a>
                </li>
                <li>
                    <a href="/info">Info</a>
                </li>
            </ul>
        </nav>
    </div>

<h1 class="welcometitle">List of Services</h1>

<%OrderRepository orderRepository = new OrderRepository(); %>
<% ArrayList list = (ArrayList) orderRepository.getAllOrders(); %>
    <table>

        <tr>
            <th>Departure</th>
            <th>Distance</th>
            <th>Arrival</th>
            <th>TimeDelivery</th>
            <th> </th>
        </tr>
        <% for (int i = 0;i<list.size();i++) {%>
        <tr>
            <%Order order = (Order) list.get(i);%>
            <td><%=order.getDeparture()%></td>
            <td><%=order.getDistance()%></td>
            <td><%=order.getArrival()%></td>
            <td><%=order.getTimeDelivary()%></td>
            <td><a class="sulka" href="/<%= order %>" > change </a></td>

        </tr>
        <% }%>
    </table>

    <br>
    <div class="buttonwelcome">
    <div >
        <a href="/createOrder " class="buttonw1">New Order</a>
    </div>
    </div>
</body>
</html>
