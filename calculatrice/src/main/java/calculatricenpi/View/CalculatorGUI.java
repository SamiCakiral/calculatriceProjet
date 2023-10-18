package calculatricenpi.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalculatorGUI extends Application implements CalculatorGUIInterface {

    @Override
    public void start(Stage primaryStage) {
        // Conteneur principal
        VBox stackPane = new VBox();
    
        // Initialiser les boutons des chiffres
        Button[] listButtonChiffres = new Button[12];
        for (int i = 0; i <= 9; i++) { // Seulement 10 boutons pour les chiffres 0-9
            listButtonChiffres[i] = new Button(String.valueOf(i));
        }
        listButtonChiffres[10] = new Button(","); // Pour la virgule décimale
        listButtonChiffres[11] = new Button("+/-"); // +/-
    
        // Initialiser les boutons des signes
        Button[] listButtonSignes = new Button[5];
        String [] signes = {"+", "-", "*", "/", "+/-"};
        for (int i = 0; i < 5; i++) {
            listButtonSignes[i] = new Button(signes[i]);
        }
        
        // Créer la grille pour les chiffres
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        int buttonIndex = 0;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 3; col++) {
                gridPane.add(listButtonChiffres[buttonIndex++], col, row);
            }
        }
    
        // Créer la VBox pour les signes
        VBox vbox1 = new VBox(10); // Ajout d'un espacement entre les boutons
        vbox1.getChildren().addAll(listButtonSignes);
        vbox1.setPadding(new Insets(10, 0, 10, 0));
    
        // Ajouter les éléments au conteneur principal
        stackPane.getChildren().addAll(gridPane, vbox1);

    
        // Configurer la scène et le stage
        Scene scene = new Scene(stackPane, 400, 400); // J'ai ajusté les dimensions pour plus d'espace
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculatrice NPI");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    

    public  void startGui(String[] args) {
        launch(args);
    }


    @Override
    public void affiche() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'affiche'");
    }


    @Override
    public void change(String accu) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'change'");
    }


    @Override
    public void change(double[] stackData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'change'");
    }
}
