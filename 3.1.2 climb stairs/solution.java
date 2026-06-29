public class solution {
    public static void main(String[] args) {

}

public int climbStairs(int n) {   
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }

}