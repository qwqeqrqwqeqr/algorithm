package programmers.kakao.parentheses_conversion;

public class ParenthesesConversion {
    final char LEFT = '(';
    final char RIGHT = ')';

    public String solution(String p) {
        String answer = "";
        answer = Conversion(p);
        return answer;
    }

    private String Conversion(String w) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        if (w.length() == 0) {
            return w;
        }
        int count = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == LEFT) {
                count += 1;
            } else if (w.charAt(i) == RIGHT) {
                count -= 1;
            }
            u.append(w.charAt(i));
            if (count == 0) {
                for (int j = i + 1; j < w.length(); j++) {
                    v.append(w.charAt(j));
                }
                break;
            }
        }
        if (CheckCorrectStr(String.valueOf(u))) {
            String conversionV = Conversion(String.valueOf(v));
            return u + conversionV;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LEFT);
            stringBuilder.append(Conversion(String.valueOf(v)));
            stringBuilder.append(RIGHT);
            u.delete(0, 1);
            u.delete(u.length() - 1, u.length());
            stringBuilder.append(ReverseStr(u));
            return String.valueOf(stringBuilder);
        }
    }

    private String ReverseStr(StringBuilder stringBuilder) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            if(stringBuilder.charAt(i)==LEFT){
                stringBuilder.replace(i,i+1, String.valueOf(RIGHT));
            }
            else {
                stringBuilder.replace(i,i+1, String.valueOf(LEFT));
            }
        }
        return String.valueOf(stringBuilder);
    }

    private Boolean CheckCorrectStr(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == LEFT) {
                count += 1;
            } else if (string.charAt(i) == RIGHT) {
                count -= 1;
            }
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ParenthesesConversion parenthesesConversion = new ParenthesesConversion();
        String answer = parenthesesConversion.solution("()))((()");
        System.out.println(answer);
    }


}
