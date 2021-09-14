package Programers.Kakao.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tuple {
    public ArrayList<Integer> solution(String s) {
        ArrayList <Integer> answer = new ArrayList<>();
        ArrayList <String> tuple = new ArrayList<>();
        int start=0;
        int end=0;

        for(int i=1; i<s.length()-1; i++){
            if(s.charAt(i)=='{'){ start=i+1; }
            if(s.charAt(i)=='}'){
                end=i;
                tuple.add(s.substring(start,end));
            }
        }
        tuple.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        answer.add(Integer.parseInt(tuple.get(0)));
        for(int i=1; i<tuple.size(); i++){
            String[] str = tuple.get(i).split(",");
            for(int j=0; j<str.length; j++){
                if(!answer.contains(Integer.parseInt(str[j]))){
                    answer.add(Integer.parseInt(str[j]));
                    break;
                }
            }
        }

//        while (!tuple.isEmpty()){
//            String temp=tuple.get(0);
//            temp = temp.replace(",","");
//            answer.add(Integer.parseInt(temp));
//            for(int i=0; i<tuple.size(); i++){
//                tuple.set(i,tuple.get(i).replaceFirst(temp,""));
//            }
//            tuple.remove(0);
//        }

        for(int a: answer){
            System.out.println(a);
        }
        return answer;
    }

    public static void main(String[] args) {
        Tuple tuple=new Tuple();
        String s = "{{2,22,33,222},{2},{22,2},{222,2,22}}";
        tuple.solution(s);
    }
}
