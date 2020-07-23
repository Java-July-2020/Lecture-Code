import java.util.ArrayList;

class Calculator {
  // Declare Two Array Lists to keep track of the numbers, and one for the operators.
    ArrayList<Character> operators = new ArrayList<Character>();
    ArrayList<Double> nums = new ArrayList<Double>();
    Double results;
    
    public Calculator (){

    }

    // If the number passed in has a decimal, add to the ArrayList
    public void performOperation(double num){
        nums.add(num);
    }

    // Overloaded Method, if the number is an int, TypeCast it to a double to add to the collection.
    public void performOperation(int num){
        nums.add((double) num);
    }
    
    // Logic 
    public void performOperation(Character ch){
      // If the Operand is not =, add to the operators ArrayList 
        if (ch != "="){
            operators.add(ch);
        }
      // If it is an equals sign, do the calculations.
        else {
            // Start at the beginning of the ArrayList and compound.
            Double numsInProgress = nums.get(0);
            // Loop Through Operators
            for(int i = 0; i < operators.size(); i++){
              // Switch Statement, basically if/if else/else
                switch(operators.get(i)){
                    case "+": numsInProgress = numsInProgress + nums.get(i); break;
                    case "-": numsInProgress = numsInProgress - nums.get(i); break;
                    case "/": numsInProgress = numsInProgress / nums.get(i); break;
                    case "*": numsInProgress = numsInProgress * nums.get(i); break;
                    default: System.out.println("Operator Not Recognized"); break;
                }
            }
            this.results = numsInProgress;
        }
    }
    public void getResults(){
        System.out.println(this.results);
    }
}