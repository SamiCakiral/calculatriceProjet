package calculatricenpi.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CalculatorGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Création d'un bouton
        Button btn = new Button("Cliquez sur moi !");
        btn.setOnAction(event -> {
            System.out.println("Bouton cliqué !");
        });

        // Mise en place du bouton dans un layout
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        // Création de la scène et du stage
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Test JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void run(String[] args) {
        launch(args);
    }
}
