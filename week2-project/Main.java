import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> numbersList = input();

        if (!numbersList.isEmpty() && numbersList.get(numbersList.size() - 1) == -1) {
            numbersList.remove(numbersList.size() - 1);
        }
        System.out.println("");
        System.out.println("your inputs: " + numbersList);
        System.out.println("average: " + avg(numbersList));
        System.out.println("maximum: " + max(numbersList));
        System.out.println("minimum: " + min(numbersList));

    }
    
    public static ArrayList<Double> input() {
        Scanner nums = new Scanner(System.in);
        ArrayList<Double> values = new ArrayList<>();
        
        while (values.isEmpty()|| values.get(values.size() - 1) != -1) {
            System.out.print("enter numbers here (-1 if you want to stop): ");
            while (!nums.hasNextDouble()) {
                String notNumeric = nums.next();
                System.out.print("not a number! try again: ");
            }
            values.add(nums.nextDouble());
        }
        nums.close();
        return values;
    }

    public static double avg(ArrayList<Double> values) {
        double sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        } return sum / values.size();
    }  

    public static double max(ArrayList<Double> values) {
        double max = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > max) max = values.get(i);
        } return max;
    }   

        public static double min(ArrayList<Double> values) {
        double min = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) < min) min = values.get(i);
        } return min;
    }   

}