package calculatricenpi.View;

import javafx.application.Application;
import javafx.geometry.Pos ;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
public class CalculatorGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Conteneur principal
        VBox fenetre = new VBox(); // VBox principale qui va representer la fenêtre et qui va contenir la HBox et la VBox
        fenetre.setStyle("-fx-background-color: gray;");
        VBox vboxResultat = new VBox(); // VBox qui va contenir les 5 HBox qui affichent les résulats
        Label label = new Label("52");
        Label label1 = new Label("40");
        Label label2 = new Label("700");
        Label label3 = new Label("800");
        Label label4 = new Label("900");
        HBox hbox1 = new HBox(label);
        hbox1.setAlignment(Pos.CENTER_RIGHT);
        hbox1.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        HBox hbox2 = new HBox(label1);
        hbox2.setAlignment(Pos.CENTER_RIGHT);
        hbox2.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        HBox hbox3 = new HBox(label2);
        hbox3.setAlignment(Pos.CENTER_RIGHT);
        hbox3.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        HBox hbox4 = new HBox(label3);
        hbox4.setAlignment(Pos.CENTER_RIGHT);
        hbox4.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        HBox hbox5 = new HBox(label4);
        hbox5.setAlignment(Pos.CENTER_RIGHT);
        hbox5.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        HBox hboxBas = new HBox(); // HBox qui contient la GridPane de Button et la VBox des opérateurs

       


        vboxResultat.setSpacing(3);
        vboxResultat.getChildren().addAll(hbox1,hbox2,hbox3,hbox4, hbox5);
    
        // Initialiser les boutons des chiffres
        Button[] listButtonChiffres = new Button[12];
        for (int i = 0; i <= 9; i++) { // Seulement 10 boutons pour les chiffres 0-9
            listButtonChiffres[i] = new Button(String.valueOf(i));
        }
        
        listButtonChiffres[10] = new Button(","); // Pour la virgule décimale
        listButtonChiffres[11] = new Button("+/-"); // Pour la remise à zéro
        listButtonChiffres[11].setStyle("-fx-background-color :gray ; -fx-border-color : black ; -fx-border-width : 1px;");
        
    
        // Initialiser les boutons des signes
        Button[] listButtonSignes = new Button[5];
        String [] signes = {"+", "-", "*", "/", "<>"};
        for (int i = 0; i < 5; i++) {
            listButtonSignes[i] = new Button(signes[i]);
        }
        
        // Créer la grille pour les chiffres
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
       
        int buttonIndex = 0;


        gridPane.add(listButtonChiffres[7],0,0);
        gridPane.add(listButtonChiffres[8],1,0);
        gridPane.add(listButtonChiffres[9],2,0);
        gridPane.add(listButtonChiffres[4],0,1);
        gridPane.add(listButtonChiffres[5],1,1);
        gridPane.add(listButtonChiffres[6],2,1);
        gridPane.add(listButtonChiffres[1],0,2);
        gridPane.add(listButtonChiffres[2],1,2);
        gridPane.add(listButtonChiffres[3],2,2);
        gridPane.add(listButtonChiffres[0],0,3);
        gridPane.add(listButtonChiffres[10],1,3);
        gridPane.add(listButtonChiffres[11],2,3);
        
       
            
        
    
        // Créer la VBox pour les signes
        VBox vboxOperateur = new VBox(5); // Ajout d'un espacement entre les boutons
        vboxOperateur.getChildren().addAll(listButtonSignes);
        vboxOperateur.setPadding(new Insets(10, 0, 10, 0));

        hboxBas.setSpacing(5);// Espace horizontal entre les élements de la HBox
        hboxBas.getChildren().addAll(gridPane , vboxOperateur);

    
        // Ajouter les éléments au conteneur principal
        fenetre.getChildren().addAll(vboxResultat , hboxBas);

    
        // Configurer la scène et le stage
        Scene scene = new Scene(fenetre, 300, 290); // J'ai ajusté les dimensions pour plus d'espace
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculatrice NPI");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    

    public  void startGui(String[] args) {
        launch(args);
    }
}
