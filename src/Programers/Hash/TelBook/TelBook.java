package Programers.Hash.TelBook;

import java.util.Arrays;
import java.util.HashMap;

public class TelBook {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        HashMap<Integer,String> map = new HashMap<>();
        for(int i=0; i< phone_book.length; i++){
            map.put(i,phone_book[i]);
        }
        for(int i=0; i< phone_book.length-1; i++){
            if(map.get(i+1).length()<map.get(i).length()) continue;
            if(map.get(i+1).substring(0,map.get(i).length()).contentEquals(map.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TelBook telBook = new TelBook();
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(telBook.solution(phone_book));
    }
}
