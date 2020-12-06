package com.codingstarlet.structure;

import java.util.ArrayList;
import java.util.List;

public class CombineSubmissions {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    public void getCombine(int n, int k, int start, List<Integer> list) {
        // 1、递归终止条件.
        if(k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // 2、处理当前层的逻辑
        for(int i = start;i <= n - k + 1;i++) {
            list.add(i);
            // 3、计算子问题的解
            getCombine(n, k - 1, i+1, list);
            // 4、revert current level state
            list.remove(list.size() - 1);
        }
    }
}
