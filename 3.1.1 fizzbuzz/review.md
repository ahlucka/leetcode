# Code review - Fizz Buzz

## Co je dobre

- Spravne reseni Fizz Buzz.
- Pouziva `String.valueOf(i)`, coz je spravne.
- Celkova slozitost je dobra:
  - Time: `O(n)`
  - Space: `O(n)`

Space je `O(n)`, protoze musime vratit list s `n` hodnotami.

## Co bych zlepsil

### 1. Nazev tridy

V Jave by trida mela zacinat velkym pismenem:

```java
class Solution
```

### 2. Formatovani

Kod funguje, ale odsazeni je trochu rozhazene.

Tahle cast:

```java
}
return nums;
}
```

by mela byt zarovnana citelneji.

Ciste formatovani je u easy problemu skoro zadarmo. Takze neni duvod ho nedat.

### 3. Vnorene `if` jde zjednodusit

Aktualni logika je spravna:

```java
if (i % 3 == 0) {
    if (i % 5 == 0) {
        nums.add("FizzBuzz");
    } else nums.add("Fizz");
}
```

Ale jednodussi je nejdriv zkontrolovat delitelnost `15`.

```java id="f6kpwy"
if (i % 15 == 0)
```

Je to cistsi a hned ukazuje, ze `FizzBuzz` ma prioritu.

## Lepsi verze

```java
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
```

## Shruti

Reseni je spravne.

Zlepseni jsou hlavne o cistsim formatovani.