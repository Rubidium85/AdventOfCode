import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.Line; 


public class ReadFile{
    public  void read() {
      List<Integer> caloriesCarriedPerElf = new ArrayList<>();
      int calorieCount = 0;
      int largestNumOfCalories = 0;
      String line;
      try {
        File myObj = new File("input.txt");
        Scanner myReader = new Scanner(myObj);
       while (myReader.hasNextLine()) { 
        line = myReader.nextLine();
          if(line.isEmpty()){
            caloriesCarriedPerElf.add(calorieCount);
            calorieCount = 0;
          }else{
              calorieCount += Integer.parseInt(line);     
          }
        }

        caloriesCarriedPerElf.add(calorieCount);
        calorieCount = 0;

        for(int i = 0; i< caloriesCarriedPerElf.size();i++){
          if(caloriesCarriedPerElf.get(i) > largestNumOfCalories){
            largestNumOfCalories = caloriesCarriedPerElf.get(i);
          }
        }
        System.out.println(largestNumOfCalories);

        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
  }