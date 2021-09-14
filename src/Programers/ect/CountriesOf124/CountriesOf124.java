package Programers.ect.CountriesOf124;

import java.util.ArrayList;

public class CountriesOf124 {
    public String solution(int n) {
        String answer = "";
        ArrayList<String> arrayList= new ArrayList<>();
        arrayList.add("0");
        arrayList.add("1"); arrayList.add("2"); arrayList.add("4");
        int len=2;
        int total=4;
        char first='A';
        int count =0;
        return answer;
    }

    public static void main(String[] args) {
        CountriesOf124 countriesOf124 = new CountriesOf124();
        int n = 82;
        countriesOf124.solution(n);
    }

}
/*
1 A
2 B
3 C
4 AA
5 AB
6 AC
7 BA
8 BB
9 BC
10 CA
11 CB
12 CC
13 AAA
14 AAB
15 AAC
16 ABA
17 ABB
18 ABC
19 ACA
20 ACB
21 ACC



 */