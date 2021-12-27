package on_test;

import java.util.Arrays;

public class reverseCoin {
    public static void main(String[] args) {
        reverseCoin reverseCoin = new reverseCoin();
        int[] A1 = {1,0,1,0,1,1};
        int[] A2 = {1,1,0,1,1};
        int[] A3 = {0,1,1,0};
        int[] A4 = {0,1,0};
        System.out.println(reverseCoin.solution(A1));
        System.out.println(reverseCoin.solution(A2));
        System.out.println(reverseCoin.solution(A3));
        System.out.println(reverseCoin.solution(A4));
    }

    public int solution(int[] A){
        int change = reverse(A, true);
        int follow = reverse(A, false);
        return change > follow ? follow : change;

    }

    public int reverse(int[] array, boolean flag){
        int length = array.length;
        int[] A = Arrays.copyOfRange(array,0, length);
        int num =0;
        if(length < 2){
            return 0;
        }
        if(flag){
            if(A[0]==0){
                A[0] = 1;
            }else {
                A[0] =0;
            }
            num++;
        }
        for(int i =1; i < length; i++){
            if(A[i] == A[i-1]){
                if(A[i]==0){
                    A[i] = 1;
                }else {
                    A[i] =0;
                }
                num ++;
            }
        }
        return num;
    }
}
