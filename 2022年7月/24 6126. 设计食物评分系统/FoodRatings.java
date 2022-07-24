// 执行用时：328 ms, 在所有 Java 提交中击败了100.00%的用户
// 内存消耗：75.5 MB, 在所有 Java 提交中击败了100.00%的用户
// 一开始的思路
class FoodRatings {
    class Food {
        String food;
        String cuisine;
        int ratings;
        Food(String food, String cuisine, int ratings) {
            this.food = food;
            this.cuisine = cuisine;
            this.ratings = ratings;
        }
    }
    HashMap<String, Food> map = new HashMap<>();//名称 对象
    TreeSet<String> set = new TreeSet<>((a, b) -> {//名称
        int num1 = map.get(a).ratings;
        int num2 = map.get(b).ratings;
        if (num1 == num2)
            return a.compareTo(b);
        else
            return num2 - num1;
    });

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            map.put(foods[i], new Food(foods[i], cuisines[i], ratings[i]));
            set.add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        set.remove(food);
        map.get(food).ratings = newRating;
      //上面两行代码写反了一直不通过……得先用原对象删掉set里的值，再修改添加回去
        set.add(food);
    }

    public String highestRated(String cuisine) {
        for (String s : set) {
            if (cuisine.equals(map.get(s).cuisine))
                return s;//由于要循环遍历，多了点耗时
        }
        return null;
    }
}
