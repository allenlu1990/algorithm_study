package algorithm_20210630;

import static algorithm_20210630.Split3ContainA.containA;

/**
 * @author allen
 * @date 2021年11月24日 14:05
 */
public class Byte1Number {
    public static void main(String[] args) {
            System.out.println(solution(2,4));
    }

    public static int solution(Integer A, Integer B){
        Integer m = A * B;
        String binaryString = Integer.toBinaryString(m);
        System.out.println(binaryString);
        int i = containA(binaryString, "1");
        return i;
    }
}
