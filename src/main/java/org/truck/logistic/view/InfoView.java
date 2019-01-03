package org.truck.logistic.view;

public class InfoView {
    public String grtHtml (){
        IndexView indexView = IndexView.getInstance();
        return indexView.getInfo();
    }
}
