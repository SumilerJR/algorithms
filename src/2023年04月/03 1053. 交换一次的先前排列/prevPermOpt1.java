class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        out: for (int i = len - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break out;
                }
            }
        }
        return arr;
    }
}