package week1;

import java.util.ArrayList;
import java.util.HashMap;

public class Day2 {
  // Entry Point Method
  public static void main(String[] args) {
    // Strings Continued
    String matt = new String("Matt");
    String justin = "Matt";

    // System.out.println(matt.equals(justin));
    // Arrays
    String[] people = { "Samuel", "Dennis", "Justin", "Polly", "May" };

    // System.out.println(people[4]);
    int[] numbers = new int[10];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i + 1;
    }

    // for (int i = 0; i < numbers.length; i++) {
    // System.out.println(numbers[i]);
    // }

    // for (int num : numbers) {
    // System.out.println(num);
    // }

    // ArrayLists
    ArrayList<String> favFoods = new ArrayList<String>();
    favFoods.add("Spinach");
    favFoods.add("Pad Thai");
    favFoods.add("Ravoli");
    favFoods.add("Pizza");
    favFoods.remove("Pizza");

    // for (String food : favFoods) {
    // System.out.println(food);
    // }
    // System.out.println(favFoods);
    // System.out.println(numbers);

    // HashMaps
    HashMap<String, Integer> favNumbers = new HashMap<String, Integer>();
    favNumbers.put("Matthew", 19);
    favNumbers.put("Samuel", 13);
    favNumbers.put("Justin", 75);
    favNumbers.put("May", 17);
    favNumbers.put("Dennis", 2);

    // for (String name : favNumbers.keySet()) {
    // System.out.println(name);
    // }

    // for (Integer num : favNumbers.values()) {
    // System.out.println(num);
    // }

    // for (HashMap.Entry<String, Integer> favNum : favNumbers.entrySet()) {
    // System.out.println("Key = " + favNum.getKey() + " , Value = " +
    // favNum.getValue());
    // }

    System.out.println(GetMax(numbers));

  }

  public static int GetMax(int[] nums) {
    // "current max variable"
    int currentMax = nums[0];
    // Loop the array
    for (int i = 0; i <= nums.length; i++) {
      try {
        if (currentMax < nums[i]) {
          // If we find the value > previous Max. Update it
          currentMax = nums[i];
        }
      } catch (Exception error) {
        System.out.println(error);
      }
    }
    return currentMax;
    // return currentMax
  }
}