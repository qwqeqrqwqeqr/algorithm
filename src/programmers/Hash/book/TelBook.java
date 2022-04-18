package programmers.hash.book;

import java.util.Arrays;
import java.util.HashMap;

public class TelBook {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        HashMap<Integer,String> map = new HashMap<>();
        for(int i=0; i< phone_book.length; i++){
            map.put(i,phone_book[i]);
        } //map에 전부 데이터를 저장
        for(int i=0; i< phone_book.length-1; i++){
            if(map.get(i+1).length()<map.get(i).length()) continue; //뒤에 나오는 map이 길이가 더 짧으면 다음꺼 진행
            if(map.get(i+1).substring(0,map.get(i).length()).contentEquals(map.get(i))) {  //길이에 포함이 된다면 return을 시켜버린다
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TelBook telBook = new TelBook();
        String[] phone_book = {"119",  "1195524421", "97674223"};
        System.out.println(telBook.solution(phone_book));
    }
}
