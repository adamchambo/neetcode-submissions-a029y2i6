class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        matches = {
            ')': '(',
            '}': '{',
            ']': '['
        }
        for c in s:
            if self.is_open(c):
                stack.append(c)
            else:
                if not stack or stack.pop() != matches[c]:
                    return False
        return len(stack) == 0

    def is_open(self, b: str) -> bool:
        return b in '({['