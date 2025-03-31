package org.neetcode150.arraysAndHashing;

import java.util.*;

public class EncodeDecodeStrings_premium {

    /*
        Problem Statement: Encode and decode a string. Array of strings is given
        Intuition: append each string with strLength and a special character to encode.
        Time Complexity: O(m) for each encode and decode
        Space Complexity: O(m + n) for both functions
     */
    public String encode(List<String> strs) {
        StringBuilder enc = new StringBuilder();

        for (String str : strs) {
            enc.append(str.length()).append((char) 128).append(str);
        }

        return enc.toString();
    }

    public List<String> decode(String str) {
        List<String> dec = new ArrayList<>();
        int start = 0;

        while (start < str.length()) {
            int end = start;
            while (str.charAt(end) != (char) 128) {
                end++;
            }
            int len = Integer.parseInt(str.substring(start, end));

            start = end + 1;
            end = start + len;
            dec.add(str.substring(start, end));

            start = end;
        }

        return dec;
    }

    public static void main(String[] args) {
        EncodeDecodeStrings_premium codec = new EncodeDecodeStrings_premium();
        List<String> input = Arrays.asList("hello", "world", "encode", "decode", "123");

        // Encoding
        String encoded = codec.encode(input);
        System.out.println("Encoded: " + encoded);

        // Decoding
        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded);

        // Checking correctness
        System.out.println("Is decoding correct? " + input.equals(decoded));
    }
}
