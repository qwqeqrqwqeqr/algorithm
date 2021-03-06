package programmers.sort.k_number;

import java.util.Arrays;

public class K_Number {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] temp = new int[array.length];
        for(int i=0; i<commands.length; i++){
            int index=0;
            int from=commands[i][0];
            int to = commands[i][1];
            Arrays.fill(temp,99999);
            for(int j=from-1; j<to; j++){
                temp[index]=array[j];
                index++;
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];

        }
        return answer;
    }

    public static void main(String[] args) {
        K_Number k_stNumber = new K_Number();
        int[] array ={1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
        int[] answer=k_stNumber.solution(array,commands);
        for(int a : answer){
            System.out.println(a);
        }
    }
}
