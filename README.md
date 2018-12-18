# Java Word Puzzle Solver

Simple tool that can be used to search words in a dictionary based on a specific set of rules.

You can search words that match any combination of:
- Specific length
- Maximum length
- Minimum length
- Containing characters of a specified set
- Containing at least X number of characters of a specified set
- Containing characters at a specific location

## Examples:

Find all words of length 7:
```java
ArrayList<String> list = wordlist
    .OfLength(7)
    .GetResult();
```

Find all words word of which the third character is a "t":
```java
ArrayList<String> list = wordlist
    .WithCharacterAtPosition("t", 3)
    .GetResult();
```

Find all words that can be made with at least 3 of the letters "a", "r", "p", "z" and "t":
```java
ArrayList<String> list = wordlist
    .ContainsAtLeast(new String[]{"a", "r", "p", "z", "t"}, 3)
    .GetResult();
```

Find all words ending with "ing":

```java
ArrayList<String> list = wordlist
    .WithCharacterAtPosition("i", -3)
    .WithCharacterAtPosition("n", -2)
    .WithCharacterAtPosition("g", -1)
    .GetResult();
```

## Usage

```java
WordsList wordlist = new WordsList();

System.out.println("Returning all words that match the filtering:");

ArrayList<String> list = wordlist
        .OfLength(7)
        .GetResult();

for (String item : list) {
    System.out.println(item);
}

System.out.println("Done! " + list.size() + " words found!");
```
