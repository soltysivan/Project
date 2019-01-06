package org.truck.logistic.controller;

import org.truck.logistic.dao.entities.User;
import org.truck.logistic.dao.repository.UserRepository;
import org.truck.logistic.formvalidator.RegisterFormValidator;
import org.truck.logistic.view.RegistrationView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationController", urlPatterns = "/registration")
public class RegistrationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        RegistrationView registrationView = new RegistrationView();
        HttpSession httpSession = request.getSession();

        User user1 = (User) httpSession.getAttribute("user");
        if (user1 != null){
            response.sendRedirect("/main");
        }

        printWriter.write(registrationView.getHtml());



        if (request.getParameter("email")!= null){
            RegisterFormValidator registerFormValidator = new RegisterFormValidator(
                    request.getParameter("userName"),
                    request.getParameter("password"),
                    request.getParameter("email"));
            if (!registerFormValidator.isFormValid()){
                printWriter.write(registerFormValidator.getMessageError());
            }else {
                UserRepository userRepository = new UserRepository();
                User user = new User();
                user.setUserName(request.getParameter("userName"));
                user.setPassword(request.getParameter("password"));
                user.setEmail(request.getParameter("email"));
                userRepository.saveUser(user);
                if (user == null) {
                    printWriter.write("Pleas fill in all the fields");
                } else {
                    response.sendRedirect("/login");
                }
            }
        }
    }
}
