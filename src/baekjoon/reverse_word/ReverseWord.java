package baekjoon.ReverseWord;


import java.util.Scanner;

public class ReverseWord {
    String solution(String string){
        StringBuffer reverse = new StringBuffer();
        StringBuffer answer = new StringBuffer();
        int flag =0;

        for(int i=0; i<string.length(); i++){
            char C = string.charAt(i);
            if(i==string.length()-1&&flag==0){
                reverse.append(C);
                answer.append(reverse.reverse());
                continue;
            }
            if(flag==0 && C==' '){
                answer.append(reverse.reverse());
                reverse.delete(0,reverse.length());
                answer.append(C);
                continue;
            }
            else if(flag ==0 && C=='<'){
                answer.append(reverse.reverse());
                reverse.delete(0,reverse.length());
                answer.append(C);
                flag=1;
                continue;
            }
            if(flag==0){ reverse.append(C); }
            if(flag==1 && C=='>'){
                answer.append(C);
                flag=0;
                continue;
            }
            else if(flag==1){ answer.append(C); }

        }
        return String.valueOf(answer);
    }


    public static void main(String[] args) {
        ReverseWord reverseWord =new ReverseWord();
        Scanner scanner = new Scanner(System.in);
        System.out.println(reverseWord.solution("baekjoon online judge"));
    }
}
//**********BaekJoon Format for submission************//
//import java.util.Scanner;
//public class Main {
//    String solution(String string){
//        StringBuffer reverse = new StringBuffer();
//        StringBuffer answer = new StringBuffer();
//        int flag =0;
//
//        for(int i=0; i<string.length(); i++){
//            char C = string.charAt(i);
//            if(i==string.length()-1&&flag==0){
//                reverse.append(C);
//                answer.append(reverse.reverse());
//                continue;
//            }
//            if(flag==0 && C==' '){
//                answer.append(reverse.reverse());
//                reverse.delete(0,reverse.length());
//                answer.append(C);
//                continue;
//            }
//            else if(flag ==0 && C=='<'){
//                answer.append(reverse.reverse());
//                reverse.delete(0,reverse.length());
//                answer.append(C);
//                flag=1;
//                continue;
//            }
//            if(flag==0){ reverse.append(C); }
//            if(flag==1 && C=='>'){
//                answer.append(C);
//                flag=0;
//                continue;
//            }
//            else if(flag==1){ answer.append(C); }
//
//        }
//        return String.valueOf(answer);
//    }
//
//
//    public static void main(String[] args) {
//        Main m =new Main();
//        Scanner scanner = new Scanner(System.in);
//        String string=scanner.nextLine();
//        System.out.println(m.solution(string));
//    }
//}
