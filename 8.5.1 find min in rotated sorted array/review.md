# Code review - Find Minimum in Rotated Sorted Array

## Co je dobre

- Hlavni algoritmus je spravny, binary search je pro tuto ulohu optimalni volba.
- Porovnani `nums[mid]` s `nums[right]` spravne urci, ve ktere casti lezi minimum.
- Podminka `left < right` skonci presne tehdy, kdyz oba pointery ukazuji na minimum.
- Casova slozitost je O(log n).

## Co bych zlepsil

- V `Solution.md` je chyba ve vysvetleni. Binary search je lepsi nez linearni hledani proto, ze ma O(log n), ne O(n).
- Jednoradkove vetve `if` a `else` je lepsi dat do slozenych zavorek.
- Aji tady plati moje poznamka o tom, jak se uloha zmeni, kdyz by byly povolene duplicitni hodnoty.
- Na pohovoru vysvetli, proc pri `nums[mid] <= nums[right]` nastavime `right = mid`. Hodnota na `mid` muze byt minimum, a proto ji nesmime zahodit.

## Shruti

Reseni je spravne, kratke a optimalni. Bacha na ten popis slozitosti.