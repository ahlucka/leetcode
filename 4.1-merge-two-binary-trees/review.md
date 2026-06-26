# Code review - Merge Two Binary Trees

## Co je dobre

- Reseni je spravne.
- Pouziva rekurzi, coz je pro tento problem nejcistsi pristup.
- Spravne vytvari novy node se souctem hodnot:

```java
TreeNode merged = new TreeNode(root1.val + root2.val);
```
- Celkova slozitost je dobra:
  * Time: `O(n)`
  * Space: `O(h)`

Kde:
* `n` je pocet nodu, ktere projdeme
* `h` je vyska stromu kvuli rekurzivnimu stacku

## Co bych zlepsil

### 1. `else if` neni potreba

Tady:

```java
if (root1 == null) return root2;
else if (root2 == null) return root1;
```

`else if` funguje, ale neni potreba.

Cistsi je:

```java
if (root1 == null) return root2;
if (root2 == null) return root1;
```

Kdyz prvni `if` vrati hodnotu, dalsi kod uz se stejne nespusti.

### 2. Formatovani base cases

Jednoradkove `if` je v poradku, ale pro interview je casto citelnejsi pouzit zavorky:

```java
if (root1 == null) {
    return root2;
}

if (root2 == null) {
    return root1;
}
```

Neni to algoritmicka zmena. Jen cistsi styl, na ten se v lepsich firmach hodne hraje!

## Lepsi verze - novy strom

```java
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);

        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);

        return merged;
    }
}
```

## Alternativni verze - in-place

```java
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }
}
```

## Slozitost

### Tva verze

* Time: `O(n)`
* Space: `O(n)` pro nove nody
* Plus rekurzivni stack: `O(h)`

### In-place verze

* Time: `O(n)`
* Space: `O(h)`

Kde:

* `n` je pocet nodu ve sloucenem stromu
* `h` je vyska stromu

## Jak to funguje

Na kazdem mistě porovname nody z obou stromu.

* Pokud jeden node chybi, vratime ten druhy.
* Pokud existuji oba, vytvorime node se souctem hodnot.
* Pak stejne mergujeme levou a pravou vetev.

Rekurze tak postupne slozi cely merged strom od korene az dolu.

## Shruti

Dobre reseni. Je spravne, citelne a rekurze dava smysl.

Zlepseni jsou opet hlavne o stylu. Nezapomen, ze se te interviewer muze zeptat na rozdil mezi vytvorenim noveho stromu a in-place upravou.