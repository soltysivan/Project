package org.truck.logistic.view;

public class WelcomeView {
    public String getHtml(){
        IndexView indexView = IndexView.getInstance();
        return indexView.getWelcome();
    }
}
