class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> ints = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(1,0, n, k);//回溯
        return list;
    }

    public void backtracking(int start, int count, int n, int k) {
        if(count == k) {
            list.add(new ArrayList<>(ints));//为结果，添加到结果集
            return;
        }
        for (int j = start; j <= n; j++) {
            ints.add(j);//添加新的元素
            backtracking(j + 1, count + 1, n, k);//进行递归
            ints.remove(ints.size() - 1);//删去刚刚添加的元素，回溯
        }
    }
}
