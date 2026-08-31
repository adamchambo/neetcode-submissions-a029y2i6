public class Solution {
    public int CalPoints(string[] operations) {
        var stack = new Stack<int>();
        foreach (string op in operations) {
            if (op == "+") {
                int last = stack.Pop();
                int result = last + stack.Peek();
                stack.Push(last);
                stack.Push(result);
            }
            else if (op == "D") stack.Push(stack.Peek() * 2);
            else if (op == "C") stack.Pop();
            else stack.Push(int.Parse(op));
        }
        return stack.Sum();
    }
}