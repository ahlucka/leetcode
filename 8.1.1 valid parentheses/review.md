# Code review - Valid Parentheses

## Co je dobre

- Hlavni algoritmus je spravny, zasobnik je pro tuto ulohu spravna datova struktura.
- Kod kontroluje typ zavorky na vrcholu zasobniku pred odebranim.
- Prazdny zasobnik na konci spravne znamena, ze vsechny zavorky maji par.
- Casova slozitost je O(n).

## Co bych zlepsil

- `Stack` je starsi Java trida. Pro novy kod je obvykle lepsi `Deque` s `ArrayDeque`.
- Pri spatne uzaviraci zavorce ji kod vlozi do zasobniku a pokracuje. Vysledek je stale spravny, ale muzeme hned vratit `false`. Kod pak dela mene prace a zamer je jasnejsi.
- Tri podobne bloky `if` se opakuji. Muzeme misto oteviraci zavorky ulozit ocekavanou uzaviraci zavorku.
- `s.charAt(i)` se vola nekolikrat. Lokalni promenna `current` zlepsi citelnost a performance. Kazde volani stejne funkce te stoji CPU cykly. Zavolas ji jenom jednou a ulozis do promenne a od te doby se odkazujes jenom na tu promennou.

## Shruti

Algoritmus je spravny, vylepsi stabni kulturu kodu!