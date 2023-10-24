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
	public int taillePile() {
		return pile.size();
	}
	@Override
	public void add() {
		if (taillePile() < 2) {
			System.out.println("Pas assez d'éléments dans la pile");
			return; // On quite la fonctino si on a pas assez d'leement pour eviter de crash
		}
		double nombre1 = pile.pop();
		double nombre2 = pile.pop();
		pile.add(nombre1 + nombre2);
			
	}
	@Override
	public void sub() {
		if (taillePile() < 2) {
			System.out.println("Pas assez d'éléments dans la pile");
			return;
		}
		double nombre1 = pile.pop();
		double nombre2 = pile.pop();
		pile.add(nombre2 - nombre1);
		
	}
	@Override
	public void multiply() {
		if (taillePile() < 2) {
			System.out.println("Pas assez d'éléments dans la pile");
			return;
		}
		double nombre1 = pile.pop();
		double nombre2 = pile.pop();
		pile.add(nombre1*nombre2);
	}
	@Override
	public void divide() {
		if (taillePile() < 2) {
			System.out.println("Pas assez d'éléments dans la pile");
			return;
		}
		double nombre1 = pile.pop();
		double nombre2 = pile.pop();
		if (nombre2 == 0){
			pile.push(nombre1);
			pile.push(nombre2);
			System.out.println("Division par 0 impossible");
			return;
		}
		pile.add(nombre2/nombre1);
	}
	@Override
	public void opposite() {
		if (taillePile() < 1) {
			System.out.println("Pas assez d'éléments dans la pile");
			return;
		}
		double nombre1 = pile.pop();
		pile.add( - nombre1);
	}
	@Override
	public void push() {
		if (accu == "") {
			System.out.println("Pas de valeur dans l'accu");
			return;
		}
		pile.push(Double.parseDouble(accu));
		accu = ""; // On vide l'accu
	}
	@Override
	public double pop() {
		if (accu == "") {
			System.out.println("Pas de valeur dans l'accu");
			return 0;
		}
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
		if (taillePile() < 1) {
			System.out.println("Pas assez d'éléments dans la pile");
			return;
		}
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