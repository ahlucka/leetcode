# Code review - Remove Duplicates from Sorted List

## Co je dobre

- Reseni je spravne. Vyuziva fakt, ze linked list je serazeny.
- Staci porovnavat aktualni node s dalsim nodem.
- Reseni upravuje list in-place.
- Celkova slozitost je optimalni:
  - Time: `O(n)`
  - Space: `O(1)`

## Co bych zlepsil
### 1. Nazev `noDuplicates`

Tahle promenna funguje:

```java
ListNode noDuplicates = head;
````

Ale trochu lepsi nazev by byl:

```java 
ListNode originalHead = head;
```

nebo jeste casteji:

```java
ListNode current = head;
```

V tomto problemu vlastne nepotrebujes extra promennou, pokud misto meneni `head` pouzijes `current`.

### 2. Nemenit `head`, kdyz ho chci vratit

Aktualni reseni si ulozi puvodni `head` do `noDuplicates`, takze je to v poradku.

Cistsi styl je nechat `head` jako navratovou hodnotu a pouzit druhy pointer:
```java
ListNode current = head;
```

Pak na konci muzes jednoduse vratit:
```java
return head;
```

Toto je standardni linked list pattern, prosim ujisti se ze to chapes!!

### 3. Formatovani `else`
Tady:

```java
} else head = head.next;
```
funguje, ale cistsi je pouzit zavorky:

```java
} else {
    head = head.next;
}
```

Porad to stejny - u interview je lepsi mit kod nudny a citelny. Zadny interviewer ti neda extra body za to ze mosel pouzit mozek aby dekodoval tvuj coding style.

## Lepsi verze

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
```

## Jak to funguje

List je serazeny, proto staci kontrolovat:
* aktualni node
* dalsi node

Kdyz maji stejnou hodnotu, aktualni node preskoci dalsi node:
```java
current.next = current.next.next;
```

Kdyz hodnoty nejsou stejne, posuneme se dal.

## Shruti
Zase - dobre reseni. Logika je spravna, slozitost je optimalni - spravne vyuziva to, ze list je serazeny.

Zlepseni jsou hlavne o stylu: pouzit `current` pointer, vratit puvodni `head` a trosku uklidit formatovani.