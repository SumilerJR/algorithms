class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[][] map = new String[names.length][2];
        for (int i = 0; i < names.length; i++) {
            map[i][0] = names[i];
            map[i][1] = String.valueOf(heights[i]);
        }
        Arrays.sort(map, (a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
        for (int i = 0; i < names.length; i++) {
            names[i] = map[i][0];
        }
        return names;
    }
}