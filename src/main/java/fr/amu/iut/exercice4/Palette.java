package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        panneau = new Pane();
        root = new BorderPane();
        label = new Label("Choisissez une couleur");
        bas = new HBox(10); // espacement entre les boutons
        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        panneau.setStyle(String.format("-fx-background-color: %s;", Color.WHITE));
        root.setCenter(panneau);
        label.setAlignment(Pos.CENTER);
        root.setTop(label);


        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            panneau.setStyle("-fx-background-color: green;");
            nbVert = nbVert + 1;
            label.setText(String.format("Vert choisi %d fois", nbVert));
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            panneau.setStyle("-fx-background-color: red;");
            nbRouge = nbRouge + 1;
            label.setText(String.format("Rouge choisi %d fois", nbRouge));
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            panneau.setStyle("-fx-background-color: blue;");
            nbBleu = nbBleu + 1;
            label.setText(String.format("Bleu choisi %d fois", nbBleu));
        });

        bas.getChildren().addAll(vert, rouge, bleu);
        bas.setAlignment(Pos.BASELINE_CENTER);
        root.setBottom(bas);


        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene( scene);
        primaryStage.show();
    }
}

