public class ValidAnagram {

    /**
     * 散列表
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 新建一个储存 26 个小写字母的数组
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            nums[t.charAt(j) - 'a']--;
            if (nums[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 排序
     */
    public boolean _isAnagram_1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }
}