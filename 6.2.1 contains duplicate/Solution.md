**Approach:** ve for loopu pridam cisla ktery jeste nejsou v hashsetu do hashsetu, pokud je tam cislo dvakrat tak return true, jinak false

**Why this approach is better:** napadlo me ze se muze udelat to stejny, ale nakonec se jenom checkne jestli je hashset kratsi nez array, jestli jo tak return true, ale to je pomalejsi protoze to nema early exit

**Time complexity:** O(n)

**Space complexity:** O(n)

**LeetCode runtime percentile:** 18 ms, beats 63.21%