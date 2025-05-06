package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import java.io.File;
import java.util.ArrayList;

public class IHMPendu extends Application {

    private Label labelVie;
    private Label labelMot;
    private VBox root;
    private int vieRestante = 7;
    private ImageView imagependu;
    private Dico dico = new Dico();
    private GridPane lettresGrid = new GridPane();
    private String motATrouver;
    private char[] motCache;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        root = new VBox(5);

        //nombre de vie avec image y faire une boucle
        imagependu = new ImageView(new Image(getClass().getResourceAsStream("/exercice6/pendu7.png")));
//        String pendu7 = "exercice6/pendu7.png";
//        ImageView imagependu = new ImageView(pendu7);
        labelVie = new Label("Nombre de vie restente :" + vieRestante );

        //mot a chercher
        motATrouver = dico.getMot();
        motCache = new char[motATrouver.length()];
        for (int i = 0; i < motCache.length; i++) motCache[i] = '*';
        labelMot = new Label(String.valueOf(motCache));

        //clavier
        creerTouches();

        root.getChildren().addAll( imagependu, labelVie, labelMot, lettresGrid);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ADD8E6 ;" ) ;
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    //permet de proposer une lettre
    private void creerTouches() {
        lettresGrid.getChildren().clear();
        lettresGrid.setHgap(5);
        lettresGrid.setVgap(5);
        lettresGrid.setAlignment(Pos.CENTER);

        int col = 0, row = 0;

        for (char c = 'A'; c <= 'Z'; c++) {
            Button btnLettre = new Button(String.valueOf(c));
            btnLettre.setOnAction(e -> {
                char lettreChoisie = btnLettre.getText().charAt(0);
                traiterTouches(lettreChoisie);
                btnLettre.setOpacity(0.5);
                btnLettre.setDisable(true);
            });
            btnLettre.setMinWidth(30);
            lettresGrid.add(btnLettre, col, row);
            col++;
            if (col == 9) {
                col = 0;
                row++;
            }
        }
    }

    private void traiterTouches(char lettreChoisie) {
        lettreChoisie = Character.toLowerCase(lettreChoisie);
        ArrayList<Integer> position = dico.getPositions(lettreChoisie, motATrouver);

        if (position.isEmpty()){
            vieRestante --;
            labelVie.setText("Nombre de vie restente :" + vieRestante);
            imagependu.setImage(new javafx.scene.image.Image("exercice6/pendu" + vieRestante + ".png"));
        }else{
            for(int pos : position){
                motCache[pos]= lettreChoisie;
            }
            labelMot.setText(String.valueOf(motCache));
        }

        if (vieRestante == 0 ){
            labelVie.setText("Perdu !! Le mot était : " + motATrouver);
        } else if (String.valueOf(motCache).equals(motATrouver)) {
            labelVie.setText("Gagné! Bravo !!");
            imagependu.setImage(new javafx.scene.image.Image("exercice6/penduWin.png"));
        }
    }
}
