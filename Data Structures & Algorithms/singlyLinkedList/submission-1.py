class LinkedList:
    class Node:
        def __init__(self, value):
            self.value = value
            self.next = None
    
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0
    
    def get(self, index: int) -> int:
        current = self.head
        for i in range(index):
            if current:
                current = current.next
            else: 
                return -1
        if current:
            return current.value
        return -1

    def insertHead(self, val: int) -> None:
        node = self.Node(val)
        if not self.head:
            self.head = self.tail = node
        else:
            node.next = self.head
            self.head = node
        self.size += 1

    def insertTail(self, val: int) -> None:
        node = self.Node(val)
        if not self.head:
            self.head = self.tail = node
        else:
            self.tail.next = node
            self.tail = node
        self.size += 1

    def remove(self, index: int) -> bool:
        if index < 0 or index >= self.size:
            return False
        if index == 0:
            self.head = self.head.next
            if self.size == 1:
                self.tail = None
            self.size -= 1
            return True
        prev = self.head
        for _ in range(index - 1):
            prev = prev.next
        removed = prev.next
        prev.next = removed.next
        if removed == self.tail:
            self.tail = prev
        self.size -= 1
        return True

    def getValues(self) -> List[int]:
        arr = []
        current = self.head
        while current:
            arr.append(current.value)
            current = current.next
        return arr
        
