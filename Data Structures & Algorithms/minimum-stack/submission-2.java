class MinStack {
    private ArrayList<Integer> stack; 
    private ArrayList<Integer> minStack; 

    public MinStack() {
        this.stack = new ArrayList<>(); 
        this.minStack = new ArrayList<>(); 
    }
    
    public void push(int val) {
        int min = val;
        if (!this.stack.isEmpty()) {
            int end = stack.size() - 1;
            min = Math.min(val, this.minStack.get(end));
        }
        this.stack.add(val); 
        this.minStack.add(min);
    }
    
    public int pop() {
        minStack.remove(minStack.size() -1); 
        return stack.remove(stack.size() -1);
    }
    
    public int top() {
        int end = stack.size() - 1; 
        return stack.get(end);
    }
    
    public int getMin() {
        int end = minStack.size() - 1;
        return minStack.get(end); 
    }
}
