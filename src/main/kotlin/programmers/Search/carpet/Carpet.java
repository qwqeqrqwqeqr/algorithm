package programmers.Search.carpet;

class Carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        if (brown >= 8 && brown <= 5000 && yellow >= 1 && yellow <= 2000000) {
            int sum = brown + yellow;  //갈색타일과 노란타일의 합
            for (int i = 1; i <= 100000; i++) {  //이쯤하면 되지 않을까?
                for (int j = 1; j < i; j++) {
                    if (sum == i * j) {  //가로세로곱이 똑같을 떄
                        if((i-2)*(j-2)==yellow){  //노란타일의 개수 구하는 공식
                            answer[0] =i; //가로
                            answer[1] =j; //세로
                            return answer;
                        }
                    }
                }
                if (sum == i * i) { //위 공식으로는 구할수없는 solution들
                    answer[0] = i; //가로
                    answer[1] = i; //세로
                    return answer;
                }
            }
        }
        return answer;
    }
}