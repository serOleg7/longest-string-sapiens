package main.java.exercise;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestStringImpl implements LongestString {


    /**
     * @return a first longest string, better way to call it getFirstLongestString
     */
    @Override
    public String getLongestString(List<String> listOfStrings, String listOfCharacters) {
        if (listOfStrings == null || listOfCharacters == null)
            throw new DataMissingException();
        String res = "";
        int length = 0;
        Set<Character> validCharacters = listOfCharacters.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        for (String str : listOfStrings)
            if (str != null && isValidString(str, validCharacters))
                if (str.length() > length) {
                    res = str;
                    length = str.length();
                }

        return res;
    }

    private boolean isValidString(String str, Set<Character> validCharacters) {
        //TODO check if two string with the same length?
        char tmp = ' ';
        for (int i = 0; i < str.length(); i++) {
            if (!validCharacters.contains(str.charAt(i)) || tmp == str.charAt(i))
                return false;
            tmp = str.charAt(i);
        }

        return true;
    }
}
