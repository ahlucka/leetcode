# Code review - Unique Email Addresses

## Co je dobre

- Reseni pouziva `HashSet`, coz je spravna datova struktura.
- `HashSet` automaticky odstrani duplicity.
- Kod spravne rozdeluje email na:
  - local cast
  - domain cast
- Spravne odstranuje tecky z local casti.
- Spravne ignoruje vse za `+` v local casti.
- Vysledek vraci jako `set.size()`, coz je presne to, co problem chce.
- Celkova slozitost je dobra:
  - Time: `O(n * k)`
  - Space: `O(n * k)`

Kde:
- `n` je pocet emailu
- `k` je prumerna delka emailu

## Co bych zlepsil

### 1. `indexOf('@')` se vola dvakrat

Ted kod dela:

```java
String local = emails[i].substring(0, emails[i].indexOf('@'));
String domain = emails[i].substring(emails[i].indexOf('@'));
````

Funguje to, ale je cistsi ulozit si pozici `@` do promenne.

```java
int atIndex = email.indexOf('@');
```

Pak ji pouzijes dvakrat bez opakovani.

### 2. `contains()` pred `replace()` neni potreba

Tady:

```java
if (local.contains(".")) local = local.replace(".", "");
```

`replace(".", "")` funguje i kdyz tam zadna tecka neni.

Takze muze byt jednoduse:

```java
local = local.replace(".", "");
```

Stajne jak minule - mene kodu, stejny vysledek a mensi pravdepodobnost chyby.

### 3. For-each loop by byl citelnejsi

Ted se pouziva index:

```java
for (int i = 0; i < emails.length; i++)
```

Ale index neni potreba.

Cistsi je:

```java
for (String email : emails)
```

### 4. Poradi uprav local casti

Aktualni poradi funguje:

1. odstranit tecky
2. odriznout vse po `+`

Ale o trochu efektivnejsi je nejdriv odriznout `+`, a az potom odstranit tecky.

Proc?

Kdyz je email treba:

```text
a.b+c.d.e@test.com
```

cast po `+` se stejne zahodi, tak nema smysl v ni nejdriv mazat tecky.

Neni to chyba. Jen optimalizace ktera ukaze ze o tom premyslis.

## Lepsi verze

```java
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            int atIndex = email.indexOf('@');

            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex);

            int plusIndex = local.indexOf('+');

            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            local = local.replace(".", "");

            uniqueEmails.add(local + domain);
        }

        return uniqueEmails.size();
    }
}
```

## Shruti

Zase dobre reseni. Logika je spravna a pouziti `HashSet` je presne to, co je optimalni reseni. Spravne reseni je postavene na obecnym principu nejdriv data normalizovat, pak nechat neco (`HashSet` v tomto pripade) udelat zbytek.
