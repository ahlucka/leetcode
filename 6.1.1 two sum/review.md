# Code review - Two Sum

## Co je dobre

- Hlavni algoritmus je (opet :-D) spravny.
- HashMap umozni najit chybejici cislo bez druheho vnitrniho cyklu.
- Cislo se do mapy uklada az po kontrole. Proto se jeden prvek nepouzije dvakrat.
- Casova slozitost je prumerne O(n).

## Co bych zlepsil

- Nazev `completement` je asi preklep :-D
- Nazvy `ints` a `vals` nejsou moc popisne. `indexByValue` a `result` se ctou snadneji.
- !!! `containsKey` a `get` delaji dve hledani v mape. Staci jedno volani `get` a kontrola na `null`.
- Je prehlednejsi vratit vysledek hned po nalezeni dvojice. Neni pak potreba `break` ani pomocne pole vytvorene predem.
- !!! Pokud zadna dvojice neexistuje, kod vrati `[0, 0]`. To vypada jako platny vysledek.
- Poradi nalezenych indexu je v kodu opacne. Bezne se vraci nejdriv drive nalezeny index.

## Lepsi verze

```java
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer complementIndex = indexByValue.get(complement);

            if (complementIndex != null) {
                return new int[] {complementIndex, i};
            }

            indexByValue.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution exists");
    }
}
```

## Shruti

Reseni je algoritmicky spravne a pro pohovor OK. 


Chybky jsou hlavne uklid nazvu a flow tvyho kodu.