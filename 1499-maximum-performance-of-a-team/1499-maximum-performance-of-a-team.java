class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1_000_000_007;

        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = efficiency[i]; 
            engineers[i][1] = speed[i];
        }

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long speedSum = 0, maxPerf = 0;

        for (int[] engineer : engineers) {
            int currEfficiency = engineer[0];
            int currSpeed = engineer[1];

            if (minHeap.size() == k) {
                speedSum -= minHeap.poll(); 
            }

            minHeap.add(currSpeed);
            speedSum += currSpeed;

            long currPerf = speedSum * currEfficiency;
            maxPerf = Math.max(maxPerf, currPerf);
        }

        return (int)(maxPerf % MOD);
    }
}
