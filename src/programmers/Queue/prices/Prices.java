package programmers.queue.prices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

class Solution {
    public ArrayList<Integer> solution(int[] prices) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<prices.length-2; i++) {
            for(int j=i+1; j< prices.length-1; j++){
                if(prices[i]>prices[j]){
                    answer.add(j-i);
                    break;
                }
            }
            answer.add(prices.length-1-i);
        }
        answer.add(0);

        System.out.println(answer);
        return answer;
    }




    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        Solution solution = new Solution();
        solution.solution(prices);

    }
}