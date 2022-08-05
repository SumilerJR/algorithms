// 执行用时：5 ms, 在所有 Java 提交中击败了76.52%的用户
// 内存消耗：41.6 MB, 在所有 Java 提交中击败了15.75%的用户

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2)
            return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < l1; i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(map1, map2))
                return true;
        for (int i = l1; i < l2; i++) {
            map2[s2.charAt(i - l1) - 'a']--;
            map2[s2.charAt(i) - 'a']++;
            if(Arrays.equals(map1, map2))
                return true;
        }
        return false;
    }
}