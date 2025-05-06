package fr.amu.iut.exercice10;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ConteneursController {

    @FXML
    private TextField nom;
    @FXML
    private PasswordField pwd;
    @FXML
    private TextField email;
    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private void okClicked() {
        System.out.println( "Nom : " + nom.getText());
        System.out.println( "Email: " + email.getText());
        String star = "*".repeat(pwd.getLength());
        System.out.println("Password : " + star);

    }
    @FXML
    private void cancelClicked() {
        nom.clear();
        email.clear();
        pwd.clear();
    }
    @FXML
    private void fermer(ActionEvent event) {
        Stage stage = (Stage) closeMenuItem.getParentPopup().getOwnerWindow();;
        stage.close();
    }

}
