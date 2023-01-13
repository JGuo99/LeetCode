/*
    904. Fruit Into Baskets: Medium
    https://leetcode.com/problems/fruit-into-baskets/description/
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int last = -1;
        int preLast = -1;
        int countFruit = 0;
        int curMax = 0;
        int max = 0;

        for (int fruit : fruits) {
            if (fruit == last || fruit == preLast) {
                curMax++;
            } else {
                curMax = countFruit + 1;
            }

            if (fruit == last) {
                countFruit++;
            } else {
                countFruit = 1;
            }

            if (fruit != last) {
                preLast = last;
                last = fruit;
            }

            max = Math.max(curMax, max);
        }

        return max;
    }
}
