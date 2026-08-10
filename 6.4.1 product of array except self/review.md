# Code review - Product of Array Except Self

## Co je dobre
- Hlavni algoritmus je spravny a optimalni.
- Reseni nepouziva deleni.
- Prvni pruchod uklada soucin hodnot vlevo, druhy prida soucin hodnot vpravo.
- Casova slozitost je O(n).

## Co bych zlepsil
- `Arrays.fill(answer, 1)` dela jeden cely pruchod navic. Neni to chyba, ale neni to potreba‼️‼️
- Staci nastavit `answer[0]` na `1`. Zbytek pole zapise prvni smycka.
- V popisu slozitosti je O(S). Pro pole delky `n` je spravne a jasnejsi O(n).
- Na pohovoru bys rekl, ze vystupni pole se nepocita do pomocneho prostoru.

## (zase jenom o trosicku) lepsi verze
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        answer[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }
}
```


## Shruti
Tohle je ocekavane a optimalni reseni pro pohovor. Hlavni zlepseni je uklid kodu. Dva pruchody staci.