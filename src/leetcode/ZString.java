package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ZString {
    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 2));
    }
    public static String convert(String s, int numRows) {

        if(numRows == 1)
            return s;

        StringBuilder[] res = new StringBuilder[numRows];

        for (int i =0; i< numRows; i++){
            res[i] = new StringBuilder();
        }

        int index=0, row=0;
        int length = s.length();
        while (index < length){

            while (row < numRows && index < length){
                res[row].append(s.charAt(index++));
                row++;
            }

            row = numRows -2;

            while (row > 0 && index < length){
                res[row].append(s.charAt(index++));
                row--;
            }

        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder re: res){
            result.append(re.toString());
        }

        return result.toString();
    }
}
