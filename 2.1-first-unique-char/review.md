# Code review - First Unique Character in a String

## Co je dobre

- Reseni je velmi kratke a jednoduche.
- Logika dava smysl.
  - `indexOf()` najde prvni vyskyt znaku.
  - `lastIndexOf()` najde posledni vyskyt znaku.
- Pokud jsou oba indexy stejne jako aktualni `i`, znak je unikatni.
- Kod spravne vrati prvni unikatni znak.
- Pokud zadny neexistuje, vrati `-1`.

## Co bych zlepsil

### 1. Slozitost je horsi, nez vypada - toto je zasadni!

Kod vypada jako jeden loop:

```java
for (int i = 0; i < s.length(); i++)
````

Ale uvnitr se vola:

```java
s.indexOf(s.charAt(i))
s.lastIndexOf(s.charAt(i))
```

!!!! Obe tyto metody mohou projit cely string.

Takze celkova slozitost je:

* Time: `O(n^2)` - n^2 je skoro vzdycky spatna slozitost
* Space: `O(1)`

Pro interview je NUTNOST prijit s optimalnim `O(n)` reseni.

### 2. Lepsi je spocitat frekvence znaku

Problem se da vyresit ve dvou pruchodech:

1. Spocitat, kolikrat se kazdy znak vyskytuje.
2. Projit string znovu a vratit prvni znak s poctem `1`.

Protoze zadani pouziva mala anglicka pismena, staci pole velikosti `26`.

### 3. Formatovani `return -1`

Tahle cast:

```java
} return -1;
```

by mela byt na samostatnem radku.

Lepsi:

```java
}

return -1;
```

Neni to chyba logiky. Je to cistota kodu.

## Lepsi verze

```java
class Solution {
    public int firstUniqChar(String s) {
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (counts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
```

## Slozitost lepsi verze

* Time: `O(n)`
* Space: `O(1)`

To, ze projdes neco 2n krat nebo 50n krat porad znamena n krat z pohledu slozitosti.

Taky, technicky pouzivame pole `26`, ale to je konstantni velikost. Proto `O(1)`.

## Jak to funguje

Nejdriv si spocitame, kolikrat se kazdy znak objevi. Pak jdeme stringem zleva doprava. Prvni znak, ktery ma pocet `1`, je odpoved.

Dulezite je jit podruhe zleva doprava, protoze problem chce prvni unikatni znak, ne jen nejaky unikatni znak.

## Shruti

Tohle reseni je chytre a kratke. Pro zacatek je uplne v poradku.

Hlavni zlepseni je slozitost. V interview je potreba videt, ze `indexOf()` uvnitr loopu neni zadarmo (najiti prvku v poli je `O(n)`, najiti prvku v hashi je `O(1)`). Vypada to nenapadne, ale algoritmicky si z toho udelal `O(n^2)` problem.