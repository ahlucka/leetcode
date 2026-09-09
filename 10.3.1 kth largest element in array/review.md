# Code review - Kth Largest Element in an Array

## Co je dobre

- Hlavni algoritmus je spravny - min-heap o velikosti `k` je pro tuto ulohu dobra volba.
- Heap po celou dobu uchovava `k` nejvetsich dosud nalezenych hodnot.
- Casova slozitost je O(n log k).

## Co bych zlepsil

- Casova slozitost v `Solution.md` neni spravna. Kod zpracuje `n` cisel a kazda operace heapu trva O(log k). Vysledek je O(n log k), ne O(k log n).
- Pri razeni vzestupne by k-ta nejvetsi hodnota nebyla na indexu `k`. Byla by na indexu `nums.length - k`.
- Razeni je mozne reseni s casem O(n log n). Varianta s heapem splni pozadavek bez razeni a muze byt rychlejsi, kdyz je `k` male.
- Nazev `queue` je obecny. `minHeap` lepe popisuje datovou strukturu a jeji chovani.
- Dve vetve v cyklu lze zjednodusit. Vzdy vlozime hodnotu a pri velikosti vetsi nez `k` odebereme minimum.

## Shruti

Reseni je spravne a OK pro pohovor. Oprav so slozitost v popisu.
