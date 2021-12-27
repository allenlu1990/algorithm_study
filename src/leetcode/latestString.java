package leetcode;

public class latestString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        int length = s.length();
        String result = "";
        for(int start = 0; start < length; start++){
            for(int end = length; end> 0; end--){
                String tmp = s.substring(start, end);
                if(result.length() > tmp.length()){
                    break;
                }
                if(judge(tmp)){
                    result = tmp.length() > result.length() ? tmp : result;
                    break;
                }
            }
        }
        return result;

    }

    public static boolean judge(String tmp){
        int length = tmp.length();
        int mid = (length / 2) + (length % 2)-1;
        for(int index = 0; index <= mid; index++ ){
            if(length%2 ==0){
                if(tmp.charAt(mid-index) != tmp.charAt(mid+index+1)){
                    return false;
                }
            }else {
                if(tmp.charAt(mid-index) != tmp.charAt(mid+index)){
                    return false;
                }
            }

        }
        return true;
    }

}
