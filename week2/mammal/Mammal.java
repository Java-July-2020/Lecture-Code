package week2.mammal;

public class Mammal {
  protected String species;
  protected int health;

  public Mammal(String species, int health) {
    this.species = species;
    this.health = health;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public String getSpecies() {
    return this.species;
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

  public void battle(Attackable target) {
    int currentHealth = target.gethealth();
    currentHealth -= 5;
    target.setHealth(currentHealth);
  }

}