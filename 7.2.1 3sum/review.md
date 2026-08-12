# Code review - 3Sum

## Co je dobre

- Hlavni algoritmus je spravny - razeni a dva pointery jsou standardni reseni pro pohovor.
- Kod spravne preskakuje duplicitni prvni hodnoty.
- Po nalezeni trojice spravne preskakuje duplicity na obou stranach.
- Casova slozitost je O(n^2). Kazdopadne se chci jenom ujistit ze chapes ze O(n log n) + O(n * n) = O(n^2)
- Prostorova slozitost je obvykle O(log n) kvuli razeni. Vystupni seznam se do ni nepocita.

## Co bych zlepsil

- Nazev `ans` funguje, ale `result` je jasnejsi.
- `length` neni nutna promenna. `nums.length` je zde dostatecne kratke.
- `List.of` vyzaduje novejsi verzi Javy. `Arrays.asList` je bezpecnejsi volba, pokud verze Javy neni znama.
- Razeni meni vstupni pole. Neni to chyba pro LeetCode, ale na pohovoru je dobre tuto vlastnost zminit.

## Lehce lepsi verze

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(
                            nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
```

## Shruti

Algoritmus je spravny a vhodny pro pohovor. Nejvetsi problem je stabni kultura tveho kodu, ne logika. 