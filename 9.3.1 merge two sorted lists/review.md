# Code review - Merge Two Sorted Lists

## Co je dobre

- Hlavni algoritmus je spravny, zakladni pripady pro prazdny seznam jsou spravne.
- Casova slozitost je O(n + m).

## Co bych zlepsil

- ‼️ Rekurze muze u dlouhych seznamu zpusobit `StackOverflowError`. Iterativni verze pouziva jen O(1) pomocneho prostoru.
- ‼️ V `Solution.md` chybi porovnani s iterativnim resenim. Na pohovoru je dobre znat obe varianty.
- Jednoradkove zakladni podminky je lepsi dat do slozenych zavorek.
- Kod meni spojeni v puvodnich seznamech. To je pro tuto ulohu v poradku, ale na pohovoru je dobre tuto vlastnost zminit.

## Shruti

Rekurzivni reseni je spravne a kratke. ‼️ Iterativni verze je ale bezpecnejsi pro dlouhe seznamy a ma O(1) pomocny prostor.