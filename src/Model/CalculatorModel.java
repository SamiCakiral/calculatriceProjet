package Model;
import java.util.Stack ;

public class CalculatorModel implements CalculatorModelInterface{

    private String accu = "" ;
	private Stack<Integer> pile = new Stack<Integer>() ;


	@Override
	public void add() {
		int nombre1 = pile.pop();
		int nombre2 = pile.pop();
		pile.add(nombre1 + nombre2);
			
	}
	@Override
	public void sub() {
		int nombre1 = pile.pop();
		int nombre2 = pile.pop();
		pile.add(nombre1 - nombre2);
		
	}
	@Override
	public void multiply() {
		int nombre1 = pile.pop();
		int nombre2 = pile.pop();
		pile.add(nombre1*nombre2);
	}
	@Override
	public void divide() {
		int nombre1 = pile.pop();
		int nombre2 = pile.pop();
		pile.add(nombre1/nombre2);
	}
	@Override
	public void opposite() {
		int nombre1 = pile.pop();
		pile.add( - nombre1);
	}
	@Override
	public void push() {
		pile.push(Integer.parseInt(accu));
		accu = ""; // On vide l'accu
	}
	@Override
	public int pop() {
		return pile.pop() ;
	}
	@Override
	public void drop() {
		pile.pop();
	}
	@Override
	public void swap() {

		int a = pile.elementAt(0) ;
		pile.pop();
		int b = pile.elementAt(0) ;
		pile.pop();
		pile.add(a);
		pile.add(b);
	}

	public void clear() {
		pile.clear();
	}
	

}
