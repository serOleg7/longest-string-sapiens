package test.java.exercise;

import main.java.exercise.DataMissingException;
import main.java.exercise.LongestString;
import main.java.exercise.LongestStringImpl;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;


public class TestLongestString {
    private final LongestString longestString = new LongestStringImpl();
    private final String validCharacters = "ABCD";
    private final String str1 = "AABCDA";
    private final String str2 = "ABCDZADC";
    private final String str3 = "ABCDBCA";
    private final String str4 = "ABCDABDCA";

    @Test
    public void testLongestString() {
        List<String> listOfStrings = Arrays.asList(str1, str2, str3, str4);
        String res = longestString.getLongestString(listOfStrings, validCharacters);
        assertEquals(str4, res);
    }

    @Test
    public void testLongestString_validCharacters() {
        List<String> listOfStrings = Arrays.asList("ABC", "ABCDE");
        String res = longestString.getLongestString(listOfStrings, validCharacters);
        assertEquals("ABC", res);
    }

    @Test
    public void testLongestString_duplicatedCharacters() {
        List<String> listOfStrings = Arrays.asList("ABC", "ABCCCCC");
        String res = longestString.getLongestString(listOfStrings, validCharacters);
        assertEquals("ABC", res);
    }

    @Test
    public void testLongestString_passNullableStringExpected() {
        List<String> listOfStrings = new ArrayList<>(List.of("ABC"));
        listOfStrings.add(null);
        String res = longestString.getLongestString(listOfStrings, validCharacters);
        assertEquals("ABC", res);
    }

    @Test
    public void testLongestString_DataMissingExceptionExpected() {
        List<String> listOfStrings = Arrays.asList(str1, str2, str3, str4);
        DataMissingException thrown = Assertions.assertThrows(DataMissingException.class, () ->
                longestString.getLongestString(listOfStrings, null));
        Assertions.assertEquals("DataMissingException, you not provided correct data", thrown.getMessage());
    }

    @Test
    public void testGetFirstLongestString() {
        List<String> listOfStrings = Arrays.asList("ABC", "BCD");
        String res = longestString.getLongestString(listOfStrings, validCharacters);
        assertEquals("ABC", res);
    }
}
