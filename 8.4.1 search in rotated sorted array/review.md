# Code review - Search in Rotated Sorted Array

## Co je dobre

- Hlavni algoritmus je spravny, kod spravne pouziva upraveny binary search.
- V kazdem kroku urci, ktera polovina je serazena.
- Hranice pro kontrolu `target` jsou nastavene spravne.
- Casova slozitost je O(log n).

## Co bych zlepsil (fakt jenom malickosti)

- Prvni `if` je lepsi dat do slozenych zavorek. Kod se pak bezpecneji upravuje.
- `else` je citelnejsi na stejnem radku jako predchozi zaviraci zavorka.
- V `Solution.md` je dobre vysvetlit, proc vzdy muzeme zahodit polovinu pole. Samotna veta o O(log n) na pohovoru nestaci.
- Reseni pocita s tim, ze hodnoty jsou ruzne - zadani to garantuje. Kazdopadne, toto je ukol, ktery jsem dostal, kdyz jsem delal interview s Metou. Jakmile jsem to vyresil, tak se me hned zeptali, jak by to vypadalo, kdyby tak byly duplicitni  hodnoty (neco jako [4, 5, 6, 6, 6, 6, 6, 7, 1, 2, 3]). Tim by se cely problem zkomplikoval - najednou bys musel prochazet pole i sekvencne abys zjistil kde konci potentialni stejne hodnoty a nebylo uz by to log n. 

## Shruti

Reseni je spravne a optimalni. Opet dobra prace!
