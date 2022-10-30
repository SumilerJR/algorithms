// 执行用时：4 ms, 在所有 Java 提交中击败了60.34%的用户
// 内存消耗：39.9 MB, 在所有 Java 提交中击败了28.45%的用户
class Solution {
    public String solveEquation(String equation) {
        String[] arr = equation.split("=");
        String[] left = arr[0].replace("-", "+-").split("\\+");
        String[] right = arr[1].replace("-", "+-").split("\\+");
        int x = 0, sum = 0;

        // 等式左边的处理
        for (String s : left) {
            if (s.equals("x")) {
                x += 1;
            } else if (s.equals("-x")) {
                x += -1;
            } else if (s.contains("x")) {
                x += Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                sum -= Integer.parseInt(s);
            }
        }

        // 等式右边的处理
        for (String s : right) {
            if (s.equals("x")) {
                x -= 1;
            } else if (s.equals("-x")) {
                x -= -1;
            } else if (s.contains("x")) {
                x -= Integer.parseInt(s.substring(0, s.length() - 1));
            } else if (!s.equals("")) {
                sum += Integer.parseInt(s);
            }
        }

        if (x == 0) {
            if (sum == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        } else {
            return "x=" + sum / x;
        }
    }
}