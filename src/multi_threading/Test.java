package multi_threading;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Test {
    public static void main(String[] args) {
//        TreeSet<String> strings = new TreeSet<>();
//         LinkedHashSet<String> strings = new LinkedHashSet<>();
//        strings.add("BB");
//        strings.add("AA");
//        strings.add("CC");
//        strings.forEach(System.out::println);
//
//        TreeMap<String, String> stringStringTreeMap = new TreeMap<>();
//        stringStringTreeMap.put("BB","BB");
//        stringStringTreeMap.put("AA","AA");
//        stringStringTreeMap.put("DD","DD");
//        stringStringTreeMap.put("CC","CC");
//        stringStringTreeMap.forEach((key,value)-> {
//            System.out.println(key + ":" + value);
//        });
//
//        Object o = new Object();
//        int i = o.hashCode();
//        boolean equals = o.equals(o);
//
        Integer integer = new Integer(100);
        Integer integer22 = new Integer(100);

//        System.out.println(i);
        System.out.println(integer.equals(integer22));
        System.out.println(integer==integer22);
//
//
        Integer integer1 = 100;
        Integer integer2 = 100;
        System.out.println("integer1 == integer2:"+(integer1==integer2));
        Integer integer3 = 1000;
        Integer integer4 = 1000;
        System.out.println("integer1 == integer2:"+(integer3==integer4));
        System.out.println("integer == integer2:"+(integer==integer4));
//
//        int[] a = {1, 2, 3, 2, 1,6, 3, 4, 4};
//        System.out.println(singleNumber(a));


        Boolean boolean1 = new Boolean(true);
        Boolean boolean3 = new Boolean(true);
        Boolean boolean2 = true;

        System.out.println(boolean1 == boolean2);
        System.out.println(boolean1.equals(boolean2));
        System.out.println(boolean1 == boolean3);
        System.out.println(boolean1.equals(boolean3));


    }

    public static int singleNumber(int[] A) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int i = 0; i < A.length; i++) {
            rst ^= A[i];
        }
        return rst;
    }

}
