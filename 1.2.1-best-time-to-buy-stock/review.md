# Code review - Day 2 - Best Time to Buy and Sell Stock

## Co je dobre

- Reseni pouziva spravny optimalni pristup - prochazi pole jen jednou.
- Prubezne si pamatuje nejlevnejsi cenu v `minCost`.
- Prubezne pocita nejlepsi profit.
- Nezkousi vsechny dvojice cen, coz by bylo pomale.
- Celkova slozitost je vyborna:
  - Time: `O(n)`
  - Space: `O(1)`

## Co bych zlepsil

### 1. Smycka mela zacit od indexu 1

Na indexu `0` porovnavas cenu sama se sebou. Neni to spatne, jen zbytecne.

Cistsi je zacit od `1`:

```java
for (int i = 1; i < prices.length; i++) {
```

### 2. Nazev `minCost`

`minCost` funguje, ale v kontextu akcii je trochu presnejsi `minPrice`.

Lepsi nazvy:

```java
int maxProfit = 0;
int minPrice = prices[0];
```

Kod pak lip rika, co se deje.

### 3. Slo by pouzit `Math.min` a `Math.max`

Tohle ukazuje jak o problemu premyslis, navic by ten kod byl trochu kratsi:

```java
minPrice = Math.min(minPrice, prices[i]);
maxProfit = Math.max(maxProfit, prices[i] - minPrice);
```

## Potencialne lepsi verze

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }
}
```

## Shruti

Tohle je dobre reseni. Algoritmus je spravny a optimalni.

Zlepseni jsou hlavne o nazvech promennych a cistote kodu. Musis udelat **kod citelny**, aby interviewer nemusel lustit co's tim chtel vlastne rict. Nejlepsi kod je ten co se vlasnte sam cte..