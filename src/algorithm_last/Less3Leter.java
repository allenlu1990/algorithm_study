package algorithm_last;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author allen
 * @date 2021年11月26日 13:32
 */
public class Less3Leter {
    public static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("A", 7);
        map.put("B", 3);
        map.put("C", 1);
        String solution = solution();
        System.out.println(solution);

    }

    public static String solution(){
        String letter =null;
        String string ="";
        boolean flag = false;
        while ((letter = getMaxNumberLetter(flag, letter)) != null){
            string += letter;
            flag = judge(string);
        }
        return string;

    }

    private static String getMaxNumberLetter(boolean flag, String currentLetter){
        Integer remove = null;
        if(flag) {
             remove = map.remove(currentLetter);
        }

        String letter = map.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if(letter != null){
            Integer number = map.get(letter)-1;
            map.put(letter, number);
        }

        if(flag) {
            map.put(currentLetter, remove);
        }

        return letter;
    }

    private static boolean judge(String string){

        if(string.length() >1 &&(string.charAt(string.length()-1) == string.charAt(string.length()-2))){
            return true;
        }else {
            return false;
        }
    }


}
