package week2.mammal;

public class Barrel implements Attackable {
  private int health;

  public Barrel() {
    this.health = 20;
  }

  public int gethealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void takeDamage(int damageAmount) {
    this.health -= damageAmount;
  }

}