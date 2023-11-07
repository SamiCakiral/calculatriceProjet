package calculatricenpi.Controler;

import calculatricenpi.Model.CalculatorModel;
import calculatricenpi.View.CalculatorGUI;

public class Controler implements ControlerInterface {

    private double[] stackData;
    private CalculatorModel model;
    private CalculatorGUI gui;

    /**
     * Getter les données de la pile.
     *
     * @return  les données de la pile sous forme d'un tableau de doubles
     */
    public double [] getStackData() {
        return this.stackData;
    }

    /**
     * Setter des données de la pile pour la fonction.
     *
     * @param  stackData  un tableau de valeurs double représentant les données de la pile
     */    
    public void setStackData(double [] stackData) {
        this.stackData = stackData;
    }

    /**
     * Main : lance l'application. en démarant la GUI.
     *
     */
    public static void main(String[] args) {
        CalculatorGUI.launch(CalculatorGUI.class, args);
    }

    /**
     * Définit le modèle de la calculatrice.
     *
     * @param  model  le modèle de la calculatrice
     */
    public Controler(CalculatorGUI gui, CalculatorModel model) {
        this.gui = gui;
        this.model = model;

        this.stackData = new double[5];
        
        
        for (int i = 0; i < 5; i++){
            this.stackData[i] = 0;
        }
    }

    /**
     * Met à jour la vue du dernier affichage.
     * 
     * @param  accu  la valeur de l'accumulateur
     */
    @Override
    public void change(String accu) {
        model.setAccu(accu);
    }
    
    /**
     * Met à jour la vue.
     * 
     * @param  stackData  les données de la pile
     */
    @Override
    public void change(double[] stackData) {

        gui.change(stackData);

    }

    /**
     * Met à jour la vue pour dessendre les elements de la pile qui sont pas encore utilisé.
     * et supprime les elements déja utilisé.
     * 
     * @param  stackData  les données de la pile
     */
    public void updateAffiche() {
        for (int i = 2; i > 0; i--) {
            stackData[i] = stackData[i - 1];
        }

        stackData[0] = 0;

        // Mettre à jour le dernier élément avec la valeur de l'accu (ou tout autre
        // source)

        stackData[3] = model.top();
    }

    /**
     * Effectue l'opération de soustraction dans la pile. 
     * (bouton + sur la gui)
     * 
     * @param  None   Aucun paramètre
     * @return        Aucune valeur de retour
     */
    public  void addition() {
        model.add();

        updateAffiche();
        updateView();
    }
    
    /**
     * Effectue l'opération de soustraction dans la pile.
     * (bouton - sur la gui)
     * 
     * @param  Aucun     Aucun paramètre requis.
     * @return Aucun     Aucune valeur de retour.
     */    
    public void soustraction() {
        model.sub();
        updateAffiche();
        updateView();
    }

    /**
     * Effectue l'opération de multiplication dans la pile.
     * (bouton * sur la gui)
     * 
     * @param  None  Aucun paramètre requis.
     * @return       Aucune valeur de retour.
     */    
    public void multiplication() {
        model.multiply();
        updateAffiche();
        updateView();
    }

    /**
     * Effectue l'opération de division dans la pile.
     * (bouton / sur la gui)
     * 
     * @param  None  Aucun paramètre requis.
     * @return       Aucune valeur de retour.
     */
    public void division() {
        model.divide();
        updateAffiche();
        updateView();
    }

    /**
     * Effectue l'opération du swap de deux elements de la pile et dans l'affichage.
     * (bouton ⇅ sur la gui)
     * @param  None  Aucun paramètre requis.
     * @return       Aucune valeur de retour.
     */
    public void swap() {
        model.swap();

        double temp = stackData[3];
        stackData[3] = stackData[2];
        stackData[2] = temp;
        updateView();
    }

    /**
     * Enregistre le nombre appuyé sur l'interface graphique et met à jour l'affichage.
     * (bouton 0-9 sur la gui)
     * 
     * @param  n  Le nombre appuyé par l'interface graphique.
     * @return    Aucune valeur de retour.
     */
    public void nombreAppuyee(String n) {
        model.setAccu(n);
        updateView();
    }

    /**
     * Efface les données dans le modèle et initialise tous les éléments du tableau stackData à 0.
     * Met à jour la vue pour refléter les changements.
     * (bouton C sur la gui)
     *
     * @param  None	Aucun paramètre requis.
     * @return         	Aucune valeur de retour.
     */    
    public void clear() {
        model.clear();
        for (int i = 0; i < 4; i++) {
            stackData[i] = 0;
        }
        updateView();
    }

    /**
     * Effectue l'opération de push sur le model. 
     * (Bouton <> sur la gui)
     *
     * @param  None  Aucun paramètre requis.
     * @return       Aucune valeur de retour.
     */
    public void push() {

        model.push();

        for (int i = 0; i < 3; i++) {
            stackData[i] = stackData[i + 1];
        }

        // Mettre à jour le dernier élément avec la valeur de l'accu (ou tout autre
        // source)
        stackData[3] = model.top();

        updateView();
    }

    /**
     * Effectue l'opération de negation sur le model. 
     * (Bouton +/- sur la gui)
     *
     * @param  None  Aucun paramètre requis.
     * @return       Aucune valeur de retour.
     */
    public void negation() {
        model.opposite();
        stackData[3] = model.top();
        updateView();
    }

    /**
     * Permet d'afficher les changements 
     * 
     * @param  None  Aucun paramètre requis.
     * @return       Aucune valeur de retour.
     */
    private void updateView() {
        gui.change(model.getAccu());
        gui.change(stackData);
    }

}