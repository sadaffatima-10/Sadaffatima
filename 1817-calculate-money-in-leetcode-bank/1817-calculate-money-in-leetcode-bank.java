class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int extraDays = n % 7;
        
        int fullWeeksTotal = 0;
        for (int i = 0; i < weeks; i++) {
            fullWeeksTotal += 28 + i * 7;
        }
        
        int remainingDaysTotal = 0;
        for (int i = 0; i < extraDays; i++) {
            remainingDaysTotal += weeks + 1 + i;
        }
        
        return fullWeeksTotal + remainingDaysTotal;
    }
}
