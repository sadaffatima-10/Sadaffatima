class Solution {
    public int maxDiff(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        char[] maxArr = digits.clone();
        char toReplaceMax = 0;
        for (char c : digits) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        if (toReplaceMax != 0) {
            for (int i = 0; i < maxArr.length; i++) {
                if (maxArr[i] == toReplaceMax) maxArr[i] = '9';
            }
        }
        int maxVal = Integer.parseInt(new String(maxArr));

        char[] minArr = digits.clone();
        char toReplaceMin = 0;
        if (minArr[0] != '1') {
            toReplaceMin = minArr[0];
            for (int i = 0; i < minArr.length; i++) {
                if (minArr[i] == toReplaceMin) minArr[i] = '1';
            }
        } else {
            for (int i = 1; i < minArr.length; i++) {
                if (minArr[i] != '0' && minArr[i] != '1') {
                    toReplaceMin = minArr[i];
                    break;
                }
            }
            if (toReplaceMin != 0) {
                for (int i = 1; i < minArr.length; i++) {
                    if (minArr[i] == toReplaceMin) minArr[i] = '0';
                }
            }
        }
        int minVal = Integer.parseInt(new String(minArr));

        return maxVal - minVal;
    }
}
