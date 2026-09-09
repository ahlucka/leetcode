# Code review - Insert Interval

## Co je dobre

- Hlavni algoritmus je spravny - kod vyuziva to, ze vstupni intervaly jsou serazene a neprekryvaji se.
- Tri faze jsou logicke: intervaly pred novym, spojeni prekryvu a intervaly za novym.
- Podminky spravne spoji i intervaly, ktere se dotykaji na hranici.
- Casova slozitost je O(n), protoze kazdy interval zpracujeme jednou.

## Co bych zlepsil

- Tvrzeni v `Solution.md` o O(n^2) neni spravne. Vlozeni do pole a dalsi linearni merge by bylo O(n), pokud se neprovadi razeni. Varianta s razenim by byla O(n log n).

## Shruti

Reseni je spravne a optimalni. Oprav hlavne vysvetleni slozitosti.