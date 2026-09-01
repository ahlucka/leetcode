# Code review - Merge Intervals

## Co je dobre

- Hlavni algoritmus je spravny, serazeni podle zacatku intervalu umozni spojovat intervaly jednim pruchodem.
- `Integer.compare` je bezpecnejsi nez odecitani hodnot v comparatoru.
- Casova slozitost je O(n log n) kvuli razeni. Samotne spojovani je O(n).

## Co bych zlepsil

- Metoda meni poradi vstupniho pole a take muze zmenit koncovou hodnotu puvodniho intervalu. Pro LeetCode je to v poradku, ale na pohovoru je dobre tuto vlastnost zminit.
- Tvrzeni v `Solution.md`, ze prostorovou slozitost nelze zlepsit, je trosku silnejsi nez realita 😅. Samotne spojovani je in-place. Celkovy prostor zalezi take na razeni a na tom, zda pocitame vystup.

## Shruti

Reseni je spravne, efektivni a setrne s pameti pri samotnem spojovani. Dobra prace!