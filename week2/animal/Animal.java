package week2.animal;

public class Animal {
  private String color;
  private String species;
  private int health;
  private int strength;

  // Constructors
  public Animal(String color, String species, int health, int strength) {
    this.color = color;
    this.species = species;
    this.health = health;
    this.strength = strength;
  }

  public Animal(String color, String species) {
    this.color = color;
    this.species = species;
    this.health = 100;
    this.strength = 15;
  }

  public String getColor() {
    return this.color;
  }

  public String getSpecies() {
    return this.species;
  }

  public int getHealth() {
    return this.health;
  }

  public int getStrength() {
    return this.strength;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  // Attacks another animal
  public void battle(Animal target, String powerMove) {
    // Define the logic on the animal attacks;
    int damage;
    if (powerMove.equals("fireball")) {
      damage = 3;
    } else if (powerMove.equals("roar")) {
      damage = 5;
    } else {
      System.out.println("Move not recognized");
      return;
    }

    // Multiply the damage x Strength
    int effectiveDamage = this.strength * damage;

    // reduce the targets health by the effective damage
    target.health -= effectiveDamage;

    // print to the console what just happened
    System.out.printf("%s attacks %s for %d health points\n", this.species, target.species, effectiveDamage);
  }

  public void battle(Animal target) {
    this.battle(target, "fireball");
  }

}