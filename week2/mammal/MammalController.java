package week2.mammal;

public class MammalController {
  // Entry Point
  public static void main(String[] args) {
    // Instantiate New Mammal Class
    Mammal human = new Mammal("human", 100);
    human.getSpecies();

    // Instantiate New Gorilla Object, child of Mammal
    // and attackable object
    Gorilla dk = new Gorilla();

    // Instantiate a new Barrel, an attackable object
    Barrel barrel = new Barrel();

    dk.battle(barrel);

  }

}