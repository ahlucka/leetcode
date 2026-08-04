# Code review - Contains Duplicate

## Co je dobre

- Hlavni algoritmus je spravny.
- `HashSet` je pro hledani duplicit dobra datova struktura.
- Reseni skonci hned, kdyz najde prvni duplicitu.
- Prumerna time and space complexity je O(n).

## Co bych zlepsil

- !!! Nazev `listOfNums` neni presny. Promenna je mnozina, ne seznam. `seen` je kratsi a jasnejsi.
- Misto `contains` a potom `add` lze pouzit jen vysledek `add`. Metoda vrati `false`, pokud uz prvek v mnozine je. Kod tak udela mene operaci a je jednodussi.

## Lepsi verze

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}
```

## Proc to funguje

`HashSet` uchovava cisla, ktera jsme uz videli.

Pro kazde cislo zavolame `add`. Pokud vrati `false`, cislo uz v mnozine bylo. Nasli jsme tedy duplicitu a vratime `true`.

Pokud projdeme cele pole bez opakovani, vratime `false`.

## Shruti

Reseni je algoritmicky spravne a optimalni. HashSet tu dela presne to o cem jsme se bavili..
