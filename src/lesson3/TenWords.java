package lesson3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TenWords {
    public static void main(String[] args) {
        String [] stringArray = {"один","два","три","один","два","три", "один","два","три","четыре","пять","шесть","Привет","КВН", "Read","Array"};
        checkWords(stringArray);
    }
    private static void checkWords(String[] arr) {
        List<String> listWords = new ArrayList<>();
        Set <String> setWords = new HashSet<>();

        for (int i=0; i<arr.length;i++){
            listWords.add(arr[i]);
            setWords.add(arr[i]);
        }

        for (String o:setWords){
            int count =0;
            for(String l:listWords)
                if (o.equals(l)){
                count ++;}
            System.out.println(o + " -> " +count+"шт");
        }

    }
}
