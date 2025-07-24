import java.util.*;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int code : barcodes) {
            freq.put(code, freq.getOrDefault(code, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int n = barcodes.length;
        int[] result = new int[n];
        int index = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int value = current[0];
            int count = current[1];

            for (int i = 0; i < count; i++) {
                if (index >= n) index = 1; 
                result[index] = value;
                index += 2;
            }
        }

        return result;
    }
}
