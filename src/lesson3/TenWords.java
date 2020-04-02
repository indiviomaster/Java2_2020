package lesson3;

import java.util.*;

public class TenWords {
    public static void main(String[] args) {
        String [] stringArray = {"один","два","три","один","два","три", "один","два","три","четыре","пять","шесть","Привет","КВН", "Read","Array"};
        checkWords(stringArray);
    }
    private static void checkWords(String[] arr) {
        Map<String, Integer> mapWords = new HashMap<>();
        int k=0;
        for (int i=0; i<arr.length;i++){

            if (mapWords.get(arr[i])==null) {
                k = 1;

            }else{
                k = mapWords.get(arr[i]) +1;
            }
            mapWords.put(arr[i], k);
        }
        System.out.println(mapWords);
        }
}
