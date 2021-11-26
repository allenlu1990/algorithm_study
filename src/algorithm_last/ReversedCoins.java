package algorithm_last;

import java.util.Arrays;

/**
 * @author allen
 * @date 2021年11月25日 14:04
 */
public class ReversedCoins {
    public static void main(String[] args) {
        int[] a1 = {1,0,1,0,1,1};
        System.out.println(solution(a1));
        int[] a2 = {1,1,0,1,1};
        System.out.println(solution(a2));
        int[] a3 = {0,1,0};
        System.out.println(solution(a3));
        int[] a4 = {0,1,1,0};
        System.out.println(solution(a4));
        int[] a5 = {0,0};
        System.out.println(solution(a5));

    }

    public static int solution(int[] array){
        int[] tmp = Arrays.copyOf(array, array.length);
        int number1 = getMin(tmp);
        array[0] = reverse(array[0]);
        int number2 = getMin(array) +1 ;
     return  number1 > number2 ? number2: number1;
    }

    public static int getMin(int[] array){
        int number =0;
        for(int i =0; i< array.length-1; i++){
            int startValue = array[i];
            int endValue = array[i+1];
            if(reverse(startValue) != endValue){
                array[i+1] = reverse(startValue);
                number++;
            }
        }
        return number;
    }

    public static int reverse(int value){
        if(value==0){
            return 1;
        }else {
            return 0;
        }
    }
}
