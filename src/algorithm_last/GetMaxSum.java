package algorithm_last;

import java.util.Arrays;

/**
 * @author allen
 * @date 2021年11月26日 11:33
 */
public class GetMaxSum {
    public static void main(String[] args) {
        int[] A = {6,1,4,6,3,2,7,4};
        int solution = solution(A, 3, 2);
        System.out.println(solution);
        int[] A2 = {10,19,15};
        int solution2 = solution(A2, 2, 2);
        System.out.println(solution2);
        int[] A3 = {0,1,20,20,20,1,1};
        int solution3 = solution(A3, 2, 4);
        System.out.println(solution3);
    }
    public static int solution(int[] array, Integer K, Integer L){
        if(array.length < K+L){
            return -1;
        }
        int maxSum = 0;
        for(int i =0; i<= array.length - K; i++){
            int[] aArray = Arrays.copyOfRange(array, i, i + K);
            int[] preChild = Arrays.copyOfRange(array, 0, i);
            int preMaxSum = getMaxSum(preChild, L);
            int[] nextChild = Arrays.copyOfRange(array, i+K, array.length);
            int nextMaxSum = getMaxSum(nextChild, L);
            if(preMaxSum == -1 && nextMaxSum == -1){
                continue;
            }
            int aSum = sumArray(aArray);
            int bSum = nextMaxSum > preMaxSum ? nextMaxSum : preMaxSum;
            maxSum = Math.max(maxSum, aSum+bSum);
        }
        return maxSum;
    }
        public static int getMaxSum(int[] array, Integer L){
            if(array.length < L){
                return -1;
            }
            int sum = 0;
            for(int i=0; i<= array.length -L; i++){
                int[] lArray = Arrays.copyOfRange(array, i, i + L);
                int preSum = sumArray(lArray);
                sum = Math.max(sum, preSum);
            }
            return sum;
        }

        public static int sumArray(int[] array){
            int sum = 0;
            for(int i=0; i< array.length; i++){
                sum += array[i];
            }
            return sum;
        }

    }
