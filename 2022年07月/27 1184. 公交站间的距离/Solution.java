// 直接两个区间里的累加求和即可
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int dis1 = 0, dis2 = 0;
        if (start > destination)
            return distanceBetweenBusStops(distance, destination, start);
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination)
                dis1 += distance[i];
            else
                dis2 += distance[i];
        }
        return Math.min(dis1, dis2);
    }
}

//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：41.1 MB, 在所有 Java 提交中击败了50.81%的用户
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int dis1 = 0, sum = 0;
        if (start > destination)
            return distanceBetweenBusStops(distance, destination, start);
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination)
                dis1 += distance[i];
            sum += distance[i];
        }
        int dis2 = sum - dis1;
        return Math.min(dis1, dis2);
    }
}
