class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        for (int i = 1, sum = 0; ; i++) {
            sum += i;
            if (sum >= target) {
                int d = sum - target;
                if (d % 2 == 0)
                    return i;
                int j = sum + i - target;
                return j % 2 == 1 ? i + 1 : i + 2;
            }
        }
    }
}