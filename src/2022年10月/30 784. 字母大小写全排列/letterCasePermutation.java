class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backTracking(s.toCharArray(), 0, res);
        return res;
    }
    public void backTracking(char[] arr, int index, List<String> res) {
        if (index == arr.length) {
            res.add(String.valueOf(arr));
            return;
        }
        else if (arr[index] >= '0' && arr[index] <= '9') {
            backTracking(arr, index + 1, res);
        } else {
            arr[index] = Character.toLowerCase(arr[index]);
            backTracking(arr, index + 1, res);
            arr[index] = Character.toUpperCase(arr[index]);
            backTracking(arr, index + 1, res);
        }
    }
}
