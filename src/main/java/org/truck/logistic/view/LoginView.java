package org.truck.logistic.view;

public class LoginView {
    public String getHtml(){
        IndexView indexView = IndexView.getInstance();
        return indexView.getLogin();
    }
}
