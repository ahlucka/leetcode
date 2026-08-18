# Code review - Container With Most Water

## Co je dobre

- Hlavni algoritmus je spravny. Vidis, dva pointery jsou optimalni volba, zapamatuj si tento typ ukolu.
- Po kazdem vypoctu se posune pointer u nizsi steny. Jen vyssi stena muze potom zvetsit obsah.
- Casova slozitost je O(n).

## Co bych zlepsil

- Podminka cyklu ma byt `left < right`. Pri `left == right` uz dve ruzne steny nemame. Vysledek to nekazi, ale udela se jeden zbytecny vypocet.
- Nazev `max` funguje, ale `maxArea` je presnejsi.
- Jednoradkovy `if` je lepsi dat do slozenych zavorek. Na pohovoru se pak kod snadneji upravuje bez chyby.

## Shruti

Algoritmus je spravny a optimalni. Vetsina zmen je jen pro citelnost.