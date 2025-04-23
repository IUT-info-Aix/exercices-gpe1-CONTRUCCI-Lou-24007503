package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Random;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane grille = new GridPane();
        Random random = new Random();

        String[] image = {
                "exercice2/Vide.png",
                "exercice2/Croix.png",
                "exercice2/Rond.png"
        };

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int index = random.nextInt(3);
                ImageView imageView = new ImageView(new Image(image[index]));
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);

                Label label = new Label();
                label.setGraphic(imageView);
                label.setStyle("-fx-border-color: gray; -fx-border-width: 1;");

                grille.add(label, col, row);
            }
        }

        Scene scene = new Scene(grille);
        primaryStage.setResizable(false);
        primaryStage.setScene( scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.show();
    }
}

