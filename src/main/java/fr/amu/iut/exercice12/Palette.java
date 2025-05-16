package fr.amu.iut.exercice12;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private Label texteDuHaut;

    private CustomButton vert;
    private CustomButton rouge;
    private CustomButton bleu;

    private CustomButton sourceOfEvent;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;
    private VBox bas;
    private Label texteDuBas;

    private EventHandler<ActionEvent> gestionnaireEvenement;

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma",FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);
        texteDuBas = new Label();

        panneau = new Pane();
        panneau.setPrefSize(400,200);

        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10,5,10,5));

        bas = new VBox();
        bas.getChildren().addAll(boutons, texteDuBas);
        bas.setAlignment(Pos.CENTER_RIGHT);

        vert = new CustomButton("Vert", "#31BCA4");
        rouge = new CustomButton("Rouge", "#F21411");
        bleu = new CustomButton("Bleu", "#3273A4");

        gestionnaireEvenement = (event) -> {
            sourceOfEvent = (CustomButton) event.getSource();
            sourceOfEvent.setNbClics(sourceOfEvent.getNbClics() + 1);

        };
        ChangeListener<Number> nbClicsListener = (observable, oldValue, newValue) -> {
            CustomButton bouton = null;

            if (observable == vert.nbClicsProperty()) {
                bouton = vert;
            } else if (observable == rouge.nbClicsProperty()) {
                bouton = rouge;
            } else if (observable == bleu.nbClicsProperty()) {
                bouton = bleu;
            }

            if (bouton != null) {
                panneau.setStyle("-fx-background-color: " + bouton.getCouleur() + ";");
                texteDuHaut.setText(
                        bouton.getText() + " choisi " + bouton.getNbClics() + " fois"
                );
            }
        };
        vert.nbClicsProperty().addListener(nbClicsListener);
        rouge.nbClicsProperty().addListener(nbClicsListener);
        bleu.nbClicsProperty().addListener(nbClicsListener);

        vert.setOnAction(gestionnaireEvenement);
        rouge.setOnAction(gestionnaireEvenement);
        bleu.setOnAction(gestionnaireEvenement);

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(boutons);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

