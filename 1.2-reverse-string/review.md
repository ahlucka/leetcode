# Code review - Reverse String

## Co je dobre

- Reseni je jednoduche a spravne otaci string.
- Meni obsah pole `s`, coz odpovida zadani.
- Logika s indexem `s.length - i - 1` je spravna.
- Time complexity je:
  - Time: `O(n)`

## Co bych zlepsil

### 1. Pouziva extra pamet

Tady je hlavni problem:

```java
char[] a = s.clone();
````

Zadani chce upravit pole in-place a pouzit jen `O(1)` extra memory.

`clone()` vytvori kopii celeho pole, takze space complexity je `O(n)`.

To je presne vec, kterou interviewer chyti. A pak uz jen tise kouka. Coz neni idealni.

### 2. Lepsi je two-pointer pristup

Pouzij dva pointery:

* `left` zacina na zacatku
* `right` zacina na konci
* prohodis znaky
* posunes oba pointery ke stredu

Tim se nepouzije zadne extra pole.

### Lepsi verze

```java
class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
```

## Slozitost lepsi verze

* Time: `O(n)`
* Space: `O(1)`

## Shruti

Reseni je logicky spravne, ale nesplnuje idealni pametovy pozadavek.

Tohle je skvely priklad, kde projit testy nestaci. V interview se hodnoti i to, jestli resis problem **podle omezeni v zadani**.
