# leetcode

## week 1

### 1.1. two sum

2 ms, beats 99.39%

[reseni](https://leetcode.com/problems/two-sum/solutions/8334956/two-sum-by-adamh943-aiig)

hashmap, kdyz nenajde v hashmape x, ktery = target - nums[i] tak prida (nums[i], i) do hashmapy a pokracuje. je to rychlejsi nez dva for loopy protoze to projde arrayji maximalne jednou

### 1.2 reverse string

0 ms, beats 100.00%

[reseni](https://leetcode.com/problems/reverse-string/solutions/8336314/reverse-string-by-adamh943-i57o)

spravil jsem to a ted to pouziva dva pointery

### 2.1 stocks

1 ms, beats 99.93%

[reseni](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/2034882480)

jsou dve promeny, jedna trackuje nejmensi cenu a jedna trackuje profit, protoze chci co nejmensi cenu ale co nejvetsi profit

### 3.1 valid parentheses

4 ms, beats 38.84%

[reseni](https://leetcode.com/problems/valid-parentheses/solutions/8340343/valid-parentheses-by-adamh943-gmh4)

pouzil jsem stack protoze potrebuji abych porovnal posledni character s nejnovejsim

### 3.2 reverse linked list

0 ms, beats 100.00%

[reseni](https://leetcode.com/problems/reverse-linked-list/solutions/8340446/reverse-linked-list-by-adamh943-o765)

udelal jsem ze si to 4 promeny predavaji dokud nebude current null, protoze to znamena konec listu

### 4.1 binary search

0 ms, beats 100.00%

[reseni](https://leetcode.com/problems/binary-search/solutions/8341903/binary-search-by-adamh943-r30f)

klasickej binary search tak jsem dal middle ktery se budke posune nahoru nebo dolu podle toho jestli je vetsi nebo mensi nez target

### 4.2 subtree of another tree

3 ms, beats 67.79%

[reseni](https://leetcode.com/problems/subtree-of-another-tree/solutions/8344650/subtree-of-another-tree-by-adamh943-7sdx)

musel jsem si toho vyhledat hodne ale pouzil jsem depth-first search a prohledal jsem vsechny mozny vetve

### 5.1 last stone weight

2 ms, beats 35.38%

[reseni](https://leetcode.com/problems/last-stone-weight/submissions/2038697797)

udelal jsem loop ktery to sorti od nejvetsi po nejmensi a pak budto zmeni dva nejvetsi elementy na 0, nebo x element na 0 a y element na y - x

### 5.2 max depth of binary tree

0 ms, beats 100.00%

[reseni](https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/2038797249)

zase recursive loop ktery udela max z leve a z prave a pak prida 1 aby se zapocital prvni node

## week 2

### 1.1 intersection of two arrays

5 ms, beats 28.17%

[reseni](https://leetcode.com/problems/intersection-of-two-arrays/submissions/2043536289}

pouzil hashset (protoze se to postara o duplikaty) a pak pridaval ty intersekce do arraylistu ktery jsem nakonec prevedl na array protoze to funkce vyzaduje. musim se priznat ze nevim jak to udelat rychlejsi

### 1.2 unique email addresses

9 ms, beats 84.35%

[reseni](https://leetcode.com/problems/unique-email-addresses/submissions/2043569345)

vytvoril hashset (protoze nebudou duplikaty), potom rozdelil email na local name a domain name, protoze kdyz budu mazat tecky tak at jsou smazany jenom v local name, potom to pravidlo s +, a pak to spojil dohromady a pridal do hashsetu

### 2.1 first unique char

15 ms, beats 51.48%

[reseni](https://leetcode.com/problems/first-unique-character-in-a-string/submissions/2043686300)

kdyz je charakter na indexu ktery je stejny jako prvni a posledni index toho charakteru tak to znamena ze v tom stringu musi byt jedinej

### 2.2 remove duplicates from sorted list

0 ms, beats 100.00%

[reseni](https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/2044560619)

zjistil jsem jestli jsou current value a next value stejny, kdyz jo, tak se .next zmeni na .next.next, az nakonec bude .next/.next.next nulll, a pak to skonci

### 3.1 move zeroes

3 ms, beats 18.95%

[reseni](https://leetcode.com/problems/move-zeroes/submissions/2044841435)

mam index na kterym je prvni nula, na ktery se posuna kazda ne-nulta cislice

### 3.2 search insert position

0 ms, beats 100.00%

[reseni](https://leetcode.com/problems/search-insert-position/submissions/2044840312)

chtelo to O(logn) coz znamena binary search, jedina zmena je ze taky musim checknout jestli target neexistuje v arrayi coz znamena ze jestli target sedi mezi nums[mid - 1] a nums[mid + 1] tak je output mid
