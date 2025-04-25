package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        //menubar
        BorderPane root = new BorderPane();
        VBox topmenu = new VBox();
        Menu BtnFile = new Menu("File");
        Menu BtnEdit = new Menu("Edit");
        Menu BtnHelp = new Menu("Help");
        MenuItem BtnFileN = new MenuItem("New");
        MenuItem BtnFileO = new MenuItem("Open");
        MenuItem BtnFileS = new MenuItem("Save");
        MenuItem BtnFileC = new MenuItem("Close");
        MenuItem BtnEditC = new MenuItem("cut");
        MenuItem BtnEditCp = new MenuItem("copy");
        MenuItem BtnEditP = new MenuItem("Past");
        BtnFile.getItems().addAll(BtnFileN,BtnFileO,BtnFileS,BtnFileC);
        BtnEdit.getItems().addAll(BtnEditC,BtnEditCp,BtnEditP);
        MenuBar topMenu = new MenuBar(BtnFile,BtnEdit,BtnHelp);
        Separator separator = new Separator(Orientation.HORIZONTAL);
        topmenu.getChildren().addAll(topMenu, separator);
        root.setTop(topmenu);

        //boutton de gauche
        VBox millieux = new VBox(6);
        Text text = new Text("Bouton");
        Button un = new Button("Bouton 1");
        Button deux = new Button("Bouton 2");
        Button trois = new Button("Bouton 3");
        millieux.getChildren().addAll(text, un, deux, trois);
        millieux.setAlignment(Pos.CENTER);

        HBox hb = new HBox();
        Separator separator1 = new Separator(Orientation.VERTICAL);
        hb.getChildren().addAll(millieux, separator1);
        root.setLeft(hb);

        //formulaire

        VBox centre = new VBox(8);
        GridPane grid = new GridPane();
        grid.add(new Text("Nom :"), 1, 4); // column=1 row=0
        grid.add(new TextField(), 3, 4);

        grid.add(new Text("Email :"), 1, 5); // column=1 row=0
        grid.add(new TextField(), 3, 5);

        grid.add(new Text("Password :"), 1, 6); // column=1 row=0
        grid.add(new TextField(), 3, 6);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        HBox btnb = new HBox(10);
        Button Sub = new Button("Submit");
        Button Can = new Button("Cancel");
        btnb.getChildren().addAll(Sub, Can);
        btnb.setAlignment(Pos.CENTER);

        centre.getChildren().addAll(grid, btnb);
        centre.setAlignment(Pos.CENTER);
        root.setCenter(centre);
//
//        HBox name = new HBox();
//        Text textN = new Text("Nom:");
//        TextField namebar = new TextField();
//        namebar.setMaxWidth(200);
//        name.getChildren().addAll(textN,namebar);
//
//        HBox email = new HBox();
//        Text textE = new Text("Email:");
//        TextField emailbar = new TextField();
//        emailbar.setMaxWidth(200);
//        email.getChildren().addAll(textE,emailbar);
//
//        HBox Passw = new HBox();
//        Text textPw = new Text("Password:");
//        TextField password = new TextField();
//        password.setMaxWidth(260);
//        Passw.getChildren().addAll(textPw,password);
//
//        centre.getChildren().addAll(name,email,Passw);
//        centre.setAlignment(Pos.CENTER);


        //label du bas
        VBox bas = new VBox();
        Label lab = new Label("Ceci est un labelde bas de page");
        bas.setAlignment(Pos.CENTER);
        Separator separator2 = new Separator(Orientation.HORIZONTAL);
        bas.getChildren().addAll(separator2, lab);
        root.setBottom(bas);

        Scene scene = new Scene(root, 650, 400);

        primaryStage.setScene( scene);
        primaryStage.setTitle("Premier exemple manipulant les conteurs");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

