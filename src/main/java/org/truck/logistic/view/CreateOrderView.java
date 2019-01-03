package org.truck.logistic.view;

public class CreateOrderView {
    public String getHtml(){
        IndexView indexView = IndexView.getInstance();
        return indexView.getCreateOrder();
    }
}
