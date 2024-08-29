//执行用时：204 ms, 在所有 Java 提交中击败了100.00%的用户
//内存消耗：76 MB, 在所有 Java 提交中击败了100.00%的用户
class FoodRatings {
    class Food {
        String food;
        String cuisine;
        int rating;
        Food(String food, String cuisine, int rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        void setRating(int rating) {
            this.rating = rating;
        }
    }
    HashMap<String, Food> foodMap = new HashMap<>();//名称 对象
    HashMap<String, TreeSet<Food>> ratingMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);
            if (!ratingMap.containsKey(cuisines[i]))
                ratingMap.put(cuisines[i], new TreeSet<Food>((a, b) -> {//名称
                    int num1 = a.rating;
                    int num2 = b.rating;
                    if (num1 == num2)
                        return a.food.compareTo(b.food);
                    else
                        return num2 - num1;
                }));
            ratingMap.get(cuisines[i]).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        Food f = foodMap.get(food);
        ratingMap.get(f.cuisine).remove(f);
        f.setRating(newRating);
        ratingMap.get(f.cuisine).add(f);
    }

    public String highestRated(String cuisine) {
        return ratingMap.get(cuisine).first().food;
    }
}
