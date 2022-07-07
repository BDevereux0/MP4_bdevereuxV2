import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SpellCheck {
    // We could have also used TreeSet for the dictionary
    private HashSet<String> dictionary = new HashSet<String>();
    private TreeSet<String> miss_spelled_words = new TreeSet<String>();

    public SpellCheck(String dictionaryFile) throws FileNotFoundException {

        Scanner dictionaryScanner = null;
        String wordsFromDictionary;
        try {
            dictionaryScanner = new Scanner(new FileInputStream(dictionaryFile));
            while (dictionaryScanner.hasNextLine()){
                wordsFromDictionary = dictionaryScanner.nextLine();
                dictionary.add(wordsFromDictionary);
            }

        }finally {
            if(dictionaryScanner != null){
                dictionaryScanner.close();
            }
        }

    }

    public void checkSpelling(String fileName) throws FileNotFoundException {
        // Clear miss_spelled_words
        miss_spelled_words.clear();
        System.out.println("======== Spell checking " + fileName + " =========");
        Scanner fileScanner = null;
        String wordsFromFile;

        try{
            // Read in each line from "fileName"
            // For each line, break the line into words using the following StringTokenizer
            //StringTokenizer st = new StringTokenizer(line, " \t,.;:-%'\"");
            //or if you want to use split method
            //String[] words = line.split(" +|\\p{Punct}");
            // lower case each word obtained from the StringTokenizer
            fileScanner = new Scanner(new FileInputStream(fileName));
            while (fileScanner.hasNext()){

                int charValue = 'a';
                wordsFromFile = fileScanner.next();
                // skip word if the first character is not a letter
                    /*if (wordsFromFile.startsWith("1") || wordsFromFile.startsWith("2") || wordsFromFile.startsWith("3")
                        || wordsFromFile.startsWith("4") || wordsFromFile.startsWith("5") || wordsFromFile.startsWith("6")
                            || wordsFromFile.startsWith("7") || wordsFromFile.startsWith("8") || wordsFromFile.startsWith("9")
                            || wordsFromFile.startsWith("0") || wordsFromFile.startsWith("(")){
                       fileScanner.next();
                    }*/
                    if (wordsFromFile.charAt(0) < charValue){
                        fileScanner.next();
                    }else {
                    String[] words = wordsFromFile.toLowerCase().split(" +|\\p{Punct}");
                    for (String x : words) {
                        System.out.println(x);
                    }
                }
            }
        }finally{
            if (fileScanner !=null){
                fileScanner.close();
            }
        }







        // Skip over word if it can be found in either dictionary, or miss_spelled_words
        // If word ends with 's', then try the singular version of the word in the
        // dictionary and miss_spelled_words ... skip if found
        // Print line containing miss-spelled word(make sure you only print it once if
        // multiple miss-spelled words are found on this line)
        // Ask the user if he wants the word added to the dictionary or the miss-spelled
        // words and add word as specified by the user







    }

    public void dump_miss_spelled_words() {
        // Print out the miss-spelled words

    }

    public static void main(String[] args) {
        try {
            SpellCheck spellCheck = new SpellCheck("SpellCheckDocs/Dictionary.txt");

            for (int i = 0; i < args.length; i++) {
                spellCheck.checkSpelling(args[i]);
                spellCheck.dump_miss_spelled_words();
            }
        } catch (

                FileNotFoundException e) {
            System.out.println(e);
        }
    }
}