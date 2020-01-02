package week;

import java.util.HashMap;

public class CountCharacters {

    public static void main(String[] args) {
        String[] words = new String[]{};
        System.out.println(countCharacters(words, "aa"));
    }
    public static int countCharacters(String[] words, String chars) {
        int countWord = 0;
        int[] wh = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            int index = chars.charAt(i) - 'a';
            wh[index] = wh[index] + 1;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>(100);
        for (String word : words) {
            boolean succeed = true;
            hashMap.clear();
            for (int i = 0; i < word.length(); i++) {
                if (hashMap.containsKey(word.charAt(i))) {
                    hashMap.put(word.charAt(i), hashMap.get(word.charAt(i))+ 1);
                } else {
                    hashMap.put(word.charAt(i), 1);
                }
            }
            for (Character character : hashMap.keySet()) {
                if (wh[character - 'a'] < hashMap.get(character)) {
                    succeed = false;
                    break;
                }
            }
            if (succeed) {
                countWord += word.length();
            }

        }
        return countWord;
    }
}
