# Code review - Longest Substring Without Repeating Characters

## Co je dobre

- Hlavni algoritmus je spravny pro ASCII vstup z teto ulohy, sliding window je optimalni volba.
- Pole `lastSeen` umozni skocit za posledni vyskyt opakovaneho znaku.
- Kontrola `lastSeen[c] >= left` brani tomu, aby se levy okraj vratil zpet.
- Casova slozitost je O(n).

## Co bych zlepsil

- ‼️ Pole o velikosti 128 funguje jen pro ASCII znaky. Pro obecny Java text muze `lastSeen[c]` vyhodit `ArrayIndexOutOfBoundsException`. Pro podminky teto ulohy je to v poradku, ale na pohovoru je dobre tento predpoklad rict. Toto je dulezite, jeden z nutnych kroku pro uspesny pohovor je mluvit o omezenich ktere tve reseni ma. Je potreba umet vysvetlit, ze ASCII znaku je jenom 128 a proto pole o 128 znacich staci. Unicode znaky uz by to nebralo. Nebo aji rozsireny ASCII, ktery ma 256 znaku.
- Nazev `max` je moc obecny. `maxLength` lepe popisuje hodnotu.

## Shruti

Reseni je spravne, rychle a vhodne pro pohovor. Hlavni vec k vysvetleni je omezeni na ASCII.