// 取六条边，四条直角边相等 两条对角线相等
//执行用时：1 ms, 在所有 Java 提交中击败了76.76%的用户
//内存消耗：39.3 MB, 在所有 Java 提交中击败了78.24%的用户
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] lens = new int[6];
        lens[0] = getLength(p1, p2);
        lens[1] = getLength(p1, p3);
        lens[2] = getLength(p1, p4);
        lens[3] = getLength(p2, p3);
        lens[4] = getLength(p2, p4);
        lens[5] = getLength(p3, p4);
        Arrays.sort(lens);
        if (lens[0] == 0)
            return false;
        return lens[0] == lens[1] && lens[1] == lens[2] && lens[2] == lens[3] && lens[4] == lens[5];
    }
    public int getLength(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}

// 任取三点都为等腰直角三角形
//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：39.5 MB, 在所有 Java 提交中击败了44.71%的用户
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isIsoscelesRightTriangle(p1, p2 ,p3)
                && isIsoscelesRightTriangle(p2, p3, p4)
                && isIsoscelesRightTriangle(p3, p4, p1);
    }
    public boolean isIsoscelesRightTriangle(int[] p1, int[] p2, int[] p3) {
        int l1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        int l2 = (p2[0] - p3[0]) * (p2[0] - p3[0]) + (p2[1] - p3[1]) * (p2[1] - p3[1]);
        int l3 = (p3[0] - p1[0]) * (p3[0] - p1[0]) + (p3[1] - p1[1]) * (p3[1] - p1[1]);
        if ((l1 > l2 && l2 == l3 && l2 + l3 == l1)
            || (l2 > l3 && l3 == l1 && l3 + l1 == l2)
            || (l3 > l1 && l1 == l2 && l1 + l2 == l3))
            return true;
        else
            return false;
    }
}
