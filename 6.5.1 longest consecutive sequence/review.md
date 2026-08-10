# Code review - Longest Consecutive Sequence

## Co je dobre
- Reseni s razenim vraci spravny vysledek.
- Pocitadlo najde delku kazde souvisle rady.
- Kod nepouziva dalsi pole ani mapu.
- Casova slozitost je O(n log n) kvuli razeni.

## Co bych zlepsil
- Uvedena casova slozitost O(n) neni spravna. `Arrays.sort` ji zvysi na O(n log n). Tohle proberes v algoritmech a datovych strukturach - `sort` dela time complexity VZDYCKY aspon n log n.
- Uloha pozaduje O(n). Pro tento cil je lepsi `HashSet`.
- Razeni meni vstupni pole - to neni prakticky nikdy dobre reseni.
- Smycka muze zacit na indexu `1`. Obe kontroly `i == 0` pak zmizi.
- Opakovane aktualizace maxima zhorsuji citelnost. `Math.max` je jednodussi.

## Lepsi verze

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            numbers.add(num);
        }

        int longest = 0;

        for (int num : numbers) {
            boolean hasPrevious =
                    num != Integer.MIN_VALUE && numbers.contains(num - 1);

            if (hasPrevious) {
                continue;
            }

            int current = num;
            int length = 1;

            while (current != Integer.MAX_VALUE
                    && numbers.contains(current + 1)) {
                current++;
                length++;
            }

            longest = Math.max(longest, length);
        }

        return longest;
    }
}
```

## Jak to funguje

`HashSet` odstrani duplicity a umozni prumernou kontrolu v O(1).

Kod zacne pocitat jen u cisla, ktere nema predchudce. Takove cislo je zacatek rady.

Potom kontroluje dalsi cisla, dokud rada neskonci. Kazde cislo je soucasti jedne pocitane rady. Prumerna casova slozitost je O(n) a prostorova slozitost je O(n).

Kontroly krajnich hodnot brani preteceni `MIN_VALUE` a `MAX_VALUE`.

## Shruti

Puvodni reseni je spravne, ale nesplnuje cil O(n). Verze s mnozinou je lepsi pro pohovor. Navic necha vstupni pole na pokoji.
