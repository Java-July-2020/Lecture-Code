package week1;

// Master Class
public class Program {
  // Entry Point Method
  public static void main(String[] args) {
    // Primitive Data Types
    // int 4 bytes. whole numbers from -2,147,483,648 to 2,147,483,647
    // byte 1 -128 to 127
    // my_num = 15
    // myNum = 15
    // int MyNum = 15

    String StudentsInJuly = "Matthew,Samuel,May";
    System.out.println("The length of StudentsInJuly is: " + StudentsInJuly.length());

    // Concatenation
    // String FirstName = "Matthew";
    // String LastName = "Schiller";

    // System.out.println(FirstName + " " + LastName);

    String FirstName2 = "Matthew ";
    String LastName2 = "Schiller";
    System.out.println(FirstName2.concat(LastName2));

    System.out.println(FirstName2.toLowerCase());

    int x = 3 + 3;

    int y = x += 4;

    // x = 3 + 3 + 4

    String pizzaFlavor = "cheese";
    String myName = "cheese";

    FizzBuzzTest();

  }

  public static String fizzBuzz(int number) {
    if (number % 5 == 0 && number % 3 == 0)
      return "FizzBuzz";
    if (number % 5 == 0)
      return "Fizz";
    if (number % 3 == 0)
      return "Buzz";
    return Integer.toString(number);
  }

  public static void FizzBuzzTest() {
    for (int i = 0; i < 100; i++) {
      String result = fizzBuzz(i);
      String output = String.format("Number: %d :: Result: %s", i, result);
      System.out.println(output);
    }
  }

}