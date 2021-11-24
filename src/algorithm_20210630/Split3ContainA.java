package algorithm_20210630;

/**
 * @author allen
 * @date 2021年11月24日 11:43
 * 字符串分成三份，要求每份中含有‘a’的个数是一样的，得出有多少种分法
 */
public class Split3ContainA {
    public static void main(String[] args) {
        String test ="ababa";
        int solution = solution(test);
        System.out.println(solution);
    }

    public static int solution(String s){
        int length = s.length();
        int count =0;
        for(int i =1; i<length-1; i++ ){
            String first = s.substring(0, i);
            for(int j = i+1; j < length; j++){
                String second = s.substring(i, j);
                String third = s.substring(j);
                int i1 = containA(first, "a");
                int i2 = containA(second, "a");
                int i3 = containA(third, "a");
                if(i1== i2 && i2 == i3){
                    count ++;
                }
            }
        }
        return count;
    }

    /**
     *
     *@author allen
     *@date 2021/11/24/024 13:56
     * @param s  源字符串
     * @param target  目标字符串
     * @return 包含target子串的个数
     *
     */
    public static int containA(String s, String target){
        if(s.indexOf(target) == -1){
            return 0;
        }else {
            return 1 + containA(s.substring(s.indexOf(target)+target.length()), target);
        }
    }
}
