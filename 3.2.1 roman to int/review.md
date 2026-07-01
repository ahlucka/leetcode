# Code review - Roman to Integer

## Co je dobre

- Reseni je spravne - nejdriiv prevadi rimske znaky na cisla, pak spravne resi normalni scitani i specialni pripady
- Celkova slozitost je dobra:
  - Time: `O(n)`
  - Space: `O(n)`

## Co bych zlepsil

### 1. Extra pole `stringAsNums` neni nutne

```java
int[] stringAsNums = new int[(s.length())];
```

Kod nejdriv ulozi vsechny hodnoty do pole a pak je prochazi znovu.

Funguje to, ale jde to udelat bez extra pole.

Tim se space zlepsi z O(n) na O(1)

### 2. Dlouhy `if / else if` block

Tahle cast funguje:

```java
if (s.charAt(i) == 'I') stringAsNums[i] = 1;
else if (s.charAt(i) == 'V') stringAsNums[i] = 5;
else if (s.charAt(i) == 'X') stringAsNums[i] = 10;
else if (s.charAt(i) == 'L') stringAsNums[i] = 50;
else if (s.charAt(i) == 'C') stringAsNums[i] = 100;
else if (s.charAt(i) == 'D') stringAsNums[i] = 500;
else stringAsNums[i] = 1000;
```

Je to v poradku.

Cistsi je ale udelat pomocnou metodu:

```java
private int valueOf(char c)
```

Pak se hlavni logika cte mnohem lepe, v realnym interview bys dostal minusovy body za "spaghetti code". Ten se spatne cte a hlavne spatne udrzuje.

### 3. ‼️‼️‼️ `else` pro `M`

Aktualne posledni `else` znamena:

```java
else stringAsNums[i] = 1000;
```

To funguje, pokud vstup obsahuje *jen validni rimske cislice*. Ale z hlediska spravnosti (rika se tomu defenzivni kod) je lepsi explicitne napsat `M`.

‼️‼️‼️‼️‼️ To znamena: "cokoliv jineho je 1000".
To je nebezpecne, pravdepodobne spatne. U takovychto prikladu je potreba premyslet nad corner cases a v tomto pripade to muze byt nevalidni vstup (nevalidni rimske cislo) a tobe by to vzalo jakekoliv nevalidni cislo jako 1000.

## Lepsi verze - bez extra pole

```java
class Solution {
    public int romanToInt(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = valueOf(s.charAt(i));

            if (i + 1 < s.length()) {
                int next = valueOf(s.charAt(i + 1));

                if (current < next) {
                    sum -= current;
                } else {
                    sum += current;
                }
            } else {
                sum += current;
            }
        }

        return sum;
    }

    private int valueOf(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        return 1000;
    }
}
```

## Slozitost lepsi verze

* Time: `O(n)`
* Space: `O(1)`

## Shruti

Tohle je dobre reseni. Logika je spravna a specialni rimske pripady jsou osetrene dobre.

Hlavni zlepseni je nepouzivat extra pole a presunout prevod znaku na cislo do pomocne metody. Tim bude kod kratsi, cistsi a pametove lepsi.

‼️‼️ A taky, bacha na ten `else`. Je potreba premyslet nad tim co se kde muze pokazit. Protoze se to pak typicky pokazi!