class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] extendedTasks = new int[n][3];

        for (int i = 0; i < n; i++) {
            extendedTasks[i][0] = tasks[i][0];
            extendedTasks[i][1] = tasks[i][1]; 
            extendedTasks[i][2] = i;
        }

        Arrays.sort(extendedTasks, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[1] != b[1]) ? Integer.compare(a[1], b[1]) : Integer.compare(a[2], b[2])
        );

        int time = 0, taskIndex = 0, resultIndex = 0;
        int[] result = new int[n];

        while (taskIndex < n || !pq.isEmpty()) {
            while (taskIndex < n && extendedTasks[taskIndex][0] <= time) {
                pq.offer(extendedTasks[taskIndex]);
                taskIndex++;
            }

            if (pq.isEmpty()) {
                time = extendedTasks[taskIndex][0];
            } else {
                int[] curr = pq.poll();
                result[resultIndex++] = curr[2]; 
                time += curr[1];
            }
        }

        return result;
    }
}
