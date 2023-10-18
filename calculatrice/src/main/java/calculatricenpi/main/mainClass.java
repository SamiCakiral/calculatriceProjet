package calculatricenpi.main;

import calculatricenpi.Model.CalculatorModel;

public class mainClass {

    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        // bufferreader for input
        int nombre11 = 5;
        int nombre12 = 2;
        int nombre2 = 3;
        String op = "-";
        
        model.setAccu(String.valueOf(nombre11));
        model.setAccu(String.valueOf(nombre12));
        model.push();
        model.setAccu(String.valueOf(nombre2));
        model.push();
        if (op.equals("+")) model.add();
        else if (op.equals("-")) model.sub();
        else if (op.equals("*")) model.multiply();
        else if (op.equals("/")) model.divide();
        else if (op.equals("neg")) model.opposite();
        System.out.println(model.pop());
        
    }
}
