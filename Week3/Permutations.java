package com.codingstarlet.structure;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] selected = new int[nums.length];
        backtrack(result, nums, new ArrayList<Integer>(), selected);
        return result;

    }

    private void backtrack(List<List<Integer>> result, int[] nums,
                           ArrayList<Integer> tmp, int[] selected) {
        if (tmp.size() == nums.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (selected[i] == 1) continue;
            selected[i] = 1;
            tmp.add(nums[i]);
            backtrack(result, nums, tmp, selected);
            selected[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
