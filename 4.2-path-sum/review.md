# Code review - Path Sum

## Co je dobre

- Reseni je spravne.
- Pouziva rekurzi, coz je pro tento problem prirozeny pristup.
- Spravne kontroluje leaf node:

```java
if (root.left == null && root.right == null) return targetSum == root.val;
```

- Celkova slozitost je dobra:
  * Time: `O(n)`
  * Space: `O(h)`

Kde:
* `n` je pocet nodu ve stromu
* `h` je vyska stromu kvuli rekurzivnimu stacku

## Co bych zlepsil

### 1. Formatovani po prvnim `if`

Tady:

```java
} if (root.left == null && root.right == null) return targetSum == root.val;
```

funguje, ale je to trochu zmacknute.

Lepsi:

```java
if (root.left == null && root.right == null) {
    return targetSum == root.val;
}
```

Kod je pak citelnejsi. Interviewer nemusi nic hledat!

### 2. Poradi `left` a `right`

Tady:

```java
return hasPathSum(root.right, remainingSum) || hasPathSum(root.left, remainingSum);
```

Funguje to sice uplne spravne, ALE, JAK UZ JSEM PSAL, standardnejsi je  psat nejdriv `left`, potom `right`:

```java
return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
```
Drtiva vetsina stromovych problemu se vysvetluje left-to-right, stejne jako piseme!!!!! Prosim zapamatuj si to!!!!

## Lepsi verze

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int remainingSum = targetSum - root.val;

        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
```

## Proc to funguje

Na kazdem nodu odecteme jeho hodnotu od `targetSum`.

Tim rikame:

* "Kolik jeste musi dat zbytek cesty?"

Kdyz dojdeme na leaf node, zkontrolujeme, jestli hodnota leaf nodu presne odpovida zbyvajicimu souctu.

- Pokud ano, existuje validni root-to-leaf cesta.
- Pokud ne, zkusime jinou vetev.

## Shruti

Dobre reseni. Logika je spravna a rekurze sedi.

Zlepseni jsou hlavne o formatovani a standardnim poradi `left` pred `right`.