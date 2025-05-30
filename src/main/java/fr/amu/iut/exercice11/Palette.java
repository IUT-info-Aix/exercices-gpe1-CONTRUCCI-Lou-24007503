package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
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
    private StringProperty ecritDuHaut;
    private StringProperty couleurPanneau;

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        nbFois = new SimpleIntegerProperty(0);
        message = new SimpleStringProperty();
        ecritDuHaut = new SimpleStringProperty();
        couleurPanneau = new SimpleStringProperty("#000000");
        texteDuHaut = new Label();
        texteDuBas = new Label();

        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(600, 200);

        createBinding();

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));

        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        vert.setOnAction(event -> {
            couleurPanneau.set( "#008020");
            nbVert = nbVert + 1;
            nbFois.set(nbFois.get() + 1);
            ecritDuHaut.set(String.format("- Vert choisi %d fois",  nbVert));
            message.set("Vert");
            vert.setText(message.get());
        });

        rouge.setOnAction(event -> {
            couleurPanneau.set("#BB0B0B");
            nbRouge = nbRouge + 1;
            nbFois.set(nbFois.get() + 1);
            ecritDuHaut.set(String.format("- Rouge choisi %d fois" , nbRouge));
            message.set("Rouge");
            rouge.setText(message.get());
        });

        bleu.setOnAction(event -> {
            couleurPanneau.set("#0080FF");
            nbBleu = nbBleu + 1;
            nbFois.set(nbFois.get() + 1);
            ecritDuHaut.set(String.format("- Bleu choisi %d fois" , nbBleu));
            message.set("Bleu");
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

    private void createBinding(){
        panneau.styleProperty().bind(Bindings.concat ("-fx-background-color: ", couleurPanneau, ";"));

        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty(false);
        pasEncoreDeClic.bind(Bindings.equal(nbFois, 0));

        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClic)
                .then("Cliquez sur un bouton !")
                .otherwise(Bindings.concat("Total de clics : ", " ",  nbFois,ecritDuHaut)));

        texteDuBas.textProperty().bind(Bindings.when(pasEncoreDeClic).then(" ")
                .otherwise(Bindings.concat(message, " est une joli couleur !")));
        texteDuBas.styleProperty().bind(Bindings.concat("-fx-text-fill: ", couleurPanneau, ";"));

    }
}