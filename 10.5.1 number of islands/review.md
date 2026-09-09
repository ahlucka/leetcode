# Code review - Number of Islands

## Co je dobre

- Hlavni algoritmus je spravny - DFS spravne oznaci vsechny casti jednoho ostrova.
- Pocitadlo se zvysi jen pri prvnim nalezeni noveho ostrova.
- Kontrola hranic brani pristupu mimo pole.
- Casova slozitost je O(m * n), protoze kazdou bunku navstivime nejvyse jednou.
- Prostorova slozitost je O(m * n) kvuli poli `visited` a rekurzivnimu zasobniku v nejhorsim pripade.

## Co bych zlepsil

- DFS neni vzdy prostorove lepsi nez BFS. Rekurzivni DFS i BFS mohou v nejhorsim pripade pouzit O(m * n) prostoru.
- Pole `visited` neni nutne, pokud smime zmenit vstupni `grid`. Navstivenou zemi muzeme zmenit z `'1'` na `'0'`.

## Shruti

Reseni je spravne. Nejvetsi zlepseni je odstranit zbytecne pole `visited`, pokud je dovoleno zmenit vstup.
