package baekjoon.WeddingCeremony;

import java.util.ArrayList;
import java.util.HashSet;

public class WeddingCeremony {
    int solution(int len, int[][] relation) {
        int answer;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        for (int i = 0; i < len; i++) {
            if (relation[i][0] == 1) {
                hashSet.add(relation[i][1]);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>(hashSet);
        for (int i = 0; i < len; i++) {
            for (int j=0; j<arrayList.size(); j++) {
                if (relation[i][0] == arrayList.get(j) && !arrayList.contains(relation[i][1])) {
                    hashSet.add(relation[i][1]);
                }
            }
        }
        if(hashSet.size()==0){ return  0; }
        answer = hashSet.size()-1;
        return answer;
    }

    public static void main(String[] args) {
        WeddingCeremony weddingCeremony =new WeddingCeremony();
        int len1 =5;
        int [][] relation1 = {{1,2},{1,3},{3,4},{2,3},{4,5}};
        weddingCeremony.solution(len1,relation1);
        int len2 =5;
        int [][] relation2 = {{2,3},{3,4},{4,5},{5,6},{2,5}};
        weddingCeremony.solution(len2,relation2);
        int len3 =6;
        int [][] relation3 = {{1,2},{1,3},{2,5},{2,4},{3,1},{4,6}};
        weddingCeremony.solution(len3,relation3);
        int len4 =4;
        int [][] relation4 = {{1,5},{2,3},{3,4},{3,5}};
        weddingCeremony.solution(len4,relation4);
        int len5 =2;
        int [][] relation5 = {{1,1},{2,3}};
        weddingCeremony.solution(len5,relation5);
        int len6 =5;
        int [][] relation6 = {{1,2},{2,2},{2,3},{3,2},{3,4}};
        weddingCeremony.solution(len6,relation6);
    }
}
