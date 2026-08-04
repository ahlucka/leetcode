**Approach:** v hashmapu se hleda target - cislo (x), pokud se najde tak se returnne index key v hashmapu a index cisla (x)

**Why this approach is better:** je to efektivnejsi protoze to je O(n) protoze to probehne arrayji jenom jednou, napriklad kdyby to byly dva for loopy tak je to O(n^2)

**Time complexity:** O(n)

**Space complexity:** O(n)

**LeetCode runtime percentile:** 2 ms, beats 99.32%