
# Code review - Binary Search

## Co je dobre

- Reseni pouziva spravny binary search pristup.
- Ma spravne nastavene hranice:
  - `bottom = 0`
  - `top = nums.length - 1`
- Podminka `while (bottom <= top)` je spravna.
- Slozitost je optimalni:
  - Time: `O(log n)`
  - Space: `O(1)`

## Co bych zlepsil

### 1. "ZASE" nazvy promennych

`bottom` a `top` funguji, ale u binary search se casteji pouziva. Ado, nastuduj teorii:

```java
int left = 0;
int right = nums.length - 1;
```

Je to standardni pojmenovani, ktere interviewer hned pozna nebo naopak - tve ho pekne zmate

### 2. Posledni `else if` muze byt jen `else`

```java
} else if (nums[mid] > target) {
    top = mid - 1;
}
```

Neni potreba testovat `nums[mid] > target`. Kdyz neni rovno a neni mensi, musi byt uz jenom vetsi.

## Lepsi verze

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
```

## Proc to funguje

Nejdulezitejsi podminka - !pole je serazene! a kazdym krokem se podivame doprostred aktualniho rozsahu.
* Kdyz je `nums[mid] == target`, hotovo
* Kdyz je `nums[mid] < target`, target muze byt jen vpravo.
* Kdyz je `nums[mid] > target`, target muze byt jen vlevo.

Tim po kazdem kroku zahodime zhruba pulku pole coz dela casovou slozitost `O(log n)`. Binary search a pruchod stromem maji tuto unikatni casovou slozitost `O(log n)`.

## Shruti

Spravne reseni. Algoritmus je spravny, efektivni a pouziva bezpecny vypocet `mid`.

Zlepseni je **OPET** hlavne o standardnich nazvech promennych. Ado, prosim soustred se na to!!! Tohle je viditelny rozdil mezi "delam to poprve" a "jsem frajer co to dova dohromady po nekolikate".