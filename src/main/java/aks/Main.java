package aks;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Encrypter encrypter = new Encrypter();


        List<String> cipher = encrypter.encryptWords("bcd,senku,CRISTIANO", "abd");
        for(String s : cipher){
            System.out.println(s);
        }
    }
}