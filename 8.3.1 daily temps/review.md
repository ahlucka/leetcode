# Code review - Daily Temperatures

## Co je dobre

- Hlavni algoritmus je spravny, ,monotonni zasobnik je pro tuto ulohu optimalni volba.
- Ukladani indexu umozni snadno spocitat pocet dni do vyssi teploty.
- Casova slozitost je O(n). Kazdy index se vlozi a odebere nejvyse jednou.

## Co bych zlepsil

= ‼️ Nazev `stack` funguje, ale semanticky popis - neco jako`warmerCandidates` lepe popisuje jeho obsah. Kazdy kod neco implementuje a popsat promenou tim jak to implementuje nedava smysl.
- Dlouhou podminku cyklu `while` je lepsi rozdelit na dva radky.
- Na pohovoru nezapomen vysvetli, proc vnitrni `while` nezpusobi O(n^2). Kazdy index muze ze zasobniku zmizet jen jednou.
- Algoritmus je uz optimalni. Ostatni zmeny jsou hlavne pro citelnost.

## Shruti

Reseni je spravne, rychle a vhodne pro pohovor. Dobra prace!
