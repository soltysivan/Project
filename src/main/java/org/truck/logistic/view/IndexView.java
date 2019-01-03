package org.truck.logistic.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndexView {
    private String htmlPath;
    private String index;
    private String info;
    private String login;
    private String registration;
    private String welcome;
    private String createOrder;

    private static IndexView ourInstance = new IndexView();

    public static IndexView getInstance() {
        return ourInstance;
    }

    private IndexView() {
    }

    public String getHtmlPath() {
        return htmlPath;
    }

    public String getCreateOrder() {
        return createOrder;
    }

    public void setCreateOrder(String createOrder) {
        this.createOrder = createOrder;
    }

    public void setHtmlPath(String htmlPath) {
        this.htmlPath = htmlPath;
        this.index = getPartialHtml("index.html");
        this.info = getPartialHtml("info.html");
        this.login = getPartialHtml("loginUser.html");
        this.registration = getPartialHtml("registration.html");
        this.welcome = getPartialHtml("welcome.html");
        this.createOrder=getPartialHtml("createOrder.html");

    }

    public String getPartialHtml (String fileName){
        StringBuilder stringBuilder = new StringBuilder();
        Path file = Paths.get(this.htmlPath+fileName);
        Charset charset = Charset.forName("UTF-8");

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(file,charset);
            String line = null;
            while ((line =bufferedReader.readLine())!=null){
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }


}
