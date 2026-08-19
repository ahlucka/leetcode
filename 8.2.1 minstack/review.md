# Code review - Min Stack

## Co je dobre

- Hlavni algoritmus je spravny, druhy zasobnik umozni vratit minimum bez prochazeni vsech hodnot.
- `minStack` uklada aktualni minimum pro kazdou uroven hlavniho zasobniku.
- Kod spravne pracuje i s duplicitnimi minimalnimi hodnotami.
- `push`, `pop`, `top` a `getMin` maji casovou slozitost O(1).

## Co bych zlepsil

- `Stack` je starsi Java trida. Pro novy kod je obvykle lepsi `Deque` s `ArrayDeque`.
- Soucasny `minStack` uklada jednu hodnotu pri kazdem `push`. Je to spravne, ale staci do nej ukladat jen nova minima.
- ‼️ Pri ukladani jen novych minim je dulezite pouzit `<=`. Jinak by duplicita minima po jednom `pop` zmizela prilis brzy.

## Shruti

Reseni je algoritmicky spravne a pro pohovor vhodne. Lepsi verze by pouzila moderni Java zasobnik a uklada mene kopii.