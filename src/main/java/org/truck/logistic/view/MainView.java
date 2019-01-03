package org.truck.logistic.view;

public class MainView {
    public String getHtml(){
        IndexView indexView = IndexView.getInstance();
        return indexView.getIndex();
    }
}
