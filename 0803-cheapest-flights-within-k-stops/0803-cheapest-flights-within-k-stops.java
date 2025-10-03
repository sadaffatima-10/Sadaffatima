import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i <= k; i++) { 
            int[] tempDistance = Arrays.copyOf(distance, n);
            for (int[] flight : flights) {
                int u = flight[0];
                if (distance[u] == Integer.MAX_VALUE) {
                    continue;
                }
                int v = flight[1];
                int price = flight[2];

                if (distance[u] != Integer.MAX_VALUE && distance[u] + price < tempDistance[v]) {
                    tempDistance[v] = distance[u] + price;
                }
            }
            distance = tempDistance; 
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
