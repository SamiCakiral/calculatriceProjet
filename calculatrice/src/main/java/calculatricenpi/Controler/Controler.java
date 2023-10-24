package calculatricenpi.Controler;

import calculatricenpi.Model.CalculatorModel;
import calculatricenpi.View.CalculatorGUI;

public class Controler implements ControlerInterface {

public static CalculatorModel model;
public static CalculatorGUI gui;
public static double [] stackData;
 
public Controler(CalculatorModel model, CalculatorGUI gui) {
    this.model = model;
    this.gui = gui;
   
    
}
    
 
    public static void main(String[] args) {

        model = new CalculatorModel();
        gui = new CalculatorGUI();
        gui.startGui(args);
       
    }

    @Override
    public void change(String accu) {
        model.setAccu(accu);
        
    }

    @Override
    public void change(double[] stackData) {

        gui.change(stackData);

    }

    public static void addition() {
        model.add();
        for (int i = 0; i < 3; i++) {
            stackData[i] = stackData[i+1];
        }
        
        // Mettre à jour le dernier élément avec la valeur de l'accu (ou tout autre source)
        stackData[3] = model.top();

        updateView();
    }

    public static void soustraction() {
        model.sub();
        for (int i = 0; i < 3; i++) {
            stackData[i] = stackData[i+1];
        }
        
        // Mettre à jour le dernier élément avec la valeur de l'accu (ou tout autre source)
        stackData[3] = model.top();
        updateView();
    }

    public static void multiplication() {
        model.multiply();
        for (int i = 0; i < 3; i++) {
            stackData[i] = stackData[i+1];
        }
        
        // Mettre à jour le dernier élément avec la valeur de l'accu (ou tout autre source)
        stackData[3] = model.top();
        updateView();
    }

    public static void division() {
        model.divide();
        for (int i = 0; i < 3; i++) {
            stackData[i] = stackData[i+1];
        }
        
        // Mettre à jour le dernier élément avec la valeur de l'accu (ou tout autre source)
        stackData[3] = model.top();
        updateView();
    }

    public static void swap() {
        model.swap();
        
        
        double temp = stackData[3];
        stackData[3] = stackData[2];
        stackData[2] = temp;
        updateView();
    }
    public static void nombreAppuyee(String n) {
        model.setAccu(n);
        updateView();
    }

    public static void clear() {
        model.clear();
        for (int i = 0; i < 4; i++) {
            stackData[i] = 0;
        }
        updateView();
    }
    public static void push() {
        
        model.push();
        
        for (int i = 0; i < 3; i++) {
            stackData[i] = stackData[i+1];
        }
        
        // Mettre à jour le dernier élément avec la valeur de l'accu (ou tout autre source)
        stackData[3] = model.top();


        
        updateView();
    }

    public static void negation()
    {
        model.opposite();
        stackData[3] = model.top();
        updateView();
    }

    private static void updateView() {
        gui.change(model.getAccu());
        gui.change(stackData);
    }

}