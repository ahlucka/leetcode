# Code review - Binary Tree Level Order Traversal

## Co je dobre

- Hlavni algoritmus je spravny. BFS s frontou je pro pruchod po urovnich spravna volba.
- `levelSize` spravne oddeli uzly aktualni urovne od uzlu dalsi urovne.
- Casova slozitost je O(n), protoze kazdy uzel navstivime jednou.
- Pomocna prostorova slozitost je O(w), kde `w` je nejvetsi sirka stromu. V nejhorsim pripade je to O(n). Vystup take zabere O(n).

## Co bych zlepsil

- Algoritmus je spravny a optimalni. Vetsina zmen je jen pro styl a citelnost.
- Radky s `result.add` a `return` maji spatne odsazeni.

## Shruti

Reseni je spravne, rychle a vhodne pro pohovor. Gratulace!