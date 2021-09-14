package Programers.ect.Budget;

import java.util.Arrays;

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
       for(int i=0; i<d.length; i++){
           if(d[i]<=budget){
               budget-=d[i];
               answer++;
           }
       }
        return answer;
    }

    public static void main(String[] args) {
        Budget budget = new Budget();
        int[] d = {1,3,2,5,4};
        int b = 9;
        budget.solution(d,b);
    }
}

//            System.out.println("includeY  "+includeY);
//            System.out.println("includeN  "+includeN );
//            System.out.println("count:  " + count + "  temp:  " + temp);