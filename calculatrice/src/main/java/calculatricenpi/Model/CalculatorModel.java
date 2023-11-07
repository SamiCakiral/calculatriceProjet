package calculatricenpi.Model;
import java.util.Stack ;


public class CalculatorModel implements CalculatorModelInterface{

    private String accu = "" ;
	private Stack<Double> pile = new Stack<Double>() ;

	/**
	 * Setter pour l'accu
	 * 
	 * @param accu
	 */
	public void setAccu(String accu) {
		this.accu += accu;
	}
	/**
	 * Getter pour l'accu
	 * 
	 * @return
	 */
	public String getAccu() {
		return accu;
	}

	/**
	 * Retourne la taille de la pile (fonction privée et utile pour les fonctions dans le modèle)
	 * 
	 * @return la taille de la pile
	 */
	private int taillePile() {
		return pile.size();
	}

	/**
	 * Ajoute deux éléments de la pile et ajoute le résultat à la pile.
	 *
	 * @return         	Aucune valeur de retour
	 */	
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

	/**
	 * Soustrait deux éléments de la pile et ajoute le résultat à la pile.
	 *
	 * @return         	Aucune valeur de retour
	 */
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

	/**
	 * Multiplie deux éléments de la pile et ajoute le résultat à la pile.
	 *
	 * @return         	Aucune valeur de retour
	 */
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

	/**
	 * Divise deux éléments de la pile et ajoute le résultat à la pile.
	 *
	 * @return         	Aucune valeur de retour
	 */
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

	/**
	 * Change le signe de l'élément au sommet de la pile.
	 *
	 * @return         	Aucune valeur de retour
	 */
	@Override
	public void opposite() {
		if (taillePile() < 1) {
			System.out.println("Pas assez d'éléments dans la pile");
			return;
		}
		double nombre1 = pile.pop();
		pile.add( - nombre1);
	}

	/**
	 * Ajoute un élément sur la pile. (L'élément est l'accu, on le convertit en double et on l'ajoute à la pile)
	 *
	 * @return         	Aucune valeur de retour
	 */
	@Override
	public void push() {
		if (accu.isEmpty()) {
			System.out.println("Pas de valeur dans l'accu");
			return;
		}
		
		// Si on a mis 2 virgules dans l'accu, on ne prend en compte que la première
		if (accu.indexOf(",") != accu.lastIndexOf(",")) {
			accu = accu.substring(0, accu.indexOf(",", accu.indexOf(",") + 1));
		}
		
		try {
			pile.push(Double.parseDouble(accu.replace(",", "."))); // Remplacer la virgule par un point pour la conversion
		} catch (NumberFormatException e) {
			System.out.println("Format de l'accu invalide");
			return;
		}
		
		accu = ""; // On vide l'accu pour le prochain nombre
	}
	
	/**
	 * Retourne l'élément au sommet de la pile.
	 *
	 * @return         	Le sommet de la pile
	 */
	@Override
	public double pop() {
		if (accu == "") {
			System.out.println("Pas de valeur dans l'accu");
			return 0;
		}
		return pile.pop() ;
	}

	/**
	 * Supprime l'élément au sommet de la pile.
	 *
	 * @return         	Aucune valeur de retour
	 */
	@Override
	public void drop() {
		if (taillePile() < 1) {
			System.out.println("Pas assez d'éléments dans la pile");
			return;
		}
		pile.pop();
	}

	/**
	 * Echange les deux éléments au sommet de la pile.
	 *
	 * @return         	Aucune valeur de retour
	 */
	@Override
	public void swap() {

		if (taillePile() < 2) {
			System.out.println("Pas assez d'éléments dans la pile");
			return;
		}
		double a = pile.pop(); ;
		
		double b = pile.pop(); ;

		pile.add(a);
		pile.add(b);
	}

	/**
	 * Vide la pile.
	 *
	 * @return         	Aucune valeur de retour
	 */
	public void clear() {
		if (taillePile() < 1) {
			System.out.println("Pas assez d'éléments dans la pile");
			return;
		}
		pile.clear();
	}

	/**
	 * Retourne l'élément au sommet de la pile sans le supprimer de la pile.
	 *
	 * @return         	Le sommet de la pile
	 */
	public double top() {
		double top = pile.pop();
		pile.push(top);
		return top;
	}
	

}