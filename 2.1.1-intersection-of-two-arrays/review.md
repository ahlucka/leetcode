# Code review - Intersection of Two Arrays

## Co je dobre

- Reseni pouziva `HashSet`, coz je pro tento problem spravny pristup.
- Prvni pole se ulozi do setu.
- Druhe pole se projde a kontroluje se, jestli hodnota existuje v setu.
- `set.remove(nums2[i])` je velmi dobry detail.
  - Zajisti, ze se stejna hodnota neprida do vysledku vicekrat.
- Kod je kratky a dobre citelny.
- Celkova slozitost je dobra:
  - Time: `O(n + m)`
  - Space: `O(n)`

Kde:

- `n` je delka `nums1`
- `m` je delka `nums2`

## Co bych zlepsil

### 1. Zase ty nazvy promennych

`set` a `list` jsou hloupy jmena. MUSIS pojmenovat promenny trochu presneji. Kod se musi cist sam.

Napriklad:

```java
HashSet<Integer> nums1Set = new HashSet<>();
ArrayList<Integer> intersection = new ArrayList<>();
```

Kod pak jasne rika, co se v nem deje.

### 2. Druhy loop muze byt for-each

Tady:

```java
for (int i = 0; i < nums2.length; i++) {
    if (set.contains(nums2[i])) {
        list.add(nums2[i]);
        set.remove(nums2[i]);
    }
}
```

neni potreba pracovat s indexem. Staci hodnota. O radek min znamena o potentialni chybu min. Min kodu je vzdy lepsi.

Cistsi verze:

```java
for (int num : nums2) {
    if (nums1Set.contains(num)) {
        intersection.add(num);
        nums1Set.remove(num);
    }
}
```

### 3. Stream je v poradku, ale muze byt pro zacatek trochu magicky

Tahle cast je dobra:

```java
int[] result = list.stream().mapToInt(Integer::intValue).toArray();
```

Je to moderni a kratke.

Pro interview bys ale mel umet udelat i manualni prevod, kdyby se interviewer zeptal:

```java
int[] result = new int[intersection.size()];

for (int i = 0; i < intersection.size(); i++) {
    result[i] = intersection.get(i);
}
```

Stream neni spatne. Jen je dobre vedet, co to dela pod kapotou a jak to udelat postaru

## Lepsi verze

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<>();
        ArrayList<Integer> intersection = new ArrayList<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }

        for (int num : nums2) {
            if (nums1Set.contains(num)) {
                intersection.add(num);
                nums1Set.remove(num);
            }
        }

        int[] result = new int[intersection.size()];

        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }
}
```

## Shruti

Hezke reseni. Algoritmus je spravny aoptimalni - pouziva `HashSet`.

Zlepseni jsou hlavne opet o citelnejsich nazvech a jednodussim loopu.
