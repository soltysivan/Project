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
    <style><%@include file="/css/mainStyles.css"%></style>
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
        <%for (Object i: list) {%>
<br>
       <a class="sulka" href="/<%= i %>" > <%= i  %></>
<br>
       <% }%>
    <br>
    <br>
    <div class="buttonwelcome">
    <div >
        <a href="/createOrder " class="buttonw1">New Order</a>
    </div>
    </div>
</body>
</html>
