package week2.mammal;

public interface Attackable {
  int gethealth();

  void setHealth(int health);

  void takeDamage(int damageAmount);
}