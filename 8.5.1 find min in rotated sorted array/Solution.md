**Approach:** stejny binary search jako ve ctvrtek ale tentokrat checkuju jestli je nums[mid] vetsi nebo mensi nez nums[right]. potom to returnne nums[left] protoze left == right == minimum

**Why this approach is better:** je to lepsi nez linearni search protoze to je O(n)

**Time complexity:** O(logn)

**Space complexity:** O(1)

**LeetCode runtime percentile:** 0 ms, beats 100.00%