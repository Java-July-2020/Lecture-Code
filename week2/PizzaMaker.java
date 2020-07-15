package week2;

public class PizzaMaker {
  // Entry Point Function
  public static void main(String[] args) {
    // Static is for methods that don't require an object being created.
    // We can call this on the class itself without making an object.
    Pizza.advertise();
    // This will return our static advertising method.
    // Create some Pizza Objects.
    Pizza cheesePizza = new Pizza("Meat", 8, 'L', "deep dish");
    Pizza pepperoniPizza = new Pizza("Pepperoni", 6, 'M', "thin crust");
    Pizza vegetarianPizza = new Pizza("Vegetarian", 4, 'S', "stuffed");
    // Invoke the eat slices method on our cheesePizza Object.
    System.out.println(cheesePizza.eatSlices(3));
    System.out.println(cheesePizza.getSlices());
    // Using a Setter to update the the topping on the cheesePizza Object
    cheesePizza.setTopping("cheese");
    // Displaying all the attributes in a given object via the method we
    // input.
    pepperoniPizza.displayPizza();
    // Using a getter method to display a private attribute in our pizza object.
    vegetarianPizza.getCrustType();

  }

}