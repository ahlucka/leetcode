import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Double> nums = new ArrayList<>();
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        input();
    }

    private static void input() {
        boolean open = true;

        while (open) {
            System.out.println("--- MENU ---");
            System.out.println("1. Pridat cislo do seznamu");
            System.out.println("2. Spocitat prumer");
            System.out.println("3. Spocitat faktorial");
            System.out.println("4. Ukoncit program");
            System.out.print("Vyberte moznost: ");

            String input = s.next();

            s.nextLine();

            switch (input) {
                case "1":
                    addInput();
                    break;
                case "2":
                    System.out.println("Prumer: " + avg(nums));
                    break;
                case "3":
                    factorial();
                    break;
                case "4":
                    System.out.println("Konec programu.");
                    open = false;
                    break;
                default:
                    System.out.println("Neplatna volba!");
                    System.out.println("");
            }
        }


    }

    private static void addInput() {
        System.out.print("Zadejte cislo: ");

        while (!s.hasNextDouble()) {
                String notNumeric = s.next();
                System.out.print("To neni cislo. Zadejte cislo: ");
        }

        nums.add(s.nextDouble());
        
        System.out.println("Seznam cisel: " + nums);
        System.out.println("");

        s.nextLine();
    }

    private static double avg(ArrayList<Double> values) {
        if (values.isEmpty()) return 0;
        double sum = 0;

        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }

        return sum / values.size();
    }

    private static void factorial() {
        System.out.print("Zadejte cele cislo: ");

        while (!s.hasNextInt()) {
            String notNumeric = s.next();
            System.out.print("To neni cele cislo. Zadejte cele cislo: ");
        }

        int num = s.nextInt();
        s.nextLine();

        System.out.println("Faktorial cisla " + num + " je: " + calcFactorial(num));
        System.out.println("");

    }

    private static int calcFactorial(int num) {
        if (num <= 1) {
            return 1;
        }
        return num * calcFactorial(num - 1);
    }


}