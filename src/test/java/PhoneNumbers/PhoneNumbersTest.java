package PhoneNumbers;

import junit.framework.Assert;
import mockit.Mock;
import mockit.MockUp;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

import java.io.PrintWriter;
import java.util.*;

//call with -javaagent:C:\Users\Admin\.m2\repository\com\googlecode\jmockit\jmockit\1.7\jmockit-1.7.jar
public class PhoneNumbersTest {

    @Test
    public void doPhoneNumbers_test1() {
        new MockUp<Scanner>() {
            private String[] inputs = new String[] {"7325189087", "it", "your", "reality", "real", "our"};
            private int currIndex = 0;

            @SuppressWarnings("unused")
            @Mock(invocations = 6)
            public String next() {
                return (currIndex < inputs.length) ? inputs[currIndex++] : null;
            }

            @SuppressWarnings("unused")
            @Mock(invocations = 1)
            public int nextInt() {
                return 5;
            }
        };

        new MockUp<PrintWriter>() {

            private StringBuilder contentToFlush = new StringBuilder();

            @SuppressWarnings("unused")
            @Mock(invocations = 3)
            public void print(String s) {
                contentToFlush.append(s);
            }

            @SuppressWarnings("unused")
            @Mock(invocations = 1)
            public void flush() {
                String content = contentToFlush.toString();
                assertEquals("real it your", content);
                System.out.println(content);
            }
        };

        PhoneNumbers.doPhoneNumbers();
    }

    @Test
    public void doPhoneNumbers_test2() {
        new MockUp<Scanner>() {
            private String[] inputs = new String[] {"77123237213", "price", "be", "paid", "your", "another", "fault", "destiny"};
            private int currIndex = 0;

            @SuppressWarnings("unused")
            @Mock(invocations = 8)
            public String next() {
                return (currIndex < inputs.length) ? inputs[currIndex++] : null;
            }

            @SuppressWarnings("unused")
            @Mock(invocations = 1)
            public int nextInt() {
                return 7;
            }
        };

        new MockUp<PrintWriter>() {

            private StringBuilder contentToFlush = new StringBuilder();

            @SuppressWarnings("unused")
            @Mock(invocations = 3)
            public void print(String s) {
                contentToFlush.append(s);
            }

            @SuppressWarnings("unused")
            @Mock(invocations = 1)
            public void flush() {
                String content = contentToFlush.toString();
                assertEquals("price be paid", content);
                System.out.println(content);
            }
        };

        PhoneNumbers.doPhoneNumbers();
    }

    @Test
    public void getSentenceRepresenation_test() {
        Map<Integer, Set<String>> words1 = new HashMap<Integer, Set<String>>() {{
            put(0, createSet("A"));
            put(1, createSet("BBB"));
            put(2, createSet("CCC"));
            put(5, createSet("DD"));
        }};
        List<String> list1 = createList("No solution.");
        assertEquals(list1, PhoneNumbers.getSentenceRepresentation(words1, 7));

        Map<Integer, Set<String>> words2 = new HashMap<Integer, Set<String>>() {{
            put(0, createSet("AA"));
            put(2, createSet("BBBBBB"));
            put(2, createSet("CCCC"));
            put(6, createSet("DDDD"));
        }};
        List<String> list2 = createList("AA", "CCCC", "DDDD");
        assertEquals(list2, PhoneNumbers.getSentenceRepresentation(words2, 10));

        Map<Integer, Set<String>> words3 = new HashMap<Integer, Set<String>>() {{
            put(0, createSet("AAA"));
            put(2, createSet("BBBBBB"));
            put(8, createSet("CC"));
        }};
        List<String> list3 = createList("No solution.");
        assertEquals(list3, PhoneNumbers.getSentenceRepresentation(words3, 10));
    }

    @Test
    public void getAllSubstringIndexes_test() {
        String string = "18732518908718";
        String subString = "18";
        List<Integer> indexes = PhoneNumbers.getAllSubstringIndexes(string, subString);
        assertEquals(createList(0, 6, 12), indexes);
    }

    private Set<String> createSet(final String... words) {
        return new LinkedHashSet<String>() {{
            for (String str: words)
                add(str);
        }};
    }

    private <T> List<T> createList(final T... words) {
        return new LinkedList<T>() {{
            for (T str: words)
                add(str);
        }};
    }
}