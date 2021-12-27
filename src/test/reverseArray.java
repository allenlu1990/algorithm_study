package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class reverseArray {
    List<List<Integer>> res = new LinkedList<List<Integer>>();

    public static void main(String[] args) {
        int[] test = {2,3,6,7};
        reverseArray reverseArray = new reverseArray();
        List<List<Integer>> lists = reverseArray.combinationSum(test, 7);

        System.out.println(lists);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        revers(candidates, target, new LinkedList<Integer>(), 0, 0);
        return res;
    }

    public void revers(int[] nums, int target, List<Integer> list, int index, int sum) {
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target){
            return;
        }

        for (int i = index; i< nums.length; i++){
            list.add(nums[i]);
            revers(nums, target, list, i, sum+nums[i]);
            list.remove(list.size()-1);
        }

    }
}
