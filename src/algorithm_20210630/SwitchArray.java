package algorithm_20210630;

import java.util.Arrays;

/**
 * @author allen
 * @date 2021年11月24日 14:31
 */
public class SwitchArray {
    public static void main(String[] args) {
        int[] mm1 = {3,2,3,2,3};
        int[] mm2 = {7,4,-2,4,-2,-9};
        int[] mm3 = {7,-5,-5,-5,7,-1,7};
        int[] mm4 = {4};
        int[] mm5 = {7,4,-2,4,-2,-9,1,3,1,3,1,3,1};

        System.out.println(solution(mm1));
        System.out.println(solution(mm2));
        System.out.println(solution(mm3));
        System.out.println(solution(mm4));
        System.out.println(solution(mm5));

    }

    public static int solution(int[] array){
        int maxLength =0;
        for(int i=0; i< array.length; i++){
            for(int j=i+1; j <= array.length; j++){
                int[] childArray = Arrays.copyOfRange(array, i, j);
                if(judgeSwith(childArray)){
                    maxLength =  Math.max(maxLength, childArray.length);
                }else {
                    break;
                }
            }
        }
        return maxLength;
    }

    public static boolean judgeSwith(int[] array){
        int i =0;
        while (i < array.length-2){
            if(array[i] != array[i+2]){
                return false;
            }
            i++;
        }
        return true;
    }
}
