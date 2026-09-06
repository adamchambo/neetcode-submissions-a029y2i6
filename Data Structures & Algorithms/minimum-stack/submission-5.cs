public class MinStack {
    Stack<int> stack;
    Stack<int> min;

    public MinStack() {
        stack = new Stack<int>();
        min = new Stack<int>();
    }
    
    public void Push(int val) {
        if (stack.Count == 0 || val <= min.Peek()) min.Push(val);
        stack.Push(val);
    }
    
    public void Pop() {
        if (stack.Peek() == min.Peek()) min.Pop();
        stack.Pop();
    }
    
    public int Top() {
        return stack.Peek();
    }
    
    public int GetMin() {
        return min.Peek();
    }
}
