package calculatricenpi.Model;
import java.util.Stack ;


import calculatricenpi.Controler.Controler;

public class CalculatorModel implements CalculatorModelInterface{

    private String accu = "" ;
	private Stack<Double> pile = new Stack<Double>() ;
	Controler controler;


	public void setAccu(String accu) {
		this.accu += accu;
	}
	public String getAccu() {
		return accu;
	}

	@Override
	public void add() {
		double nombre1 = pile.pop();
		double nombre2 = pile.pop();
		pile.add(nombre1 + nombre2);
			
	}
	@Override
	public void sub() {
		double nombre1 = pile.pop();
		double nombre2 = pile.pop();
		pile.add(nombre1 - nombre2);
		
	}
	@Override
	public void multiply() {
		double nombre1 = pile.pop();
		double nombre2 = pile.pop();
		pile.add(nombre1*nombre2);
	}
	@Override
	public void divide() {
		double nombre1 = pile.pop();
		double nombre2 = pile.pop();
		pile.add(nombre1/nombre2);
	}
	@Override
	public void opposite() {
		double nombre1 = pile.pop();
		pile.add( - nombre1);
	}
	@Override
	public void push() {
		pile.push(Double.parseDouble(accu));
		accu = ""; // On vide l'accu
	}
	@Override
	public double pop() {
		return pile.pop() ;
	}
	@Override
	public void drop() {
		pile.pop();
	}
	@Override
	public void swap() {

		double a = pile.elementAt(0) ;
		pile.pop();
		double b = pile.elementAt(0) ;
		pile.pop();
		pile.add(a);
		pile.add(b);
	}

	public void clear() {
		pile.clear();
	}
	public void setControler(Controler controler) {
		this.controler = controler;
	}
	public double top() {
		double top = pile.pop();
		pile.push(top);
		return top;
	}
	

}
