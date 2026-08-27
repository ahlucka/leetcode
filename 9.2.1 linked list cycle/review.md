# Code review - Linked List Cycle

## Co je dobre

- Hlavni algoritmus je spravny. Slow a fast pointer je pro tuto ulohu optimalni volba.
- Podminka cyklu spravne kontroluje `fast` i `fast.next` pred skokem o dva uzly.
- Porovnani `slow == fast` spravne porovnava samotne uzly, ne jejich hodnoty.
- Casova slozitost je O(n).

## Co bych zlepsil

- Pokud chces mit `ListNode` v lokalnim souboru, je praktictejsi pouzit samostatnou nebo `static` tridu. Nestaticka vnitrni trida potrebuje instanci `Solution`.
- V `Solution.md` by bylo dobre vysvetlit, proc se pointery v cyklu potkaji. Fast pointer ziskava pri kazdem kroku jeden uzel na slow pointer.

## Shruti

Reseni je spravne, optimalni, dobre pro pohovor 👍