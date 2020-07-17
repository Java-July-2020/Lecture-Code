package week2.animal;

public class AnimalController {
  public static void main(String[] args) {
    Animal dog = new Animal("black", "dog", 100, 10);
    Animal cat = new Animal("Gray", "cat", 100, 10);

    Animal kangaroo = new Animal("brown", "kangaroo");

    System.out.println(kangaroo.getStrength());
    System.out.println(cat.getHealth());
    dog.battle(cat);
    System.out.println(cat.getHealth());
  }
}