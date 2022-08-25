class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        for (int i = left; i < left + k; i++)
            res.add(arr[i]);
        return res;
    }
}


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr)
            list.add(i);
        list.sort((a, b) -> {
            if (Math.abs(a - x) == Math.abs(b - x))
                return a - b;
            else
                return Math.abs(a - x) - Math.abs(b - x);
        });
        List<Integer> res = list.subList(0, k);
        Collections.sort(res);
        return res;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int left = 0, right = arr.length - 1, n = right - k;
        while (n-- >= 0) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))
                right--;
            else
                left++;
        }
        for (int i = left; i <= right; i++)
            res.add(arr[i]);
        return res;
    }
}

