import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class WordsList {
    private ArrayList<String> result = new ArrayList<String>();

    WordsList() {
        String dictionaryPathName = "./dictionaries/OpenTaal-210G-basis-gekeurd.txt";
        ArrayList<String> fullList = new ArrayList<String>();

        // Add all words to an arraylist
        try {
            Scanner scanner = new Scanner(new File(dictionaryPathName));

            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                fullList.add(nextLine);
            }

            scanner.close();

            // Start with the full list of words
            this.result = fullList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Filter on words of a specific length
    public WordsList OfLength(int length) {
        ArrayList output = new ArrayList<String>();

        for (String item : this.result) {
            if (item.length() == length) {
                output.add(item);
            }
        }

        this.result = output;
        return this;
    }

    // Filter on words of less than a maximum length
    public WordsList OfMaxLength(int length) {
        ArrayList output = new ArrayList<String>();

        for (String item : this.result) {
            if (item.length() <= length) {
                output.add(item);
            }
        }

        this.result = output;
        return this;
    }

    // Filter on words of less than a minimum length
    public WordsList OfMinLength(int length) {
        ArrayList output = new ArrayList<String>();

        for (String item : this.result) {
            if (item.length() >= length) {
                output.add(item);
            }
        }

        this.result = output;
        return this;
    }

    // Filter on words with only a specific character
    public WordsList WithCharacters(String character) {
        ArrayList output = new ArrayList<String>();

        for (String item : this.result) {
            if (item.contains(character)) {
                output.add(item);
            }
        }

        this.result = output;
        return this;
    }

    // Filter words that can be made with these characters and use at least X number of unique characters
    public WordsList ContainsAtLeast(String[] characters, int useAtLeastCharacters) {
        ArrayList output = new ArrayList<String>();

        for (String item : this.result) {
            int counter = 0;

            for (String character : characters) {
                if (item.contains(character)) {
                    counter++;
                }

                if (counter >= useAtLeastCharacters) {
                    output.add(item);
                    break;
                }
            }

        }

        this.result = output;
        return this;

    }

    // Filter words that have a specific character at a specific position (can be negative to start from the end)
    public WordsList WithCharacterAtPosition(String character, int position) {
        ArrayList output = new ArrayList<String>();
        int startPosition;
        int endPosition;

        for (String item : this.result) {
            // Translate negative positions (counting backwards from last character)
            if (position < 0) {
                startPosition = item.length() + position;
                endPosition = item.length() + position + 1;
            } else {
                startPosition = position - 1;
                endPosition = position;
            }

            if (startPosition > 0 &&
                    endPosition <= item.length() &&
                    item.substring(startPosition, endPosition).equals(character)) {
                output.add(item);
            }
        }

        this.result = output;
        return this;
    }

    public ArrayList<String> GetResult() {
        return this.result;
    }
}
