package Model;

public interface CalculatorModelInterface {

    public int add(int nombre1, int nombre2);
    public int sub(int nombre1, int nombre2);
    public int multiply(int nombre1, int nombre2);
    public int divide(int nombre1, int nombre2);
    public int opposite(int nombre1);
    public void push(String element);
    public String pop();
    public void drop();
    public void swap();


    
}
