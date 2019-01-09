<%@ page import="org.truck.logistic.dao.repository.OrderRepository" %>
<%@ page import="org.truck.logistic.dao.entities.Order" %>
<%@ page import="org.truck.logistic.dao.repository.OrderRepository"%>
<%@ page import="org.truck.logistic.dao.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05.01.2019
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");

        if (user == null){
            response.sendRedirect("/login");
        }%>
    <meta charset="UTF-8">
    <title>Chang Order</title>
    <style><%@include file="/css/formStyle.css"%></style>
    <style><%@include file="/css/mainstyles.css"%></style>
</head>
<body class="reg">
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
</div>
<div class="containerForm">
    <%OrderRepository orderRepository = new OrderRepository(); %>
    <%Order order = orderRepository.getOrderByID(Long.parseLong(request.getParameter("id")));%>
    <form action="/update" method="get">
        <img src="img/semi-clipart-cartoon-8.png">
        <h1 class="loginTitle">Chang Order</h1>
        <div class="dws-input">
            <input type="text" value="<%=order.getID()%>" name="id" placeholder="Enter arrival">
        </div>
        <div class="dws-input">
            <input type="text" value="<%=order.getUSER_ID()%>" name="user_id" placeholder="Enter arrival">
        </div>
        <div class="dws-input">
            <input type="text" value="<%=order.getArrival()%>" name="arrival" placeholder="Enter arrival">
        </div>
        <div class="dws-input">
            <input type="text" value="<%=order.getDeparture()%>" name="departure" placeholder="Enter departure">
        </div>
        <div class="dws-input">
            <input type="text" value="<%=order.getDistance()%>" name="distance" placeholder="Enter distance">
        </div>

        <div class="dws-input">
            <input type="text" value="<%=order.getTimeDelivary()%>" name="timeDelivary" placeholder="Enter timeDelivary">
        </div>
        <br/>
        <div >
        <input class="dws-submitReg" type="submit" name="confirm" value="Accept">
         </div>
    </form>
</div>
</body>
</html>
