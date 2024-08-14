class DynamicArray {
    int[] dynamicArr;
    int capacity;
    int size;
    public DynamicArray(int initCapacity) {
        if(initCapacity < 1) throw new RuntimeException("Initial capacity must be greater than 0");
        dynamicArr = new int[initCapacity];
        size = 0;
        capacity = initCapacity;
    }

    public int get(int i) {
        return dynamicArr[i];
    }

    public void set(int i, int n) {
        if(i < 0 || i >= size) throw new IndexOutOfBoundsException("Index " + i + " is out of bounds.");
        dynamicArr[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity) resize();
        dynamicArr[size++] = n;
    }

    public int popback() {
        if(size == 0) throw new RuntimeException("Array is empty");
        int value = dynamicArr[--size];
        dynamicArr[size] = 0;
        return value;
    }

    private void resize() {
        int[] newArr = new int[capacity *= 2];
        System.arraycopy(dynamicArr, 0, newArr,0, size);
        dynamicArr = newArr;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
