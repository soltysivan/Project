package org.truck.logistic.view;

public class RegistrationView {
    public String getHtml(){
        IndexView indexView = IndexView.getInstance();
        return indexView.getRegistration();
    }
}
