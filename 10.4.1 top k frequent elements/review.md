# Code review - Top K Frequent Elements

## Co je dobre

- Hlavni algoritmus je spravny - HashMap spravne spocita cetnost kazdeho cisla.
- Casova slozitost je O(n).

## Co bych zlepsil

- Radek `List<Integer>[] buckets = new List[...]` vytvari varovani kvuli poli generickeho typu. `List<List<Integer>>` se tomuto varovani vyhne.
- V `Solution.md` je potreba lepe vysvetlit buckety. Nejvyssi mozna cetnost je `nums.length`, proto staci `n + 1` pozic.
- Alternativa s min-heapem ma cas O(n log k). Bucket reseni je zde rychlejsi, ale pouziva pole o velikosti O(n). Toto jsou trandeoffs ktere je nutne na pohovoru zminit.

## Shruti

Reseni je spravne a ma optimalni O(n) cas. Hlavni ukol je pochopit, ze index bucketu predstavuje cetnost.
