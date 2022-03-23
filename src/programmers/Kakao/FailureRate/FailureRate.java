package programmers.Kakao.FailureRate;

import java.util.ArrayList;

public class FailureRate {
    public ArrayList<Integer> solution(int N, int[] stages) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Float> failureRate = new ArrayList<>();
        int p = stages.length;
        int count =0;
        for(int i=0; i<N; i++){
            count =0;
            for(int j=0; j<stages.length; j++){
                if(stages[j]==i+1){ count++; }
            }
            failureRate.add((float)count/p);
            p-=count;
        }
        for(float a: failureRate){
            System.out.print(a+" ");
        }


        for(int i=0; i<failureRate.size(); i++){
            int index=0;
            float max=-999999;
            for(int j=0; j<failureRate.size(); j++) {
                if (max < failureRate.get(j)) {
                    max = failureRate.get(j);
                    index= j;
                }
            }
            answer.add(index+1);
            failureRate.set(index, (float) -99999);
        }

        return answer;

    }

    public static void main(String[] args) {
        FailureRate failureRate = new FailureRate();
        int[] stages= {6,6,6,6,6,6};
        int N=5;
        failureRate.solution(N,stages);
    }
}
