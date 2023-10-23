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
        

        // Test
        int nombre11 = 5;
        int nombre12 = 2;
        int nombre2 = 3;
        String op = "-";

        model.setAccu(String.valueOf(nombre11));
        model.setAccu(String.valueOf(nombre12));
        model.push();
        model.setAccu(String.valueOf(nombre2));
        model.push();

        if (op.equals("+"))
            model.add();
        else if (op.equals("-"))
            model.sub();
        else if (op.equals("*"))
            model.multiply();
        else if (op.equals("/"))
            model.divide();
        else if (op.equals("neg"))
            model.opposite();
        System.out.println(model.pop());

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
        updateView();
    }

    public static void soustraction() {
        model.sub();
        updateView();
    }

    public static void multiplication() {
        model.multiply();
        updateView();
    }

    public static void division() {
        model.divide();
        updateView();
    }

    public static void nombreAppuyee(String n) {
        model.setAccu(n);
        
       
        
        updateView();
    }

    public static void push() {
        stackData[0] = model.top();

        for (int i = 4; i < 0;i--){
            stackData[i] = stackData[i+1];
        }
        model.push();
        updateView();
    }

    public static void negation()
    {
        model.opposite();
        updateView();
    }

    private static void updateView() {
        gui.change(model.getAccu());
    }

}
