package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class LoginControl extends GridPane {

    @FXML
    private TextField user;
    @FXML
    private PasswordField pwd;

    @FXML
    private void okClicked() {
        System.out.println( "user Id : " + user.getText());

        String star = "*".repeat(pwd.getLength());
        System.out.println("Password : " + star);


    }
@FXML
    private void cancelClicked() {
        user.clear();
        pwd.clear();
    }
}