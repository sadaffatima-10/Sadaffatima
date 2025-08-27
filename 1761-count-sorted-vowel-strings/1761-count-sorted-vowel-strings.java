class Solution {
    public int countVowelStrings(int n) {
        return nCr(n + 4, 4);
    }

    private int nCr(int n, int r) {
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
        }
        return (int) res;
    }
}
