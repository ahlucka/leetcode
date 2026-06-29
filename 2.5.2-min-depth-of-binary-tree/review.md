# Code review - Minimum Depth of Binary Tree

## Co je dobre

- Reseni je spravne.
- Pouziva rekurzi, coz je pro tento problem prirozeny pristup.
- Spravne resi prazdny strom:

```java
if (root == null) return 0;
````

- Spravne resi pripad, kdy chybi prava vetev, jak jsme se ostatne bavily :-D

```java
if (root.right == null) return 1 + minDepth(root.left);
```

- Spravne resi aji pripad, kdy chybi leva vetev:

```java
if (root.left == null) return 1 + minDepth(root.right);
```

- Celkova slozitost je dobra:

  * Time: `O(n)`
  * Space: `O(h)`

Kde:

* `n` je pocet nodu ve stromu
* `h` je vyska stromu kvuli rekurzivnimu stacku

## Co bych zlepsil

### 1. Poradi `left` a `right`

Tady:

```java
if (root.right == null) return 1 + minDepth(root.left);
if (root.left == null) return 1 + minDepth(root.right);
```

Prijde mi ze pisu porad to stejny => standardnejsi je kontrolovat nejdriv levou stranu a potom pravou. Stejne jako kdyz pises.

### 2. `else` neni potreba

Tady:

```java
else return 1 + Math.min(minDepth(root.right), minDepth(root.left));
```

`else` neni potreba, protoze predchozi `if` uz vraci hodnotu.

Cistsi je:

```java
return 1 + Math.min(minDepth(root.left), minDepth(root.right));
```

## Lepsi verze

```java
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
```

## Shruti

Fobre reseni. Pekne vyresena hlavni past problemu: `minDepth(null)` se nesmi pouzit jako kandidat, pokud druhy podstrom existuje.

Zlepseni jsou hlavne o stylu! Zase 🤦
