package programmers.greedy.uniform;

public class Uniform {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j< reserve.length; j++) {
                if(lost[i]==reserve[j]){
                    answer++;
                    lost[i]=-100;
                    reserve[j]=-200;
                }
            }
        }
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j< reserve.length; j++){
               if(lost[i]+1== reserve[j]||lost[i]-1==reserve[j]){
                   reserve[j]=-200;
                   answer++;
                   break;
               }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Uniform uniform = new Uniform();
        int n=5;
        int[] lost ={1,2,4,5};
        int[] reverse= {2,3,4};
        System.out.println(uniform.solution(n,lost,reverse));
    }
}
