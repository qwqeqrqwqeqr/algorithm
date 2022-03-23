package programmers.Greedy.BoatProblem;


public class BoatProblem {
    public int solution(int[] people, int limit) {
        if(people.length<1||people.length>500000)
            return 0;
        if(limit<40||limit>240)
            return 0;
        for (int person : people) {
            if (person < 40 || person > 240) {
                return 0;
            }
        }
        int count =0;  //answer
        int limitTemp;
        int weightIndex;

        for (int i =0; i<people.length; i++){
            limitTemp=limit;
            if(people[i]==0) continue;
            limitTemp=limitTemp-people[i];
            people[i]=0;
            if(limitTemp==0) {
                count++;
                continue;
            }
            weightIndex=i;  //0
            for (int j=i+1; j<people.length ; j++){
                   if(limitTemp-people[j]<limit-people[weightIndex]&&limitTemp-people[j]>=0){
                       weightIndex=j;
                   }
            }  //select the people make most benefit
            people[weightIndex]=0;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        BoatProblem boatProblem = new BoatProblem();
        int[] people= {40,60,80,50,100,100,90,50,50};
        int limit=100;
        System.out.println(boatProblem.solution(people,limit));
    }
}
