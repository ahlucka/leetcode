# Code review - Validate Binary Search Tree

## Co je dobre

- Hlavni algoritmus je spravny, kazdy uzel dostane platny dolni a horni limit.
- Typ `long` spravne resi uzly s hodnotou `Integer.MIN_VALUE` nebo `Integer.MAX_VALUE`.
- Prisne porovnani spravne odmitne duplicitni hodnoty.
- Casova slozitost je O(n), protoze kazdy uzel zkontrolujeme jednou.
- Prostorova slozitost je O(h) kvuli rekurzi, kde `h` je vyska stromu. Je to O(log n) pro vyvazeny strom a O(n) v nejhorsim pripade.

## Co bych zlepsil

- Algoritmus je optimalni, takze jenom drobnosti..
- Dlouhy posledni `return` je lepsi rozdelit na vice radku.
- V `Solution.md` je prostorova slozitost uvedena jen jako O(n). ‼️ To je spravny jenom jako worst-case, ale na pohovoru je presnejsi rict O(h).

## Shruti

Reseni je spravne a dobre pripravene pro pohovor. Upresni jen prostorovou slozitost.
