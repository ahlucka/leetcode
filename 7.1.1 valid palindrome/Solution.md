**Approach:** dva pointery ktery skipnou vsechny ne alphanumericky znaky a porovnaji jestli jsou stejny

**Why this approach is better:** napadlo me predelat string na alphanumericky a potom udelat novy string reversed, ale to je zbytecne space i time inefficient

**Time complexity:** O(n)

**Space complexity:** O(1)

**LeetCode runtime percentile:** 2 ms, beats 99.33%