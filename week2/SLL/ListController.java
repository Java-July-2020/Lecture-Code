package week2.SLL;

public class ListController {
  public static void main(String[] args) {

    SLL sll = new SLL();
    sll.addToList(19);
    sll.addToList(20);
    sll.addToList(21);
    sll.addToList(23);
    sll.addToList(29);
    sll.addToList(32);

    sll.displayList();
    sll.removeAt(2);
    sll.displayList();

  }
}