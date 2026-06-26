# Code review - Search Insert Position

## Co je dobre

- Reseni pouziva binary search, coz je spravny smer.
- Ma spravne nastavene hranice:
  - `left = 0`
  - `right = nums.length - 1`
- Bezpecne pocita `mid`

```java
int mid = left + (right - left) / 2;
````

* Pokud najde `target`, spravne vrati index.
* Casova slozitost zustava:

  * Time: `O(log n)`
  * Space: `O(1)`

## Co bych zlepsil

### 1. Reseni je zbytecne slozite

Tahle cast je moc komplikovana:

```java
if ((mid == 0 || nums[mid - 1] < target) && nums[mid] > target) return mid;
else if ((mid == 0 || nums[mid - 1] < target) && (mid == nums.length - 1 || nums[mid + 1] > target)) return mid + 1;
```

Kod se snazi rucne detekovat misto, kam by se `target` vlozil. Ale u binary search to neni potreba.

!!!!! Po skonceni smycky `left` prirozene ukazuje na spravnou insert pozici. To je hlavni trik problemu.

### 2. `return -1` by tady nemel byt potreba

Tady:

```java
return -1;
```

U tohoto problemu vzdy existuje validni insert pozice.

Pokud `target` neni nalezen, ma se vratit `left`. Takze spravny konec by byl:

```java
return left;
```

### 3. Moc special cases

Kod kontroluje:

* `mid == 0`
* `mid == nums.length - 1`
* `nums[mid - 1]`
* `nums[mid + 1]`

To je riskantni a tezsi na vysvetleni. U binary search je lepsi drzet jednoduchou logiku:

* kdyz je `nums[mid] < target`, jdu doprava
* jinak jdu doleva

Hotovo. Zadna mentalni akrobacie okolo indexu.

### 4. Dva samostatne `if` na konci

Tady:

```java
if (nums[mid] < target) left = mid + 1;
if (nums[mid] > target) right = mid - 1;
```

Funguje to, ale cistsi/jednodussi je pouzit `else`.

```java
if (nums[mid] < target) {
    left = mid + 1;
} else {
    right = mid - 1;
}
```

## Lepsi verze

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
```

## Proc to funguje

Binary search postupne zmensuje rozsah, kde by `target` mohl byt. Kdyz `target` najdeme, vratime jeho index.

Kdyz ho nenajdeme, smycka skonci ve chvili, kdy `left` preskoci `right`.

V tu chvili `left` ukazuje na prvni pozici, kde by mohl `target` byt vlozen tak, aby pole zustalo serazene.

## Priklad

Pro pole:

```text
[1, 3, 5, 6]
```

* `target = 5` -> vrati `2`
* `target = 2` -> vrati `1`
* `target = 7` -> vrati `4`
* `target = 0` -> vrati `0`

## Shruti

Tohle reseni **jde** spravnym smerem, protoze pouziva binary search, nicmene je prilis komplikovane a tvuj interviewer by z kodu nemel radost.

Hlavni zlepseni je zjednoduseni. Jak jsem uz rikal, min kodu = mensi sance na bug.