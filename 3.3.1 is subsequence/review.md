# Code review - Is Subsequence

## Co je dobre

* Reseni pouziva spravny two pointers pristup.
* Hlavni algoritmus je korektni. Prochazi `t` jen jednou.
* Nepouziva zadne zbytecne datove struktury.
* Casova slozitost je `O(t.length())`.
* Pametova slozitost je `O(1)`.

## Co bych zlepsil

### 1. Prazdne stringy

* Specialni kontroly nejsou nutne.
* Finalni `return sIndex == s.length()` je pokryje sam a kod je pak kratsi a jednodussi.

### 2. Citelnejsi nazvy

`sPos` funguje ale `sIndex` je ale trochu jasnejsi a interviewer rychleji vidi, co index sleduje.

## Lepsi verze

```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;

        for (int tIndex = 0; tIndex < t.length() && sIndex < s.length(); tIndex++) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
        }

        return sIndex == s.length();
    }
}
```

## Shruti

Dobre reseni - algoritmus je spravny a optimalni.