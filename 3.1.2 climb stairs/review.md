# Code review - Climbing Stairs

## Co je dobre

- Reseni je spravne.
- Pouziva iterativni dynamic programming pristup. Protoze dynamic programming je naprosta uchylnost, predpokladam, ze jsi tohle reseni nekde napsal/opsal!
- Nepouziva rekurzi, takze se vyhne opakovanemu pocitani.
- Drzi si jen posledni dve hodnoty -> je pametove optimalni.
- Celkova slozitost je vyborna:
  - Time: `O(n)`
  - Space: `O(1)`

## Co bych zlepsil

### 1. Nazvy promennych

Promenne `a` a `b` funguji, ale nejsou moc popisne:

```java
int a = 0;
int b = 1;
````

Lepsi by bylo neco jako:

```java
int previous = 0;
int current = 1;
```

nebo:

```java
int oneStepBefore = 1;
int twoStepsBefore = 0;
```

Kod pak rovnou vysvetluje, co se deje.

### 2. Vysvetlit vztah k Fibonacci sequence

Tento problem je v podstate Fibonacci.

Na schod `n` se da dostat:

* ze schodu `n - 1` jednim krokem
* ze schodu `n - 2` dvema kroky

Proto plati:

ways(n) = ways(n - 1) + ways(n - 2)

To je hlavni pointa problemu, musis to umet vysvetlit!

### 3. Return `b` je spravny, ale neni hned intuitivni

Kod vraci:

```java
return b;
```

Je to spravne, ale kvuli nazvum `a` a `b` neni hned jasne proc.

S lepsimi nazvy by to bylo citelnejsi.

## Lepsi verze

```java
class Solution {
    public int climbStairs(int n) {
        int previous = 0;
        int current = 1;

        for (int i = 0; i < n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }
}
```

## Shruti

Tohle je velmi dobre reseni. Nicmene si nejsem jisty kolik si z toho napsal ty sam!