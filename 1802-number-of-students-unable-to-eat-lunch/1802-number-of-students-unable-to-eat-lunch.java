class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }

        int i = 0;
        int count = 0; 
        while (!queue.isEmpty() && count < queue.size()) {
            if (queue.peek() == sandwiches[i]) {
                queue.poll();
                i++;
                count = 0; 
            } else {
                queue.offer(queue.poll());
                count++;
            }
        }

        return queue.size();
    }
}
