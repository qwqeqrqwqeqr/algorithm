package dynamicprogramming.triangle;

public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[] sum=new int[triangle.length];

        for(int i=0; i<triangle.length; i++){

        }

        return answer;
    }


    public static void main(String[] args) {
        IntegerTriangle integerTriangle = new IntegerTriangle();

        int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};

        integerTriangle.solution(triangle);
    }
}
