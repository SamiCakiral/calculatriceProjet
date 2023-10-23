package calculatricenpi.View;

import java.util.Stack;

import calculatricenpi.Controler.Controler;
import calculatricenpi.Model.CalculatorModel;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CalculatorGUI extends Application implements CalculatorGUIInterface {
    
    private Label[] labelResultats;
    String displayString = "";
  
    
    
    @Override
    public void start(Stage primaryStage) {

        CalculatorModel model = new CalculatorModel();
        Controler controler = new Controler(model, this); // Utilisez "this" pour la vue
        model.setControler(controler);

         // Conteneur principal

        VBox fenetre = initFenetre();
  

        this.labelResultats = new Label[] { new Label(""), new Label(""), new Label(""), new Label(""), new Label("") };
        // Sami : J'ai remplacé la définition des labels un par un par une liste de
        // label vide, qu'on poura par la suite traiter en tant que liste
        // Ca sera plus simple pour la manipulation de chaque label par la suite

        VBox vboxResultat = initVboxResultats(labelResultats); // VBox qui va contenir les 5 labels qui affichent les résulats
        // on envoie la liste de label vide à la fonction initVboxResultats, qui va les placer et les linker avec le model

        // Initialiser les boutons des chiffres
        Button[] listButtonChiffres = initBoutonsChiffres();

        // Initialiser les boutons des signes
        Button[] listButtonSignes = initBoutonsSignes();

        // Créer la grille pour les chiffres
        GridPane gridPane = initBoutons(listButtonChiffres, listButtonSignes);

        initActionListener(listButtonChiffres, listButtonSignes);

        // Ajouter les éléments au conteneur principal
        fenetre.getChildren().addAll(vboxResultat, gridPane);

        // Configurer la scène et le stage
        Scene scene = new Scene(fenetre);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculatrice NPI");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void initActionListener(Button[] listButtonChiffres, Button[] listButtonSignes) {
        for (int i = 0; i < listButtonChiffres.length; i++) {
            int finalI = i; // definie finalI pour pouvoir l'utiliser dans le lambda (sinon on a une erreur : variable i is accessed from within inner class, needs to be final or effectively final)
            listButtonChiffres[i].setOnAction(e -> {
                String buttonValue = listButtonChiffres[finalI].getText();
                Controler.nombreAppuyee(buttonValue);
                System.out.println(buttonValue); // Affiche la valeur du bouton dans la console
            });// pour chaque bouton : quand on clique dessus, on appelle la fonction change avec le chiffre correspondant
        }

        listButtonSignes[0  ].setOnAction(e -> {
            Controler.addition();
        });
        listButtonSignes[1  ].setOnAction(e -> {
            Controler.soustraction();
        });
        listButtonSignes[2  ].setOnAction(e -> {
            Controler.multiplication();
        });
        listButtonSignes[3  ].setOnAction(e -> {
            Controler.division();
        });
        listButtonSignes[4 ].setOnAction(e -> {
            Controler.push();
        });
        listButtonChiffres[ 11 ].setOnAction(e -> {
            Controler.negation();
        });

        
    }

    public Button [] initBoutonsChiffres(){
        Button [] listButtonChiffres = new Button[12];
        for (int i = 0; i <= 9; i++) { // Seulement 10 boutons pour les chiffres 0-9
           
            listButtonChiffres[i] = new Button(String.valueOf(i));
            listButtonChiffres[i].setMinSize(50, 50); // Taille minimale des boutons
             // pour chaque bouton : quand on clique dessus, on appelle la fonction change avec le chiffre correspondant
        }

        listButtonChiffres[10] = new Button(","); // Pour la virgule décimale
        listButtonChiffres[10].setMinSize(50, 50);
        listButtonChiffres[11] = new Button("+/-"); // Pour la remise à zéro
        listButtonChiffres[11].setMinSize(50, 50);
        return listButtonChiffres;
    }

    public Button [] initBoutonsSignes(){
        Button[] listButtonSignes = new Button[5];
        String[] signes = { "+", "-", "*", "/", "<>" };
        for (int i = 0; i < 5; i++) {
            listButtonSignes[i] = new Button(signes[i]);
            listButtonSignes[i].setMinSize(50, 50); // Taille minimale des boutons
        }
        listButtonSignes[4].setMinSize(180, 50);
        listButtonSignes[4].setMaxWidth(Double.MAX_VALUE); // Le bouton prendra toute la largeur disponible

        return listButtonSignes;
    }
    public VBox initVboxResultats(Label [] labelResultats) {
        VBox vboxResultat = new VBox(5); // VBox qui va contenir les 5 HBox qui affichent les résulats
        vboxResultat.setPadding(new Insets(10, 10, 10, 10));
        vboxResultat.setAlignment(Pos.CENTER); // Aligner les résultats à droite

        for (Label labelResult : labelResultats) {
            VBox.setMargin(labelResult, new Insets(0, 0, 0, 0));
            labelResult.setAlignment(Pos.CENTER_RIGHT);
            labelResult.setMinWidth(230); // Assure une largeur minimale pour les labels
            labelResult.setPadding(new Insets(5, 15, 5, 10)); // Espacement interne pour chaque label
            labelResult.setStyle("-fx-border-color: black; -fx-background-color: white;"); // Bordure et couleur de fond
                                                                                           // pour chaque label
            vboxResultat.getChildren().add(labelResult);
        } // On peut déja tous les ajouter un par un a la vBox au lieux de faire une hBox
          // par label puis de les ajouter un par un ca revien au même mais c'est plus lisible

        vboxResultat.setSpacing(3);
        return vboxResultat;
    }
    public VBox initFenetre() {
        VBox fenetre = new VBox(5); // VBox principale qui va representer la fenêtre et qui va contenir la HBox et
                                    // la VBox
        fenetre.setPadding(new Insets(10)); // Marge globale pour l'interface

        return fenetre;
    }

    public GridPane initBoutons(Button[] listButtonChiffres, Button[] listButtonSignes) {

        // Créer la grille pour les chiffres
        GridPane gridPaneBoutons = new GridPane();
        gridPaneBoutons.setPadding(new Insets(10, 10, 10, 10));
        gridPaneBoutons.setHgap(5);
        gridPaneBoutons.setVgap(5);

        int[][] layoutChiffres = {
                { 7, 8, 9 },
                { 4, 5, 6 },
                { 1, 2, 3 }
        };
        // On fait une liste avec un layout qu'on va suivre, c'est mieux que je placer
        // tout les boutons a la main
        for (int row = 0; row < layoutChiffres.length; row++) {
            for (int col = 0; col < layoutChiffres[row].length; col++) {
                int buttonIndex = layoutChiffres[row][col];
                gridPaneBoutons.add(listButtonChiffres[buttonIndex], col, row);
            }

            gridPaneBoutons.add(listButtonSignes[row], 4, row); // Ajout du signe après les chiffres
        }

        // Ajout de la dernière ligne qui est spécifique
        gridPaneBoutons.add(listButtonChiffres[10], 0, 3);
        gridPaneBoutons.add(listButtonChiffres[0], 1, 3);
        gridPaneBoutons.add(listButtonChiffres[11], 2, 3);
        gridPaneBoutons.add(listButtonSignes[3], 4, 3);
        gridPaneBoutons.add(listButtonSignes[4], 0, 4, 5, 1); // Commence à la colonne 0, ligne 4, s'étend sur 4
                                                              // colonnes et 1 ligne

        return gridPaneBoutons;
    }

   
    public void push(){
        Controler.push();
    }

    public void startGui(String[] args) {
        launch(args);

    
    }

    

    @Override
    public void affiche() {
        
        /*labelResultats[4].setText(displayString);

        labelResultats[3].setText(String.valueOf());
    */}

        
    @Override
    public void change(String accu) {
        displayString = accu ;
        labelResultats[4].setText(accu);
    }

    @Override
    public void change(double[] stackData) {
        for (int i = 3;i<0;i--){
            labelResultats[i].setText(String.valueOf(stackData[i]));
        }
       
        
    }


}
