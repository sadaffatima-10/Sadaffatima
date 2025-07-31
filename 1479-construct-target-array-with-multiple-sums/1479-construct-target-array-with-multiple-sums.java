class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;

        for (int num : target) {
            maxHeap.add(num);
            total += num;
        }

        while (true) {
            int largest = maxHeap.poll();
            long rest = total - largest;

            if (largest == 1 || rest == 1) return true;
            if (rest == 0 || largest < rest) return false;

            int prev = (int)(largest % rest);
            if (prev == 0) return false;

            total = rest + prev;
            maxHeap.add(prev);
        }
    }
}
