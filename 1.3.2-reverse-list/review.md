


# Code review - Day 3.2 - Reverse Linked List

## Co je dobre

- Tohle je spravne optimalni reseni.
- Pouziva tri pointery:
  - `curr`
  - `prev`
  - `temp`
- Spravne si ulozi dalsi node pred zmenou `curr.next`.
- Otaci linked list in-place.
- Vraci `prev`, coz je nova hlava listu.
- Celkova slozitost je optimalni:
  - Time: `O(n)`
  - Space: `O(1)`

## Co bych zlepsil

### 1. Nazev `temp`

`temp` je uplne v poradku. V interview by ale jeste jasnejsi bylo:

```java
ListNode nextNode = curr.next;
````

Pak je hned videt, ze si ukladame dalsi node, abychom neztratili zbytek listu. Nazvy promennych je umeni, ale fakt to strasne pomaha!!

### 2. Formatovani returnu

Tady:

```java
return prev;
```

by melo byt zarovnane stejne jako zbytek metody.

Drobnost, ale cisty kod pusobi lip.

## Lepsi verze

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode nextNode = current.next;

            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }
}
```

## Proc to funguje

Prochazime list zleva doprava.

U kazdeho nodu udelame tri veci:

* ulozime si dalsi node
* otocime smer `next`
* posuneme pointery dal

Na konci je `previous` posledni zpracovany node. Ten je nova hlava otoceneho listu.

## Edge cases

* Prazdny list.
* List s jednim nodem.
* List se dvema nody.
* Delsi list, napr. `1 -> 2 -> 3 -> 4 -> 5`.

## Shruti

Tohle je dobre reseni. Algoritmus je spravny, optimalni a presne odpovida tomu, co se v interview ocekava.

Zlepseni jsou hlavne o nazvech promennych a ujistit se ze jsi schopny vysvetlit pointer swaps krok za krokem, to by asi bylo to nejdulezitejsi na celem interview.