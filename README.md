# leetcode

## week 1 - first one

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

[reseni](https://leetcode.com/problems/intersection-of-two-arrays/submissions/2043536289)

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

### 4.1 merge two binary trees

0ms, beats 100.00%

[reseni](https://leetcode.com/problems/merge-two-binary-trees/submissions/2045703483)

zase rekursivni struktura kde se budto sectou, nebo kdyz je jeden node null tak se tam da ten druhej node (ktery muze taky byt null ale nemusi)

### 4.2 path sum

0ms, beats 100.00%

[reseni](https://leetcode.com/problems/path-sum/submissions/2045791477)

jako vzdycky s linkedlistama, tak je to rekursivni, ale sum se nescita, spis se odecita kazdy node od targetu

### 5.1 convert sorted array to BST

0ms, beats 100.00%

[reseni](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/2046666192)

pouzil jsem mid podobne jako v binary search na to, aby byly obe strany vyrovnany a pak jsem to sestavil

### 5.2 min depth of binary tree

4 ms, beats 69.21%

[reseni](https://leetcode.com/problems/minimum-depth-of-binary-tree/submissions/2046669536)

to co mi chybelo tak je to, ze musim checknout kolik ma node deti, kdyz je napriklad .left null, tak se zkontroluje jenom leva strana atd

## week 3

### 1.1 fizz buzz

1 ms, beats 99.87%

[reseni](https://leetcode.com/problems/fizz-buzz/submissions/2050009735)

normalni for loop ktery nejdriv checkne jestli je to delitelny 3, jestli jo tak to zkusi 5 atd

### 1.2 climb stairs

0 ms, beats 100.00%

[reseni](https://leetcode.com/problems/climbing-stairs/submissions/2050255987)

po te co jsem si uvedomil ze to je fibonacci, tak jsem proste udelal fibonacci od 1 az do n

### 2.1 roman to integer

2 ms, beats 100.00%

[reseni](https://leetcode.com/problems/roman-to-integer/submissions/2051074903)

nejdriv jsem udelal novou array ktera mela ty znaky ze stringu prevedeny na cisla, a pak jsem to prosel jeste jednou a pricetl budto cislo, nebo (cislo + 1) - cislo, pokud bylo cislo mensi nez cislo + 1. tenhl pristup mi prisel lehci a hezci nez abych to prosel a mel tisic if statementu podle toho jestli je I pred V atd

### 3.1 is subsequence

2 ms, beats 71.95%

[reseni](https://leetcode.com/problems/is-subsequence/submissions/2052518414)

myslim ze to je two pointer approach ale nejsem si 100% jisty

### 4.1 intersection of two arrays REVISITED

3 ms, beats 48.06%

[reseni](https://leetcode.com/problems/intersection-of-two-arrays/submissions/2053484528)

misto arraylistu jsem pouzil dva hashsety a zjistil jsem, ze existuje .retainAll funkce ktera udela presne to co jsem potreboval

### 4.2 unique email addresses REVISITED

28 ms, beats 7.52%

[reseni](https://leetcode.com/problems/unique-email-addresses/submissions/2053485775)

pouzil jsem regex jak jsi chtel, replaceAll funguje presne jak jsem chtel, ale je to HODNE pomaly, mnohem pomalejsi nez kdyz jsem to vyresil predtim

### 5.1 merge two binary trees REVISITED

0 ms, beats 100.00%

[reseni](https://leetcode.com/problems/merge-two-binary-trees/submissions/2054842855)

nevim co presne zadani znamena ale upravil jsem to, takze je to ted in place a min pametove narocny

## week 4

### 1.1 longest consecutive sequence

32 ms, beats 37.27%

[reseni](https://leetcode.com/problems/longest-consecutive-sequence/submissions/2058046943)

nejdriv je potreba udelat hashset (takze se nemusim starat o to, ze budou cisla dvakrat), potom projdu hashset, a pokazde kdyz neni cislo o jedno mensi nez cislo n (to znamena, ze je zacatek sekvence) tak zacnu pocitat kolik cisel je v sekvenci. myslim si ze to je O(n), to po mne chteli

### 2.1 two sum ii

2 ms, beats 95.80%

[reseni](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/2059169710)

je to v podstate takovy binary search ale misto toho aby se to posunulo na mid (O(logn)) tak se to posune o jedno, takze to je O(n), coz chteli

### 3.1 validate BST

0 ms, beats 100.00%

[reseni](https://leetcode.com/problems/validate-binary-search-tree/submissions/2061643453)

### 4.1 Kth largest element in array

71 ms, beats 29.44%

[resen](https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/2061704612)

musel jsem se naucit co je priorityqueue, ale uz to chapu, prida to tam a zorganizuje to podle parametru (defaultne podle velikosti) a kdyz je delka toho queue delsi nez k tak to vyhodi to nejmensi protoze to to nemuze byt. pak to returnne to nejmensi. asi to neni nejefektivnejsi kdyz to ostatni udelali rychleji ale nevim jak to udelat jinak bez sortovani zele arraye 