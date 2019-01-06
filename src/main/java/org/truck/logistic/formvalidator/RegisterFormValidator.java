package org.truck.logistic.formvalidator;

public class RegisterFormValidator {
    private String userName;
    private String password;
    private String email;
    private String messageError;

    private interface CheckField {
        boolean isCorrect(String field);
    }

    public RegisterFormValidator() {
    }

    public RegisterFormValidator(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public boolean isFormValid (){
        CheckField checkFieldMin4 = field ->{
            if (field.length()<4){
                messageError = "Minimum 4 nums in User Name";
                return false;
            }
            return true;
        };
        if (!checkFieldMin4.isCorrect("userName")){
            return false;
        }
        CheckField checkFieldEmail = field -> {
            boolean res =  field.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            if (! res) {
                messageError = "Invalid Email!";
            }
            return res;
        };

        if ( ! checkFieldEmail.isCorrect(email)) {
            return false;
        }

        //check password minimun 4
        if ( ! checkFieldMin4.isCorrect(password)) {
            return false;
        }

        // check password has min 1 number
        CheckField checkFieldMin1Number = field -> {
            boolean res = field.matches("");
            if (! res) {
                messageError = "Password should contains a number!";
            }
            return true;
        };
        if ( ! checkFieldMin1Number.isCorrect(password)) {
            return false;
        }

        return true;
    }
}
