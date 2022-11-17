class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Deque<String>[] deque = new Deque[26];
        for (int i = 0; i < 26; ++i) {
            deque[i] = new ArrayDeque<>();
        }
        for (String word : words) {
            deque[word.charAt(0) - 'a'].add(word);
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Deque<String> d = deque[s.charAt(i) - 'a'];
            int size = d.size();
            while (size-- > 0) {
                String word = d.pollFirst();
                if (word.length() == 1) {
                    ans++;
                } else {
                    deque[word.charAt(1) - 'a'].offer(word.substring(1));
                }
            }
        }
        return ans;
    }
}