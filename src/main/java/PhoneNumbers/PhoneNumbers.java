package PhoneNumbers;

import java.io.PrintWriter;
import java.util.*;

public class PhoneNumbers {

    private final static Map<Character, Character> charToCypher = new HashMap<Character, Character>();
    /**
     * The key of the map is the start index in phone string, value is all words that maps from that index
     */
    private final static Map<Integer, Set<String>> words = new HashMap<Integer, Set<String>>();

    private final static List<String> NO_RESULT_LIST = new LinkedList<String>() {{ add("No solution."); }};

    static  {
        charToCypher.put('i', '1'); charToCypher.put('j', '1');
        charToCypher.put('a', '2'); charToCypher.put('b', '2'); charToCypher.put('c', '2');
        charToCypher.put('d', '3'); charToCypher.put('e', '3'); charToCypher.put('f', '3');
        charToCypher.put('g', '4'); charToCypher.put('h', '4');
        charToCypher.put('k', '5'); charToCypher.put('l', '5');
        charToCypher.put('m', '6'); charToCypher.put('n', '6');
        charToCypher.put('p', '7'); charToCypher.put('r', '7'); charToCypher.put('s', '7');
        charToCypher.put('t', '8'); charToCypher.put('u', '8'); charToCypher.put('v', '8');
        charToCypher.put('w', '9'); charToCypher.put('x', '9'); charToCypher.put('y', '9');
        charToCypher.put('o', '0'); charToCypher.put('q', '0'); charToCypher.put('z', '0');
    }

    public static void main(String[] args) {
        doPhoneNumbers();
    }

    protected static void doPhoneNumbers() {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String phone = in.next();
        Integer dictionarySize = in.nextInt();
        for (int i = 0; i < dictionarySize; i++) {
            String word = in.next();
            String number = convertWordToNumber(word);
            List<Integer> indexes = getAllSubstringIndexes(phone, number);
            for (int startInd : indexes)
                addWord(startInd, word);
        }

        List<String> sentence = getSentenceRepresentation(phone.length());
        Iterator<String> itr = sentence.iterator();
        while (itr.hasNext()) {
            String echo = itr.next();
            echo = (itr.hasNext()) ? echo + " " : echo;
            out.print(echo);
        }
        out.flush();
    }

    private static List<String> getSentenceRepresentation(int phoneLength) {
        return getSentenceRepresentation(words, phoneLength);
    }

    protected static List<String> getSentenceRepresentation(Map<Integer, Set<String>> words, int phoneLength) {
        int[] indexes = new int[phoneLength];
        for (int i = 0; i < indexes.length; i++)
            indexes[i] = -1;

        final boolean findSentence = tryFindSentence(words, indexes, 0, 0, phoneLength);
        if (findSentence) {
            return reproduceSentence(words, indexes, phoneLength);
        } else return NO_RESULT_LIST;
    }

    /**
     * Iterate through all the combinations and return {@code true} if the is at least one combination which maps {@code phone}
     * with help of {@code words} dictionary. If the function returns {@code true} we can use {@code indexes} array to reproduce
     * the sentence.
     * @param words dictionary of words. Each of those words can 'map' a part of the phone number
     * @param indexes an array of intermediate results
     * @param startIndOfCurrWord startIndex of words which we checks at the moment. By checks I mean that we try to map the {@code phone}
     *                           with sentence that includes the word.
     * @param currWordNumberInOrder the serial number of the word in the sentence.
     * @param phoneLength amount of cyphers in the phone number
     * @return {@code true} if we can map {@code phone} into sentence, {@code false} otherwise.
     */
    private static boolean tryFindSentence(final Map<Integer, Set<String>> words, final int[] indexes, int startIndOfCurrWord, int currWordNumberInOrder, final int phoneLength) {
        Set<String> wordsByIndex = words.get(startIndOfCurrWord);
        if (startIndOfCurrWord >= phoneLength || wordsByIndex == null || wordsByIndex.isEmpty())
            return false;
        indexes[currWordNumberInOrder] = startIndOfCurrWord;
        for (String word : wordsByIndex) {
            if (word.length() == phoneLength - startIndOfCurrWord) { //we've found the last word in the sentence
                for (int i = currWordNumberInOrder + 1; i < indexes.length; i++)
                    indexes[i] = -1;
                return true;
            }
            boolean findSentence = tryFindSentence(words, indexes, startIndOfCurrWord + word.length(), currWordNumberInOrder + 1, phoneLength);
            if (findSentence) return true;
        }
        return false;
    }

    private static List<String> reproduceSentence(final Map<Integer, Set<String>> words, final int[] indexes, int phoneLength) {
        List<String> sentence = new LinkedList<String>();
        for (int i = 0; i < indexes.length && indexes[i] != -1; i++) {
            int startIndex = indexes[i];
            int endIndex = (indexes[i + 1] == -1) ? phoneLength : indexes[i + 1];
            int wordLength = endIndex - startIndex;
            String nextWord = getWord(words, startIndex, wordLength);
            if (nextWord == null) throw new IllegalStateException("NextWord can't be null");
            sentence.add(nextWord);
        }
        return sentence;
    }

    private static String convertWordToNumber(String word) {
        char[] num = new char[word.length()];
        int numPointer = 0;
        for (char cypher : word.toCharArray())
            num[numPointer++] = charToCypher.get(cypher);
        return new String(num);
    }

    protected static List<Integer> getAllSubstringIndexes(String string, String substring) {
        List<Integer> indexes = new LinkedList<Integer>();
        for (int startIndex = 0, index = string.indexOf(substring, startIndex); index != -1; index = string.indexOf(substring, startIndex)) {
            startIndex = index + 1;
            indexes.add(index);
        }
        return indexes;
    }

    private static void addWord(Integer index, String word) {
        if (words.get(index) == null)
            words.put(index, new HashSet<String>());
        Set<String> wordsByIndex = words.get(index);
        for (String str: wordsByIndex) // check for equal word
            if (str.length() == word.length())
                return;
        wordsByIndex.add(word);
    }

    protected static String getWord(final Map<Integer, Set<String>> words, int startIndex, int length) {
        Set<String> wordsByIndex = words.get(startIndex);
        if (wordsByIndex == null || wordsByIndex.isEmpty())
            return null;
        for (String word : wordsByIndex)
            if (word.length() == length)
                return word;
        return null;
    }
}
