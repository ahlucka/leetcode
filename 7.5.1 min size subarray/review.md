# Code review - Minimum Size Subarray Sum

## Co je dobre

- Hlavni algoritmus je spravny, Sliding window je pro tuto ulohu optimalni volba.
- Cyklus `while` spravne zmensuje platne okno a hleda jeho nejmensi delku.
- Casova slozitost je O(n). Kazdy prvek se prida jednou a odebere nejvyse jednou.

## Co bych zlepsil

- Nazvy `sum` a `min` jsou kratke. `currentSum` a `minLength` lepe popisuji jejich vyznam.
- Promenna `i` je ve skutecnosti pravy okraj okna. Nazev `right` lepe ukaze sliding window.
- Vysvetleni v `Solution.md` by melo rict, proc je sliding window spravne. Funguje diky tomu, ze vstup obsahuje jen kladna cisla.
- Na pohovoru zmin, ze vnitrni `while` nezpusobi O(n^2). Levy pointer projde polem jen jednou.

## Shruti

Reseni je spravne, optimalni a vhodne pro pohovor. Zlepsi nazvy a vysvetleni slozitosti.