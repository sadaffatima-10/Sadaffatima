class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (freq.get(c) > (n + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq =
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(freq.entrySet());

        StringBuilder sb = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> current = pq.poll();

            sb.append(current.getKey());
            current.setValue(current.getValue() - 1);

            if (prev != null && prev.getValue() > 0) {
                pq.offer(prev);
            }

            prev = current;
        }

        return sb.toString();
    }
}
