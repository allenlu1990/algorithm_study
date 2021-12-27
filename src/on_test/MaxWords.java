package on_test;

public class MaxWords {
    public static void main(String[] args) {
        System.out.println(solution("We test coders. Give us a try?"));
        System.out.println(solution("Forget CVs..Save time . x x"));

    }

    public static int solution(String s){
        String[] sentences = s.split("[.?!]");
        int res =0;
        for(String sentence : sentences){
            String[] words = sentence.split("[ ]+");
            int numbers =0;
            for(String word: words){
                if(!word.equals("")){
                    numbers++;
                }
            }
            res = numbers > res ? numbers : res;
        }
        return res;
    }
}
