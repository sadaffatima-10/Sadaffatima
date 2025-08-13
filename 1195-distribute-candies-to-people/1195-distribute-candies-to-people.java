public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int give = 1; 
        int i = 0;

        while (candies > 0) {
            if (candies >= give) {
                result[i] += give;
                candies -= give;
            } else {
                result[i] += candies;
                break;
            }

            give++;
            i = (i + 1) % num_people;
        }

        return result;
    }
}
