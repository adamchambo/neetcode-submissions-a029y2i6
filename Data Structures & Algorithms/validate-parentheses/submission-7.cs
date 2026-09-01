public class Solution {

    private readonly Dictionary<char, char> map = new() 
    {
        { ']', '[' },
        { ')', '(' },
        { '}', '{' }
    };

    public bool IsValid(string s) {
        var stack = new Stack<char>();
        foreach (char c in s) {
            if (IsOpen(c)) stack.Push(c);
            else {
                if (stack.Count == 0) return false;
                if (map[c] != stack.Pop()) return false;
            }
        }

        if (stack.Count > 0) return false;
        return true;
    }

    private bool IsOpen(char c) {
        if (c == '[' || c == '(' || c == '{') return true;
        return false;
    }
}
