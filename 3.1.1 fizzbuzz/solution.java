import java.util.ArrayList;
import java.util.List;

public class solution {
    public static void main(String[] args) {

}
    public List<String> fizzBuzz(int n) {
    ArrayList<String> nums = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        if (i % 3 == 0) {
            if (i % 5 == 0) {
                nums.add("FizzBuzz");
            } else nums.add("Fizz");
        } else if (i % 5 == 0) {
            nums.add("Buzz");
        } else nums.add(String.valueOf(i));
    }
return nums;
}

}