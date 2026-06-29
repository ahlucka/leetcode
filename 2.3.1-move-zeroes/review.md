# Code review - Move Zeroes

## Co je dobre

- Reseni je spravne - pouziva two-pointer pristup.
- `nonZeroIndex` ukazuje, kam patri dalsi nenulova hodnota.
- Prochazi pole jen jednou a zachovava poradi nenulovych hodnot.
- Upravuje pole in-place.
- Celkova slozitost je optimalni:
  - Time: `O(n)`
  - Space: `O(1)`

## Co bych zlepsil

### 1. Reseni dela zbytecne swap samo se sebou

Kdyz `i == nonZeroIndex`, kod dela swap hodnoty same se sebou:

```java
int temp = nums[i];
nums[i] = nums[nonZeroIndex];
nums[nonZeroIndex] = temp;
````

To je zbytecna prace. Da se pridat kontrola:

```java
if (i != nonZeroIndex) {
    int temp = nums[i];
    nums[i] = nums[nonZeroIndex];
    nums[nonZeroIndex] = temp;
}
```

Kazdopedne `nonZeroIndex++` musi probehnout vzdy, kdyz najdeme nenulove cislo.

### 2. Formatovani zase

Chybi mezera:

```java
if(nums[i] != 0)
```

A na konci jsou zavorky trochu crazy:

```java
        }
        }
    }
```

### 3. Existuje i jednodussi verze bez swapu

Misto swapovani se da nejdriv prepsat vsechny nenulove hodnoty dopredu a pak zbytek doplnit nulami. Je to taky `O(n)` a `O(1)`, ale projde pole efektivne dvakrat.

Swap verze je uplne v poradku, ale je dobre znat obe. BOHUZEL, behem interview castokrat narazis na manazer ktery VYZADUJE tuto konkretni implementaci a pokud mu ji nedas, dostanes minusovy body :-(

## Lepsi verze - s tvym swap pristupem

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != nonZeroIndex) {
                    int temp = nums[i];
                    nums[i] = nums[nonZeroIndex];
                    nums[nonZeroIndex] = temp;
                }

                nonZeroIndex++;
            }
        }
    }
}
```

## Alternativni verze - prepis a doplneni nul

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[nonZeroIndex] = num;
                nonZeroIndex++;
            }
        }

        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }
}
```

## Proc to funguje

Cil je presunout vsechny nenulove hodnoty dopredu a zachovat jejich poradi.

`nonZeroIndex` vzdy ukazuje na misto, kam patri dalsi nenulova hodnota.

Kdyz najdeme nenulove cislo:

* presuneme ho na `nonZeroIndex`
* posuneme `nonZeroIndex` doprava

Vsechno za posledni nenulovou hodnotou nakonec zustane nebo se stane nulami.

## Shruti

Dobre reseni. Algoritmus je spravny, optimalni slozitost a odpovida tomu, co se v interview ocekava.

Zlepseni jsou hlavne o zbytecnem swapu a formatovani. A samozrejme to formatovani - aby ty zavorky nevypadaly, ze se prave vratili z hospody!!