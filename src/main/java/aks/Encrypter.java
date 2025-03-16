package aks;

import java.util.ArrayList;
import java.util.List;

public class Encrypter {
    static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
    List<String> encryptWords(String plainText, String key){

        // make a list from plainText
        List<String> wordsList = new ArrayList<>();
        for(String word : plainText.split(",")){
            if(word.length() < key.length()) throw new ArrayIndexOutOfBoundsException("Encryption key must NOT be longer than the Plain Text (for now at least)");
            wordsList.add(word.toLowerCase());
        }

        // cipher list
        List<String> list = new ArrayList<>();        
        // encrypt
        for(String word : wordsList){
            int keyCharIndex = 0;
            char[] wordChars = word.toCharArray();
            char[] keyChars = key.toCharArray();
            StringBuilder sb = new StringBuilder();

            for(char c : wordChars){

                if(keyCharIndex >= key.length()){
                    keyCharIndex = 0;
                }
                int shift = ALPHABET.indexOf(c) + ALPHABET.indexOf(keyChars[keyCharIndex]) + 1;
                if(shift >= ALPHABET.length()){
                    shift -= ALPHABET.length();
                }
                char cipherChar = ALPHABET.charAt(shift);
                sb.append(cipherChar);

                keyCharIndex++;
            }
            list.add(sb.toString());
        }

        return list;
    }

    List<String> decryptWords(String cipher, String key){

        // List of encrypted words
        List<String> cipherList = new ArrayList<>();
        for(String word : cipher.split(",")){
            if(word.length() < key.length()) throw new ArrayIndexOutOfBoundsException("Encryption key must NOT be longer than the Plain Text (for now at least)");
            cipherList.add(word.toLowerCase());
        }

        List<String> decryptedWords = new ArrayList<>();

        // decrypt
        for(String word : cipher.split(",")){
            int keyIndex = 0;
            StringBuilder decryptedWord = new StringBuilder();
            char[] wordChars = word.toCharArray();

            for(char c : wordChars){

                if(keyIndex >= key.length()){
                    keyIndex = 0;
                }
                int shift = ALPHABET.indexOf(c) - (ALPHABET.indexOf(key.charAt(keyIndex)) + 1);
                if(shift < 0){
                    shift = ALPHABET.length() + shift;
                }
                keyIndex++;
                
                decryptedWord.append(ALPHABET.charAt(shift));
            }

            decryptedWords.add(decryptedWord.toString());
        }

        return decryptedWords;
    }
}
