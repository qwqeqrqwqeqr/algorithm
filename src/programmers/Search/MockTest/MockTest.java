package programmers.Search.MockTest;

import java.util.ArrayList;


public class MockTest {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> solution = new ArrayList<>();
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        arrayList.add(0);
        arrayList.add(0);
        arrayList.add(0);

        for(int i=0; i<answers.length; i++){
            if(p1[i%5]==answers[i]){
                int temp = arrayList.get(0);
                arrayList.set(0,++temp);
            }
            if(p2[i%8]==answers[i]){
                int temp = arrayList.get(1);
                arrayList.set(1,++temp);
            }
            if(p3[i%10]==answers[i]){
                int temp = arrayList.get(2);
                arrayList.set(2,++temp);
            }
        }
        int max = arrayList.get(0);
        solution.add(1);
        for(int i=1; i<3; i++){
            if(max<arrayList.get(i)){
                solution.clear();
                solution.add(i+1);
                max=arrayList.get(i);
            }
            else if(max==arrayList.get(i)){
                solution.add(i+1);
            }
        }
        for(int a : solution){
            System.out.println(solution);
        }
        return solution;
    }

    public static void main(String[] args) {
        MockTest mockTest = new MockTest();
        int[] answer ={1,3,2,4,2};
        mockTest.solution(answer);
    }
}
