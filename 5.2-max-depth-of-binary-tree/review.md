# Code review - Max Depth of Binary Tree

## Co je dobre

- Reseni je spravne.
- Pouziva rekurzi, coz je pro tento problem nejcistsi pristup.
- Base case je spravny:

```java
if (root == null) return 0;
````

* Spravne pocita hloubku jako:

```java
1 + Math.max(maxDepth(root.right), maxDepth(root.left));
```

* Kod je kratky, citelny a optimalni.
* Celkova slozitost je dobra:

  * Time: `O(n)`
  * Space: `O(h)`

Kde:

* `n` je pocet nodu ve stromu
* `h` je vyska stromu kvuli rekurzivnimu stacku

## Co bych zlepsil

### 1. Poradi `left` a `right`

Tady:

```java
return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
```

To funguje uplne spravne. Standardnejsi je ale psat nejdriv `left`, potom `right`:

```java
return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
```

Neni to chyba. Jen to vypada prirozeneji, protoze vetsina stromovych problemu se vysvetluje jako left-first.

### 2. Umet vysvetlit rekurzi

Kod je tak kratky, ze interview bude hlavne o vysvetleni.

Co bys by mel umet vysvetlit:

* Prazdny strom ma hloubku `0`.
* Kazdy node prida `1`.
* Hloubka aktualniho nodu je `1 + max(hloubka leveho podstromu, hloubka praveho podstromu)`.

## Lepsi verze

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
```

## Shruti

Tohle je velmi dobre reseni. Je kratke, spravne a presne odpovida tomu, co se v interview ocekava. Zlepseni jsou jen kosmeticka.