class Solution {
    public static void main(String[] args) {

    }

    public int romanToInt(String s) {
        
        int[] stringAsNums = new int[(s.length())];
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') stringAsNums[i] = 1;
            else if (s.charAt(i) == 'V') stringAsNums[i] = 5;
            else if (s.charAt(i) == 'X') stringAsNums[i] = 10;
            else if (s.charAt(i) == 'L') stringAsNums[i] = 50;
            else if (s.charAt(i) == 'C') stringAsNums[i] = 100;
            else if (s.charAt(i) == 'D') stringAsNums[i] = 500;
            else stringAsNums[i] = 1000;
        }

        for (int i = 0; i < stringAsNums.length; i++) {

            if (i == stringAsNums.length - 1 || stringAsNums[i] >= stringAsNums[i + 1]) {
                sum += stringAsNums[i];
            } else {
                sum += stringAsNums[i + 1] - stringAsNums[i];
                i++;
            }
            
        }

    return sum;
    
}

}