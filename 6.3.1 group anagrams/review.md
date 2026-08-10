# Code review - Group Anagrams
## Co je dobre
- Hlavni algoritmus je spravny.
- Pole s 26 pocty vytvori stejny klic pro vsechny anagramy.
- `HashMap` je dobra volba pro ukladani skupin.
- `computeIfAbsent` drzi kod kratky.
- Pokud je `n` pocet slov a `k` maximalni delka slova, casova slozitost je O(n * k).

## Co bych zlepsil
- Nazev `letterCounts` neni uplne presny. Mapa uklada skupiny slov. `groupsByCount` by asi byl jasnejsi.
- V popisu slozitosti je pouzito `S`, ale neni vysvetleno. Na pohovoru vzdy rekni, co promenna znamena.
- `Arrays.toString(count)` vytvari delsi klic. Je to ale jednoduche a spravne reseni pro pohovor.

## (Trosku) lepsi verze (ale ne o moc)
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupsByCount = new HashMap<>();

        for (String word : strs) {
            int[] counts = new int[26];

            for (char letter : word.toCharArray()) {
                counts[letter - 'a']++;
            }

            String key = Arrays.toString(counts);
            groupsByCount
                    .computeIfAbsent(key, unused -> new ArrayList<>())
                    .add(word);
        }

        return new ArrayList<>(groupsByCount.values());
    }
}
```

## Shruti
Algoritmus je spravny a efektivni! Parada.
