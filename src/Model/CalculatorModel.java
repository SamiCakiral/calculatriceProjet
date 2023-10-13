package Model;

public class CalculatorModel implements CalculatorModelInterface{

	@Override
	public int add(int nombre1, int nombre2) {
		return nombre1 + nombre2;
	}
	@Override
	public int sub(int nombre1, int nombre2) {
		return nombre1 - nombre2;
	}
	@Override
	public int multiply(int nombre1, int nombre2) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'multiply'");
	}
	@Override
	public int divide(int nombre1, int nombre2) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'divide'");
	}
	@Override
	public int opposite(int nombre1) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'opposite'");
	}
	@Override
	public void push(String element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'push'");
	}
	@Override
	public String pop() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'pop'");
	}
	@Override
	public void drop() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'drop'");
	}
	@Override
	public void swap() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'swap'");
	}
	

}
