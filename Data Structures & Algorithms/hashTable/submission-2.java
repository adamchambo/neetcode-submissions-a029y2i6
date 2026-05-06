class HashTable {
    private int capacity;
    private Entry[] list;

    static class Entry {
        int key;
        int value;
        boolean deleted;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.list = new Entry[capacity];
    }

    public void insert(int key, int value) {
    int index = hash(key);
    Entry newEntry = new Entry(key, value);
    int firstDeleted = -1;
    for (int i = 0; i < capacity; i++) {
        Entry entry = list[index];
        if (entry == null) {
            list[firstDeleted != -1 ? firstDeleted : index] = newEntry;
            if (getSize() >= capacity / 2) resize();
            return;
        }
        if (entry.deleted) {
            if (firstDeleted == -1) firstDeleted = index;
        } else if (entry.key == key) {
            entry.value = value;
            return;
        }
        index = (index + 1) % capacity;
    }

    if (firstDeleted != -1) {

        list[firstDeleted] = newEntry;

        if (getSize() >= capacity / 2) resize();

    }

}

    public int get(int key) {
        int index = hash(key);

        for (int i = 0; i < capacity; i++) {
            Entry entry = list[index];

            if (entry == null) return -1;

            if (!entry.deleted && entry.key == key) {
                return entry.value;
            }

            index = (index + 1) % capacity;
        }

        return -1;
    }

    public boolean remove(int key) {
        int index = hash(key);

        for (int i = 0; i < capacity; i++) {
            Entry entry = list[index];

            if (entry == null) return false;

            if (!entry.deleted && entry.key == key) {
                entry.deleted = true;
                return true;
            }

            index = (index + 1) % capacity;
        }

        return false;
    }

    public int getSize() {
        int size = 0;
        for (Entry entry : list) {
            if (entry != null && !entry.deleted) size++;
        }
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        int newCapacity = capacity * 2;
        Entry[] oldList = list;
        capacity = newCapacity;
        list = new Entry[capacity];
        for (Entry entry : oldList) {
            if (entry != null && !entry.deleted) {
                insert(entry.key, entry.value);
            }
        }
    }

    private int hash(int key) {
        return (key % capacity + capacity) % capacity;
    }
}