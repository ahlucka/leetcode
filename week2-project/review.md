# Code review - Week 2 Project - Number Input Analyzer

## Cil projektu

Week 2 projekt byl maly Java console program, ktery:
- necha uzivatele zadavat cisla
- podporuje desetinna cisla
- umi osetrit spatny vstup
- konci, kdyz uzivatel zada `-1`
- vypise zadana cisla
- spocita:
  - prumer
  - maximum
  - minimum

Projekt splnuje cil 🎉 🚀

## Co je dobre

- Program je rozdeleny do vice metod:
  - `input()`
  - `avg()`
  - `max()`
  - `min()`
- To je dobry krok za hranici "vsechno nacpat do mainu".
- Pouziva `Scanner` pro vstup z konzole.
- Pouziva `ArrayList<Double>`, takze podporuje desetinna cisla.
- Osetruje neplatny vstup pres `hasNextDouble()`.
- Odstrani `-1` pred vypocty.
- Pocita prumer, maximum a minimum oddelene.
- Celkova struktura je srozumitelna.

## Co bych zlepsil

### 1. Vetsi chyba v `max()` u zapornych cisel

Toto je opravdova chyba!!! V kodu mas:

```java
double max = 0;
````

To se rozbije, pokud uzivatel zada jen zaporna cisla.

Priklad:

```text
-5
-10
-1
```

Spravne maximum ma byt `-5`. Aktualni kod ale vrati `0`, i kdyz uzivatel `0` nikdy nezadal.

Lepsi je:

```java
double max = values.get(0);
```

Stejny pattern jako u `min()`.

### 2. Prazdny vstup po odstraneni `-1`

Kdyz uzivatel zada jen:

```text
-1
```

list se po odstraneni `-1` stane prazdnym.

Pak se rozbije nebo spatne spocita:

```java
avg(numbersList)
max(numbersList)
min(numbersList)
```

Je potreba zkontrolovat prazdny list po odstraneni `-1`:

```java
if (numbersList.isEmpty()) {
    System.out.println("No numbers entered.");
    return;
}
```

### 3. `input()` by nemelo vracet stop hodnotu

Ted `input()` vraci list, ktery obsahuje i `-1`, a `main()` ho potom maze.

Lepsi design je, aby `input()` vracelo jen realna cisla.

`-1` je prikaz pro ukonceni, ne data.

### 4. Porovnavani `double` pres `== -1`

Pro tenhle jednoduchy console program je to v poradku.

Obecne ale porovnavani `double` pres `==` muze byt riskantni.

Cistsi by bylo nacist hodnotu do promenne a rozhodnout hned:

```java
double value = scanner.nextDouble();

if (value == -1) {
    break;
}

values.add(value);
```

Tim se `-1` nikdy neprida do listu!! Ujisti se ze ti toto dava smysl - je to dulezity

### 5. Scanner se muze zavrit

Mala vec:

```java
scanner.close();
```

U maleho cviceni to neni velky problem, ale je to dobry navyk - kazda alokace resourcu (soubor, network, pamet, ...) by po sobe mela vzdycky uklidit.

### 6. Formatovani

Nektere `return` jsou na stejnem radku jako zaviraci zavorka:

```java
} return sum / values.size();
```

Lepsi:

```java
}

return sum / values.size();
```

Metoda `min()` ma take rozhazene odsazeni.

To neni chyba algoritmu, ale cisty kod pusobi lepe. Kod nema vypadat, ze prohral souboj s klavesou Tab.

## Lepsi verze

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Double> numbers = input();

        if (numbers.isEmpty()) {
            System.out.println("No numbers entered.");
            return;
        }

        System.out.println();
        System.out.println("Your inputs: " + numbers);
        System.out.println("Average: " + avg(numbers));
        System.out.println("Maximum: " + max(numbers));
        System.out.println("Minimum: " + min(numbers));
    }

    public static ArrayList<Double> input() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> values = new ArrayList<>();

        while (true) {
            System.out.print("Enter a number (-1 to stop): ");

            while (!scanner.hasNextDouble()) {
                scanner.next();
                System.out.print("Not a number. Try again: ");
            }

            double value = scanner.nextDouble();

            if (value == -1) {
                break;
            }

            values.add(value);
        }

        scanner.close();
        return values;
    }

    public static double avg(ArrayList<Double> values) {
        double sum = 0;

        for (double value : values) {
            sum += value;
        }

        return sum / values.size();
    }

    public static double max(ArrayList<Double> values) {
        double max = values.get(0);

        for (double value : values) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    public static double min(ArrayList<Double> values) {
        double min = values.get(0);

        for (double value : values) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }
}
```

## Shruti

Tohle je dobry Week 2 projekt. Pouziva metody, listy, smycky, validaci vstupu a zakladni vypocty.

Nejvetsi skutecna chyba je `max = 0`, protoze to selze pro zaporne vstupy. Ostatni zlepseni jsou hlavne o cistsi strukture a o tom, aby se `-1` bralo jako prikaz, ne jako data.

Dobry progres. Tohle uz neni jen LeetCode cviceni. Tohle zacina vypadat jako **malilinkaty** realny program.