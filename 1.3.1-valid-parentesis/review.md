# Code review - Day 3.1 - Valid Parentheses

## Co je dobre

- Reseni pouziva `Stack`, coz je pro tenhle problem spravny pristup.
- Spravne kontroluje, jestli zaviraci zavorka odpovida posledni otevrene zavorce.
- Pouziva `peek()` a `pop()` spravnym zpusobem.
- Na konci spravne vraci `symbols.isEmpty()`.
- Celkova slozitost je dobra:
  - Time: `O(n)`
  - Space: `O(n)`

## Co bych zlepsil

### 1. Kod je trochu opakovany

Asi nejvetsi problem. Stejna logika se opakuje pro `)`, `]` a `}`. Funguje to, ale v interview to nevypada uplne profi a interviewer by to flaggnul.

Ted je tam hodne vetveni:
```java
if (s.charAt(i) == ')') {
    ...
} else if (s.charAt(i) == ']') {
    ...
} else if (s.charAt(i) == '}') {
    ...
}
````

Da se to zjednodusit.

### 2. Zaviraci zavorka muze rovnou vratit false

Kdyz prijde zaviraci zavorka a stack je prazdny, vysledek uz musi byt `false`.

Napr:

```java
")"
```

Neni potreba nic dalsiho resit.

### 3. Pouzit `Deque` misto `Stack`

V Jave se dnes casteji doporucuje pouzit `Deque<Character>` misto `Stack<Character>`.

`Stack` funguje, ale je starsi trida. Interviewer to nemusi resit, ale `Deque` vypada vice profi :-D.

### 4. Nazev `symbols`

Nazev je v poradku. Jeste presnejsi by bylo treba:

```java
Deque<Character> stack = new ArrayDeque<>();
```

Neni to velka vec.

## Lepsi verze

```java
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}
```

## Shruti

Dobre reseni. Algoritmus je spravny a pouziva spravnou datovou strukturu.

Hlavni zlepseni je VYRAZNE zjednodusit vetveni a vracet `false` hned, kdyz uz je jasne, ze string nemuze byt validni. Kod pak vypada mene jako pavouk a vice jako interview-ready reseni. 

Tomuto se rika **spaghetti code** :-D a interviewer by to pravdepodobne flagnul jako interview finding.