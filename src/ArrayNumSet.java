public class ArrayNumSet<E extends Number> implements NumSet<E> {

    // The array that holds the elements of the set
    private Number[] arr;
    // The number of elements in the set
    private int arrayIndex;

    // The number of elements in the set
    public ArrayNumSet(int initialCapacity) {
        this.arr = new Number[initialCapacity];
    }

    // add an element e to the set if it does not already exist in the set
    public Number[] getArr() {
        return arr;
    }

    @Override
    public boolean add(E n) throws NullPointerException {

        // Check if the element is null
        if (n == null) {
            // Throw a NullPointerException
            throw new NullPointerException();
        }
        // Check if the element "value" is already in the set
        for (Number value : arr) {
            if (n.equals(value)) {
                return false;
            }
        }
        // Check if the array is full
        if (arr.length == arrayIndex) {
            // Create a new array with double the size
            doubleCapacity();
        }
        // Add the element to the set
        arr[arrayIndex] = n;
        // Increment the arrayIndex
        this.arrayIndex++;

        return false;
    }

    @Override
    public int capacity() {
        return arr.length;
    }

    @Override
    public boolean contains(E n) throws NullPointerException {
        // Check if the element is null
        if (n == null) {
            throw new NullPointerException();
        }
        // Check if the element "value" is in the set
        for (Number value : arr) {
            if (value == null) {
                return false;
            }
            if (value.equals(n)) {
                return true;
            }
        }

        return false;
    }


    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        // Returns the value at the specified index
        return (E) this.arr[index];
    }

    @Override
    public boolean remove(E e) throws NullPointerException {

        if (e == null) {
            throw new NullPointerException();
        }

        int foundIndex = -1;

        // Check if the element "value" is in the set
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(e)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            return false;
        }
        // Shift the elements to the left
        shiftLeft(foundIndex);

        return true;
    }

    @Override
    public int size() {
        return arrayIndex;
    }

    private void doubleCapacity() {
        // double the capacity of the array
        final Number[] newArray = new Number[capacity() * 2];
        // copy the elements from the old array to the new array
        System.arraycopy(arr, 0, newArray, 0, size());
        // set the old array to the new array
        this.arr = newArray;
    }

    private void shiftLeft(int index) {
        // Shift all elements to the left of the given index to the left by one.
        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
        this.arrayIndex--;
    }

}
