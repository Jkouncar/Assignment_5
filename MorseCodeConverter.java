import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utility class for Morse code conversion.
 */
public class MorseCodeConverter {
    static MorseCodeTree mcodetree = new MorseCodeTree();

    /**
     * Constructor
     */
    public MorseCodeConverter() {
    }

    /**
     * Returns a string with all the data in the tree in LNR order with a space in between them.
     * Uses the LNRoutputTraversal method in MorseCodeTree.
     *
     * @return The data in the tree in LNR order separated by a space.
     */
    public static String printTree() {
        StringBuilder result = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        mcodetree.LNRoutputTraversal(mcodetree.getRoot(), list);
        list.forEach(data -> result.append(data).append(" "));
        return result.toString().trim();
    }

    /**
     * Converts Morse code into English.
     *
     * @param code The Morse code.
     * @return The English translation.
     */
    public static String convertToEnglish(String code) {
        String[] words = code.split(" / ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                String translation = mcodetree.fetch(letter);
                if (translation != null) {
                    result.append(translation);
                } else {
                    // Handle unknown Morse code
                    result.append("?");
                }
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    /**
     * Converts a file of Morse code into English.
     *
     * @param codeFile The file that contains Morse Code.
     * @return The English translation of the file.
     * @throws FileNotFoundException If the file is not found.
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(codeFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append(" ");
            }
        }
        return convertToEnglish(result.toString().trim());
    }
}
