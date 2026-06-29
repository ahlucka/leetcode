# Code review - Two Sum

## Co je dobre

- Reseni pouziva `HashMap`, coz je pro Two Sum spravny optimalni pristup.
- Prochazi pole jen jednou.
- Spravne pocita `complement` jako `target - nums[i]`.
- Lookup pres `containsKey()` je v prumeru `O(1)`.
- Celkova slozitost je dobra:
  - Time: `O(n)`
  - Space: `O(n)`

## Co bych zlepsil

### 1. Nazvy promennych

`a`, `vals` a `y` funguji, ale v interview pusobi trochu nahodne.

Lepsi by bylo:

```java
HashMap<Integer, Integer> numToIndex = new HashMap<>();
int complement = target - nums[i];
````

Kod se pak cte skoro sam. To je v interview **obrovsky** plus.

### 2. Poradi indexu

Ted vracis:

```java
vals[0] = i;
vals[1] = a.get(y);
```

To projde, protoze LeetCode vetsinou neresi poradi indexu. Ale cistejsi je vratit driv nalezeny index prvni:

```java
return new int[] { numToIndex.get(complement), i };
```

### 3. Neni potreba `break`

Kdyz najdes odpoved, muzes ji rovnou vratit. Je to jednodussi a bez extra promenne `vals`.

### Lepsi verze

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numToIndex.containsKey(complement)) {
                return new int[] { numToIndex.get(complement), i };
            }

            numToIndex.put(nums[i], i);
        }

        return new int[] {};
    }
}
```

## Slozitost

* Time: `O(n)`
* Space: `O(n)`

## Shruti

Hlavni algoritmus je spravny.

Zlepseni jsou hlavne o cistote kodu a interview stylu.