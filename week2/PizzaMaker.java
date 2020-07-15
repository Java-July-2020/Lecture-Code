package week2;

public class PizzaMaker {
  // Entry Point Function
  public static void main(String[] args) {
    Pizza cheesePizza = new Pizza("Pepperoni", 8, 'M', "thin crust");
    System.out.println(cheesePizza.eatSlices(3));
    System.out.println(cheesePizza.getSlices());
  }

}