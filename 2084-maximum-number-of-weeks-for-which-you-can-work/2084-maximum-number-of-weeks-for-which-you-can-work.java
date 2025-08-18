class Solution {
    public long numberOfWeeks(int[] milestones) {
        long total = 0;
        long maxMilestone = 0;
        for (int m : milestones) {
            total += m;
            maxMilestone = Math.max(maxMilestone, m);
        }
        
        long rest = total - maxMilestone;
        if (maxMilestone <= rest + 1) {
            return total;
        } else {
            return 2 * rest + 1;
        }
    }
}
