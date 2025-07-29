class DinnerPlates {
    private int capacity;
    private List<Stack<Integer>> stacks;
    private TreeSet<Integer> available;
    private int rightmost = -1;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        available = new TreeSet<>();
    }

    public void push(int val) {
    while (!available.isEmpty()) {
        int index = available.first();
        if (index < stacks.size() && stacks.get(index).size() < capacity) {
            stacks.get(index).push(val);
            if (stacks.get(index).size() == capacity) {
                available.remove(index);
            }
            rightmost = Math.max(rightmost, index);
            return;
        } else {
            available.remove(index); // stale entry
        }
    }


        Stack<Integer> newStack = new Stack<>();
        newStack.push(val);
        stacks.add(newStack);
        int index = stacks.size() - 1;
        if (capacity > 1) {
            available.add(index);
        }
        rightmost = index;
    }

    public int pop() {
        while (rightmost >= 0 && (rightmost >= stacks.size() || stacks.get(rightmost).isEmpty())) {
            rightmost--;
        }
        if (rightmost < 0) return -1;
        return popAtStack(rightmost);
    }

    public int popAtStack(int index) {
        if (index >= stacks.size() || stacks.get(index).isEmpty()) return -1;

        int val = stacks.get(index).pop();
        available.add(index);
        if (stacks.get(index).isEmpty() && index == stacks.size() - 1) {
            while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
                stacks.remove(stacks.size() - 1);
            }
            rightmost = stacks.size() - 1;
        }
        return val;
    }
}
