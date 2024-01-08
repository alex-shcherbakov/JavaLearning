package org.example;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Decoder {
    public static String decodeVowels(String input) {
        return input
                .replace("1", "a")
                .replace("2", "e")
                .replace("3", "i")
                .replace("4", "o")
                .replace("5", "u");
    }

    public static String decodeConsonants(String input) {
        StringBuilder decoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char decodedChar = (char) (c - 1);
                decoded.append(decodedChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }

    public static String decodeMessage(String message) {
        StringBuilder decodedMessage = new StringBuilder();
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(message);

        while (matcher.find()) {
            String word = matcher.group();
            if (word.contains("1") || word.contains("2") || word.contains("3") || word.contains("4") || word.contains("5")) {
                decodedMessage.append(decodeVowels(word));
            } else {
                decodedMessage.append(decodeConsonants(word));
            }
            if (matcher.end() < message.length()) {
                decodedMessage.append(message.charAt(matcher.end()));
            }
        }
        return decodedMessage.toString();
    }
}
