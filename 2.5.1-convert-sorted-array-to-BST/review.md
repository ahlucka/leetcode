# Code review - Convert Sorted Array to BST

## Co je dobre

- Reseni je spravne.
- Pouziva rekurzi, coz je pro tento problem idealni pristup, navzdory tomu ze ti jeste nesmakuje :-D
- Leva cast pole jde do leveho podstromu.
- Prava cast pole jde do praveho podstromu.
- Tim vznikne height-balanced BST.
- Base case je spravny:
- Celkova slozitost je dobra:

  * Time: `O(n)`
  * Space: `O(log n)` pro vyvazeny strom kvuli rekurzivnimu stacku

## Co bych zlepsil

### 1. Vypocet `mid`

Ted je tam:

```java
int mid = (l + r) / 2;
```

Funguje to pro LeetCode vstupy. Bezpecnejsi standard je ale:

```java 
int mid = l + (r - l) / 2;
```

Tim se vyhnes moznemu integer overflow, kdyby `l` a `r` byly hodne velke.

### 2. `buildTree()` muze byt `private`

Pomocna metoda se pouziva jen uvnitr tridy. Neni to velka vec, ale ukazuje to dobry coding style.

### 3. A zase to formatovani zavorek

Tahle cast je trochu rozhazena:

```java 
return buildTree(0, nums.length - 1);
}
```

Cistota kodu je dulezita!

### 5. Instance promenna `nums` je v poradku, ale neni nutna

Tahle cast funguje:

```java
private int[] nums;
```

Pouziti field promenne zjednodusi parametry rekurze. Alternativne jde `nums` predavat do `buildTree()` jako parametr. Obe varianty jsou v poradku.

U interview bych klidne nechal field, ale umel bych rict proc tam je: aby se nemuselo pole predavat pri kazdem rekurzivnim volani.

## Lepsi verze

```java
class Solution {
    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return buildTree(0, nums.length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        return new TreeNode(
            nums[mid],
            buildTree(left, mid - 1),
            buildTree(mid + 1, right)
        );
    }
}
```

## Alternativni verze bez field promenne

```java id="ll593x"
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = buildTree(nums, left, mid - 1);
        node.right = buildTree(nums, mid + 1, right);

        return node;
    }
}
```

## Shruti

Dobre reseni. Algoritmus je spravny a presne odpovida tomu, co problem chce.

Zlepseni je opet hlavne o formatovani.
