package Programers.ect.Rectangle;

public class Rectangle {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        int x= v[0][0];
        int y= v[0][1];

        if(x==v[1][0]){
            x=v[2][0];
        }
        else if(x==v[2][0]) {
            x=v[1][0];
        }
        else{
            x=v[0][0];
        }

        if(y==v[1][1]){
            y=v[2][1];
        }
        else if(y==v[2][1]) {
            y=v[1][1];
        }
        else{
            y=v[0][1];
        }

        answer[0]=x;
        answer[1]=y;

        return answer;
    }

    public static void main(String[] args) {
        int[][] v= {{1,4},{3,4},{3,10}};
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.solution(v)[1]);
    }
}
