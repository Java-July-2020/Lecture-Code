package week2.mammal;

public class Gorilla extends Mammal implements Attackable {

  public Gorilla() {
    super("Gorilla", 500);

  }

  public void makeSound() {
    System.out.println("*pound ground");
  }

  @Override
  public void takeDamage(int damageAmount) {
    this.health -= (damageAmount / 2);
  }

  public void eatBanana() {
    System.out.printf("I am a %s eating a banana\n", this.species);
  }

}