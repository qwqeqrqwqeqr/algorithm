package programmers.Kakao.CraneGame;

public class CraneGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int count=0;
        int arr[] = new int[moves.length];
        int stack=0;
        for(int i=0; i<moves.length; i++) {
            for (int j = 0; j < board[moves[i]-1].length ; j++) {
                if (board[j][moves[i]-1] != 0) {
                    arr[stack] = board[j][moves[i]-1];
                    stack++;
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
            if(stack>1) {
                if (arr[stack - 1] == arr[stack - 2]) {
                    answer=answer+2;
                    stack = stack - 2;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
         int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
         int[] moves = {1,5,3,5,1,2,1,4};
         CraneGame craneGame = new CraneGame();
         System.out.println(craneGame.solution(board,moves));
     }
}
