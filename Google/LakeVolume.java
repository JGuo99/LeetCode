public class LakeVolume {
    /*
        https://leetcode.com/problems/trapping-rain-water/description/
     */
    public static int lakeVolume(int[] lake) {
        int result = 0;
        int lastWall = lake[0];
        for (int i = 1; i < lake.length; i++) {
            if (lastWall >= lake[i])
                result += lastWall - lake[i];
            if (lastWall < lake[i])
                lastWall = lake[i];
            System.out.println(result);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2};
        System.out.println(lakeVolume(test));
    }
}
