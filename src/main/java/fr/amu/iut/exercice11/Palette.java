package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private IntegerProperty nbFois;
    private StringProperty message;


    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        nbFois = new SimpleIntegerProperty(0);
        message = new SimpleStringProperty();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(600, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        vert.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: green;");
            nbVert = nbVert + 1;
            nbFois.set(nbFois.get() + 1);
            texteDuHaut.setText(String.format("Total de clic %d -Vert choisi %d fois", nbFois.get(), nbVert));
            message.set("Vert choisi ");
            vert.setText(message.get());
        });

        rouge.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: red;");
            nbRouge = nbRouge + 1;
            nbFois.set(nbFois.get() + 1);
            texteDuHaut.setText(String.format("Total de clic %d -Rouge choisi %d fois",nbFois.get() , nbRouge));
            message.set("Rouge choisi ");
            rouge.setText(message.get());
        });

        bleu.setOnAction(event -> {
            panneau.setStyle("-fx-background-color: blue;");
            nbBleu = nbBleu + 1;
            nbFois.set(nbFois.get() + 1);
            texteDuHaut.setText(String.format("Total de clic %d -Bleu choisi %d fois",nbFois.get() , nbBleu));
            message.set("Bleu choisi ");
            bleu.setText(message.get());
        });

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

