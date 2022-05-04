package programmers.greedy.camera;

import java.util.Arrays;
import java.util.Comparator;

public class Camera {
        public int solution(int[][] routes) {
            int answer = 1;
            int max =0; int maxIndex =1; int size=0;
            Arrays.sort(routes, (o1, o2) -> {
                if(o1[1] == o2[1]){return Integer.compare(o1[0],o2[0]);}
                else {return Integer.compare(o1[1],o2[1]);}});

            while (size<routes.length){
                max= routes[0][1];
                for(int i=maxIndex; i< routes.length; i++){
                    if(max>routes[i][0]){size++;}
                    else {break;}
                }
                maxIndex = size;
                max = routes[maxIndex][1];

            }



            return answer;
        }
//        -20  -15
//        -18  -13
//        -14  -5
//        -5   -3

//    15 20
//    10 50
//    40 60
    public static void main(String[] args) {
        Camera camera = new Camera();
        int[][] array ={{10,50},{15,20},{40,60}};
        System.out.println(camera.solution(array));
    }
}
