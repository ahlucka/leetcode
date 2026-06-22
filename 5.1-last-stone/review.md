# Code review - Last Stone Weight

## Co je dobre

- Reseni ma spravnou hlavni myslenku.
- V kazdem kroku bere dve nejtezsi kameny.
- Spravne resi pripad, kdy jsou kameny stejne tezke.
- Spravne resi pripad, kdy zustane jen jeden kamen.
- Kod pravdepodobne projde mensi testy.

## Co bych zlepsil

### 1. ‼️ opakovane sortovani je pomale/zbytecne

Tady je hlavni problem:

```java
Arrays.sort(stones);
````

‼️ Sortujes cele pole v kazdem kroku. To funguje, ale pridava to zbytecny CPU cycles..

Slozitost je zhruba:

* Time: `O(n^2 log n)`
* Space: `O(1)` nebo podle implementace sortu

Pro tenhle problem je prirozenejsi pouzit max heap. V Jave se pouzije `PriorityQueue`, ale obracene, aby davala nejvetsi hodnotu jako prvni. Tohle si musis nastudovat. Heap je jedna z datovych struktur ktera se bezne pouziva v Leetcode testech an prakticky nikdy (krome cestnych vyjimek) ju nepouzijes v realnym zivote. Ha ha ha. Nicmene to musis umet, protoze ten koncept je dulezity.

### 2. Druhe sortovani v `else` je zbytecne

Tady:
```java
Arrays.sort(stones);
int xPos = java.util.Arrays.binarySearch(stones, x);
int yPos = java.util.Arrays.binarySearch(stones, y);
```

Pole uz bylo serazene na zacatku iterace. Druhy sort vubec neni potreba.

### 3. `binarySearch` tady neni potreba

Protoze po sortu vis, ze dva nejvetsi kameny jsou na konci:

```java
int x = stones[stones.length - 2];
int y = stones[stones.length - 1];
```

Takze muzes rovnou upravit tyto pozice.

`binarySearch` pridava slozitost a muze byt zbytecne matoucí, hlavne kdyz jsou v poli duplicitni hodnoty.

### 4. Smycka bezi pevne `stones.length` krat

Tady:

```java
for (int i = 0; i < stones.length; i++)
```

Ve skutecnosti nechces bezet podle puvodni delky pole. Chces pokracovat, dokud existuji aspon dva nenulove kameny.

Proto je heap lepsi. Sam si hlida, kolik kamenu jeste zbyva.

### 5. Chybi import

Pokud se pouziva `Arrays`, mel by tam byt import:

```java
import java.util.Arrays;
```

LeetCode to casto toleruje podle sablony, ale v normalnim Java souboru by to bylo potreba.

## Lepsi verze

```java
import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if (y != x) {
                maxHeap.add(y - x);
            }
        }

        if (maxHeap.isEmpty()) {
            return 0;
        }

        return maxHeap.poll();
    }
}
```

## Slozitost lepsi verze

* Time: `O(n log n)` (‼️ o jedno `n` mene, tohle je zasadni)
* Space: `O(n)`

## Jak to funguje

Vzdy potrebujeme najit dva nejtezsi kameny. Max heap je na to presne delany:

* `poll()` vrati nejvetsi kamen.
* Druhe `poll()` vrati druhy nejvetsi kamen.
* Pokud se nerovnaji, vlozime zbytek zpatky.
* Pokud se rovnaji, oba zmizi.

Na konci bud nezbyde nic, nebo jeden kamen.

## Shruti

Tve reseni ma spravnou logiku, ale pouziva tezsi/spatnou cestu.

Dobry mentalni model je: kdykoliv problem opakovane chce "nejvetsi" nebo "nejmensi" prvek, mel by se nasemu-nejmilejsimu-nejstarsimu-synovi rozsvitit heap alarm. Ne panika.
