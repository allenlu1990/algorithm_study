package on_test;

import java.util.HashMap;
import java.util.Map;

public class MaxDiverseString {
    public static void main(String[] args) {
        MaxDiverseString maxDiverseString = new MaxDiverseString();
        String solution = maxDiverseString.solution(6, 1, 1);
        System.out.println(solution);
    }

    public String solution(int A, int B, int C){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", A);
        map.put("b", B);
        map.put("c", C);
        StringBuilder stringBuilder = new StringBuilder();
        String cantString ="";
        String letter = null;
        while ((letter = getLetter(map, cantString)) != null){
            if(!cantString.equals("")){
                cantString="";
            }
            stringBuilder.append(letter);
            int length = stringBuilder.length();
            if(length > 1){
                if(stringBuilder.charAt(length-2) == stringBuilder.charAt(length-1)){
                    cantString = String.valueOf(stringBuilder.charAt(length-2));
                }
            }
        }

        return stringBuilder.toString();
    }

    public String getLetter(HashMap<String, Integer> map, String cantString){
        Integer remove = 0;
        if(!cantString.equals("")){
            remove = map.remove(cantString);
        }

        Map.Entry<String, Integer> entry = map.entrySet().stream().reduce((v1, v2) -> v1.getValue() > v2.getValue() ? v1 : v2).get();

        if(!cantString.equals("")){
            map.put(cantString, remove);
        }
        if(entry.getValue() < 1){
            return null;
        }else {
            map.put(entry.getKey(), entry.getValue()-1);
            return entry.getKey();
        }
    }
}
