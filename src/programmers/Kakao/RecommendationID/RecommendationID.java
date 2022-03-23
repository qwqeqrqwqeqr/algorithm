package programmers.Kakao.RecommendationID;

public class RecommendationID {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<new_id.length(); i++){
            int index=new_id.charAt(i);
          if(index==95||index==45|| index==46||
                  (index>=48&&index<=57)||
                  (index>=97&&index<=122)){
              stringBuffer.append(new_id.charAt(i));
          }
        }
       new_id = String.valueOf(stringBuffer);
       new_id= replaceMark(new_id,stringBuffer);

       new_id=removeMark(new_id);
       new_id=checkLengthZero(new_id);
       new_id=checkLength16(new_id);
       new_id=checkLength2(new_id,stringBuffer);
        return new_id;
    }
    String replaceMark(String new_id,StringBuffer stringBuffer){
        int count =0;
        stringBuffer.delete(0,stringBuffer.length());
        for(int i=0; i<new_id.length(); i++){
            if(new_id.charAt(i)==46){ count++; }
            else{
                if(count>=1){
                    stringBuffer.append(".");
                    stringBuffer.append(new_id.charAt(i));
                    count=0;
                }
                else {
                    stringBuffer.append(new_id.charAt(i));
                }
            }
        }
        if(count>=1) stringBuffer.append(".");
        return String.valueOf(stringBuffer);
    }
    String checkLength2(String new_id,StringBuffer stringBuffer){
        if(new_id.length()<=2){
            int count=new_id.length();
            char lastIndex= new_id.charAt(new_id.length()-1);
            stringBuffer.delete(0,stringBuffer.length());
            stringBuffer.append(new_id);
            while(count<3){
                stringBuffer.append(lastIndex);
                count++;
            }
            return String.valueOf(stringBuffer);
        }
        return new_id;
    }
    String checkLength16(String new_id){
        if(new_id.length()>=16){
            new_id=new_id.substring(0,15);
            new_id=removeMark(new_id);
        }
        return new_id;
    }
    String checkLengthZero(String new_id){
        if(new_id.length()==0) { return "a"; }
        return new_id;
    }
    String removeMark(String new_id){
        if(new_id.charAt(0)==46) {
            new_id = new_id.substring(1, new_id.length());
        }
        new_id = checkLengthZero(new_id);
        if(new_id.charAt(new_id.length()-1)==46){
            new_id= new_id.substring(0,new_id.length()-1);
        }
        return  new_id;
    }

    public static void main(String[] args) {
        RecommendationID recommendationID= new RecommendationID();
        String string= "abcdefghijklmn.p";
        System.out.println(recommendationID.solution(string));
    }
}
