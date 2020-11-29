import java.util.*;

public class GroupAnagrams {

    /**
     * 利用算数基本定理
     * 算术基本定理，又称为正整数的唯一分解定理，即：每个大于1的自然数，要么本身就是质数，要么可以写为2个以上的质数的积，
     * 而且这些质因子按大小排列之后，写法仅有一种方式。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<Long, List<String>> hash = new HashMap<>();
        //每个字母对应一个质数
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for (int i = 0; i < strs.length; i++) {
            // key 设为 long，防止溢出
            long key = 1;
            //累乘得到 key
            for (int j = 0; j < strs[i].length(); j++) {
                key *= prime[strs[i].charAt(j) - 'a'];
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }
        }
        return new ArrayList<List<String>>(hash.values());
    }

    /**
     * 统计出现字母个数
     * @param strs
     * @return
     */
    public List<List<String>> _groupAnagrams_2(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> maps = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ca = strs[i].toCharArray();
            // 统计出现字母个数，再组成新的唯一字符
            char[] nums = new char[26];
            for (char c : ca) {
                nums[c - 'a']++;
            }
            String keyStr = String.valueOf(nums);
            if (!maps.containsKey(keyStr)) {
                maps.put(keyStr, new ArrayList<>());
            }
            maps.get(keyStr).add(strs[i]);
        }
        return new ArrayList<>(maps.values());
    }

    /**
     * 先排序再判断
     * @param strs
     * @return
     */
    public List<List<String>> _groupAnagrams_1(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> maps = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // 排序
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!maps.containsKey(keyStr)) {
                maps.put(keyStr, new ArrayList<>());
            }
            maps.get(keyStr).add(strs[i]);
        }
        return new ArrayList<>(maps.values());
    }
}