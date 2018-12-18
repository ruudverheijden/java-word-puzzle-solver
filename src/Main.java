import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        WordsList wordlist = new WordsList();

        System.out.println("Returning all words that match the filtering:");

//        ArrayList<String> list = wordlist
//                .WithCharacterAtPosition("g", -3)
//                .WithCharacterAtPosition("a", -2)
//                .WithCharacterAtPosition("f", -1)
//                .GetResult();
//        ArrayList<String> list = wordlist
//                .ContainsAtLeast(new String[]{"k", "a", "r", "s", "i", "e", "n", "t", "o"}, 9)
//                .OfMinLength(9)
//                .GetResult();

        ArrayList<String> list = wordlist
                .ContainsAtLeast(new String[]{"a", "r", "p", "z", "t"}, 4)
                .GetResult();

        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("Done! " + list.size() + " words found!");
    }
}
