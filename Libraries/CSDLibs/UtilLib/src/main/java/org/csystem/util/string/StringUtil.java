/*-------------------------------------------------------------
	FILE		: StringUtil.java
	AUTHOR		: Java-Nov-2023 Group
	Last UPDATE	: 7th May 2024

	Utility class for string operations

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package org.csystem.util.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.random.RandomGenerator;

public final class StringUtil {
    private static final String LETTERS_EN;
    private static final String LETTERS_TR;
    private static final String CAPITAL_LETTERS_EN;
    private static final String CAPITAL_LETTERS_TR;
    private static final String ALL_LETTERS_TR;
    private static final String ALL_LETTERS_EN;

    static {
        LETTERS_EN = "abcdefghijklmnopqrstuvwxyz";
        LETTERS_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
        CAPITAL_LETTERS_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        CAPITAL_LETTERS_TR = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";
        ALL_LETTERS_TR = LETTERS_TR + CAPITAL_LETTERS_TR;
        ALL_LETTERS_EN = LETTERS_EN + CAPITAL_LETTERS_EN;
    }

    private StringUtil()
    {}
    public static boolean areAllUnique(String s)
    {
        var set = new HashSet<Character>();

        for (var i = 0; i < s.length(); ++i)
            set.add(s.charAt(i));

        return s.length() == set.size();

    }
    public static String capitalize(String s)
    {
        return s.isEmpty() ? "" : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String changeCase(String s)
    {
        var sb = new StringBuilder(s);
        var len = s.length();

        for (var i = 0; i < len; ++i) {
            var c = sb.charAt(i);

            sb.setCharAt(i, Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }

        return sb.toString();
    }

    public static int countString(String s1, String s2)
    {
        var count = 0;

        for (var index = 0; (index = s1.indexOf(s2, index)) != -1; ++index, ++count)
            ;

        return count;
    }

    public static int countStringIgnoreCase(String s1, String s2)
    {
        return countString(s1.toLowerCase(), s2.toLowerCase());
    }

    public static String generateRandomText(RandomGenerator randomGenerator, int count, String sourceText)
    {
        var sb = new StringBuilder(count);
        var sourceTextLen = sourceText.length();

        for (var i = 0; i < count; ++i)
            sb.append(sourceText.charAt(randomGenerator.nextInt(sourceTextLen)));

        return sb.toString();
    }

    public static String generateRandomTextEN(RandomGenerator randomGenerator, int count)
    {
        return generateRandomText(randomGenerator, count, ALL_LETTERS_EN);
    }

    public static String generateRandomTextTR(RandomGenerator randomGenerator, int count)
    {
        return generateRandomText(randomGenerator, count, ALL_LETTERS_TR);
    }

    public static String [] generateRandomTexts(RandomGenerator randomGenerator, int count, int min, int bound, String sourceText)
    {
        var str = new String[count];

        for (var i = 0; i < count; ++i)
            str[i] = generateRandomText(randomGenerator, randomGenerator.nextInt(min, bound), sourceText);

        return str;
    }

    public static String [] generateRandomTextsTR(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        return generateRandomTexts(randomGenerator, count, min, bound, ALL_LETTERS_TR);
    }

    public static String [] generateRandomTextsEN(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        return generateRandomTexts(randomGenerator, count, min, bound, ALL_LETTERS_EN);
    }

    public static String getFirstLongestPalindrome(String s)
    {
        var result = "";

        var begin = 0;

        while (begin != s.length()) {
            var end = s.length();

            while (begin != end) {
                var str = s.substring(begin, end--);

                if (str.length() >= 2 && isPalindrome(str) && result.length() < str.length())
                    result = str;
            }
            ++begin;
        }

        return result;
    }

    public static String getLastLongestPalindrome(String s)
    {
        var result = "";

        var end = s.length();

        while (end != 0) {
            var begin = 0;

            while (begin != end) {
                var str = s.substring(begin++, end);

                if (str.length() >= 2 && isPalindrome(str) && result.length() < str.length())
                    result = str;
            }
            --end;
        }

        return result;
    }

    public static String getFirstShortestPalindrome(String s)
    {
        var result = s;

        var begin = 0;

        while (begin != s.length()) {
            var end = s.length();

            while (begin != end) {
                var str = s.substring(begin, end--);

                if (str.length() >= 2 && isPalindrome(str) && str.length() < result.length())
                    result = str;
            }
            ++begin;
        }

        return result;

    }

    public static String getLastShortestPalindrome(String s)
    {
        var result = s;

        var end = s.length();

        while (end != 0) {
            var begin = 0;

            while (begin != end) {
                var str = s.substring(begin++, end);

                if (str.length() >= 2 && isPalindrome(str) && str.length() < result.length())
                    result = str;
            }
            --end;
        }

        return result;
    }


    public static String getFirstPangramTR(String s)
    {
        var result = s;

        var begin = 0;

        while (begin != s.length()) {
            var end = s.length();

            while (begin != end) {
                var str = s.substring(begin, end--);

                if (str.length() >= 29 && isPangramTR(str) && str.length() < result.length())
                    result = str;
            }
            ++begin;
        }

        return result;
    }

    public static String getLastPangramTR(String s)
    {
        var result = s;

        var end = s.length();

        while (end != 0) {
            var begin = 0;

            while (begin != end) {
                var str = s.substring(begin++, end);

                if (str.length() >= 29 && isPangramTR(str) && str.length() < result.length())
                    result = str;
            }
            --end;
        }

        return result;
    }

    public static String getFirstPangramEN(String s)
    {
        var result = s;

        var begin = 0;

        while (begin != s.length()) {
            var end = s.length();

            while (begin != end) {
                var str = s.substring(begin, end--);

                if (str.length() >= 26 && isPangramEN(str) && str.length() < result.length())
                    result = str;
            }
            ++begin;
        }

        return result;
    }

    public static String getLastPangramEN(String s)
    {
        var result = s;

        var end = s.length();

        while (end != 0) {
            var begin = 0;

            while (begin != end) {
                var str = s.substring(begin++, end);

                if (str.length() >= 26 && isPangramEN(str) && str.length() < result.length())
                    result = str;
            }
            --end;
        }

        return result;
    }


    public static boolean isAnagram(String s1, String s2)
    {
        if (s1.length() != s2.length())
            return false;

        var count1 = 0;
        var count2 = 0;
        var len = s1.length();

        for (var i = 0; i < len; ++i) {
            if (s2.indexOf(s1.charAt(i)) == -1)
                return false;

            ++count1;
        }

        for (var i = 0; i < len; ++i) {
            if (s1.indexOf(s2.charAt(i)) == -1)
                return false;

            ++count2;
        }

        return count1 == count2;
    }

    public static boolean isIdentifier(String s)
    {
        if (s.isBlank() || s.equals("_"))
            return false;

        if (!Character.isJavaIdentifierStart(s.charAt(0)))
            return false;

        var len = s.length();

        for (var i = 1; i < len; ++i)
            if (!Character.isJavaIdentifierPart(s.charAt(i)))
                return false;

        return true;
    }

    public static boolean isPalindrome(String s)
    {
        var left = 0;
        var right = s.length() - 1;
        var result = true;

        while (left < right) {
            var cLeft = Character.toLowerCase(s.charAt(left));

            if (!Character.isLetter(cLeft)) {
                ++left;
                continue;
            }

            var cRight = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetter(cRight)) {
                --right;
                continue;
            }

            if (cLeft != cRight) {
                result = false;
                break;
            }

            --right;
            ++left;
        }

        return result;
    }

    public static boolean isPangram(String s, String alphabet)
    {
        var len = alphabet.length();

        for (var i = 0; i < len; ++i) {
            var c = alphabet.charAt(i);

            if (s.indexOf(c) == -1)
                return false;
        }

        return true;
    }

    public static boolean isPangramEN(String s)
    {
        return isPangram(s.toLowerCase(), LETTERS_EN);
    }

    public static boolean isPangramTR(String s)
    {
        return isPangram(s.toLowerCase(), LETTERS_TR);
    }

    public static String join(String [] str, char separator)
    {
        return join(str, String.valueOf(separator));
    }

    public static String join(String [] str, String separator)
    {
        var sb = new StringBuilder();

        for (var s : str)
            sb.append(s).append(separator);

        return sb.substring(0, sb.length() - separator.length());
    }

    public static String join(ArrayList<String> list, String separator)
    {
        var sb = new StringBuilder();

        for (var s : list)
            sb.append(s).append(separator);

        return sb.substring(0, sb.length() - separator.length());
    }

    public static String join(ArrayList<String> list, char separator)
    {
        return join(list, String.valueOf(separator));
    }

    public static String padLeading(String s, int len, char ch)
    {
        var length = s.length();

        return len <= length ? s : (ch + "").repeat(len - length) + s;
    }

    public static String padLeading(String s, int len)
    {
        return padLeading(s, len, ' ');
    }

    public static String padTrailing(String s,  int len, char ch)
    {
        var length = s.length();

        return len <= length ? s : s + (ch + "").repeat(len - length);
    }

    public static String padTrailing(String s, int len)
    {
        return padTrailing(s, len, ' ');
    }

    public static String reverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }

    public static String [] split(String s, String separators)
    {
        return split(s, separators, false);
    }

    public static String [] split(String s, String separators, boolean removeEmpties)
    {
        var regexBuilder = new StringBuilder("[");

        for (var i = 0; i < separators.length(); ++i) {
            var c = separators.charAt(i);

            if (c == ']' || c == '[')
                regexBuilder.append('\\');

            regexBuilder.append(c);
        }

        regexBuilder.append("]");

        if (removeEmpties)
            regexBuilder.append("+");

        return s.split(regexBuilder.toString());
    }

    public static String squeeze(String s1, String s2)
    {
        var sb = new StringBuilder();
        var len = s1.length();

        for (var i = 0; i < len; ++i) {
            var c = s1.charAt(i);

            if (!s2.contains(String.valueOf(c)))
                sb.append(c);
        }

        return sb.toString();
    }

    public static String trimLeading(String s)
    {
        int i;
        var len = s.length();

        for (i = 0; i < len && Character.isWhitespace(s.charAt(i)); ++i)
            ;

        return s.substring(i);
    }

    public static String trimTrailing(String s)
    {
        int i;

        for (i = s.length() - 1; i >= 0 && Character.isWhitespace(s.charAt(i)); --i)
            ;

        return s.substring(0, i + 1);
    }

    public static String wrapWith(String s, char c)
    {
        return wrapWith(s, String.valueOf(c));
    }

    public static String wrapWith(String s, String str)
    {
        return wrapWith(s, str, str);
    }

    public static String wrapWith(String s, char prefix, char suffix)
    {
        return wrapWith(s, String.valueOf(prefix), String.valueOf(suffix));
    }

    public static String wrapWith(String s, String prefix, String suffix)
    {
        return String.format("%s%s%s", prefix, s, suffix);
    }
}
