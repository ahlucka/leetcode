
# Code review - Subtree of Another Tree

## Co je dobre

- Reseni pouziva spravny rekurzivni pristup.
- Kod je kratky a dobre citelny.
- Celkove je to velmi solidni reseni.

## Slozitost

- Time: `O(m * n)` v horsim pripade
  - `m` je pocet nodu v `root`
  - `n` je pocet nodu v `subRoot`
- Space: `O(h)`
  - kvuli rekurzi
  - `h` je vyska stromu

V horsim pripade muze byt rekurzivni stack az `O(m + n)`, pokud jsou stromy hodne nevyvazene.

## Co bych zlepsil

### 1. Osetrit `subRoot == null`

Podle LeetCode zadani `subRoot` obvykle nebude `null`, ale obecne by prazdny strom mel byt subtree kazdeho stromu.

Lepsi base case:

```java
if (subRoot == null) return true;
if (root == null) return false;
````

Ted kod dela jen:

```java
if (root == null) return false;
```

To je pro LeetCode pravdepodobne v poradku, ale obecne mene kompletni.

### 2. Poradi prochazeni
Tvoje:

```java
return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
```
Funguje to uplne stejne jako left-first.

Ale standardnejsi a cistsi je:
```java
return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
```

Neni to chyba. Jen to vypada prirozeneji.

### 3. Nazev metody `equal`

`equal` je srozumitelne. Trochu presnejsi by bylo:

```java
private boolean isSameTree(TreeNode a, TreeNode b)
```

Tohle je standartni naming convention. Typicky, kdyz metoda vraci true nebo false, pousijes neco jako `isSame` nebo `hasChild` nebo `isFiveLevelsDeepMax`.

### 4. Pomocna metoda muze byt `private`

Metoda `equal()` se pouziva jen uvnitr tridy `Solution`.

Lepsi je:

```java
private boolean isSameTree(TreeNode a, TreeNode b)
```

Toto vypada jako mala vec, ale ukazovalo by to tvuj dobry coding style.

## Lepsi verze

```java
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null || a.val != b.val) {
            return false;
        }

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}
```

## Shruti

Tohle je dobre a interview-ready reseni. Rekurze je spravna a pomocna metoda je dobre oddelena.

Zlepseni jsou hlavne o kompletnejsich base cases, standardnim poradi `left` pred `right` a presnejsim nazvu pomocne metody.