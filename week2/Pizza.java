package week2;

/*
// Name Our Class: 

  //Attributes
  toppings
  slices
  size
  crust type


  //Methods
  display
  advertise
  eatSlice
*/

public class Pizza {
  private String toppings;
  private int slices;
  private char size;
  private String crustType;

  // Constructor
  public Pizza(String toppings, int slices, char size, String crustType) {
    this.toppings = toppings;
    this.slices = slices;
    this.size = size;
    this.crustType = crustType;
  }

  public String getTopping() {
    return this.toppings;
  }

  public void setTopping(String topping) {
    if (topping.equals("")) {
      System.out.println("Toppings can't be empty");
      return;
    }
    this.toppings = topping;
  }

  public int getSlices() {
    return this.slices;
  }

  public char getSize() {
    return this.size;
  }

  public String getCrustType() {
    return this.crustType;
  }

  public void setSlices(int slices) {
    this.slices = slices;
  }

  public void setSize(char size) {
    this.size = size;
  }

  public void setCrustType(String crust) {
    this.crustType = crust;
  }

  public void displayPizza() {
    System.out.println("This is a " + this.crustType + " pizza with " + this.slices + " slices. size: " + this.size
        + " with " + this.toppings + " toppings");
  }

  public static void advertise() {
    System.out.println("Hey you... check out these pizzas at these prices");
  }

  public int eatSlices(int numSlices) {
    System.out.println("You just ate " + numSlices + " slices of the " + this.toppings + " pizza");
    this.slices = this.slices - numSlices;
    return this.slices;
  }
}