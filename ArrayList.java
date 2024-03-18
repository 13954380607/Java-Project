// Written by David Qi, qi00154 and Dongnan Liu
public class ArrayList<T extends Comparable<T>> implements List<T>{
    private  T[] array;
    private boolean isSorted;
    private int size;

    private void growArray() {
        int temp = array.length * 2;
        T[] newArray = (T[]) new Comparable[temp];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
    public ArrayList(){
        array = (T[]) new Comparable[2]; //sets to default length of 2
        this.isSorted = true;
        this.size = 0;
    }

    @Override
    public boolean add(T element) {
        if(element == null)
            return false;

        if(size == array.length){ // When the array is full, grow array
            growArray();
        }
        array[size++] = element;


        if(isSorted){//check if the list is sorted
            if(size > 1){
                if (element.compareTo(array[size - 2]) < 0) { // check if the element is smaller than the previous element
                    isSorted = false;
                }
            }
        }

        return true;


    }

    @Override
    public boolean add(int index, T element) {
        if(index>array.length || index < 0)
            return false;
        if (size == array.length) {
            growArray();
        }
        for (int i = size; i > index; i--) { //moving the elements backward
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;

        if (isSorted) { //check if the list is sorted
            if (size > 1) {
                for (int i = 0; i < size - 1; i++) {
                    if (array[i].compareTo(array[i + 1]) > 0) {
                        isSorted = false;
                    }
                }
            }

        }


        return true;
    }

    @Override
    public void clear() {
        for(int i = 0; i<array.length; i++){
            array[i] = null;
        }
        isSorted = true;
        size = 0;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index> array.length-1){
            return null;
        }
        return array[index];
    }

    @Override
    public int indexOf(T element) {//return the index of the element
        for (int i = 0; i < size; i++){
            if(array[i].equals(element)){
                return i;
            }
            if(isSorted){
                if(array[i].compareTo(element) > 0){
                    return -1;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        for(int i =0; i<array.length; i++){
            if (array[i] != null){
                return false;
            }

        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort() {//bubble sort
        int i, j;
        T temp;
        boolean swapped = true;
        if(isSorted){
            return;
        }
        if(size() == 1 || size() == 0){
            isSorted = true;
            return;
        }
        for(i=0;i<size() && swapped == true; i++){
            swapped =false;
            for(j=1;j<size()-i;j++){
                if(array[j].compareTo(array[j-1]) < 0){
                    swapped = true;
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        isSorted = true;
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index> array.length-1) {
            return null;
        }
        if(isEmpty()){
            return null;
        }
        T value = array[index];
        array[index] = null;
        if(index == size-1){ //removing the last element in the list
            size-=1;
            return value;
        }
        for(int i =index; i<size-1;i++){//moving the elements forward
            array[i] = array[i+1];
        }
        array[size-1] = null;
        size-=1;


        isSorted = true;
        if (size > 1) {
            for (int i = 0; i < size - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    isSorted = false;
                }
            }
        }


        return value;
    }

    @Override
    public void equalTo(T element) {
        if(element == null){
            return;
        }

        if (isSorted){
            int count = 0;
            for (int i = 0; i < size - 1; i++){
                count++;
                if(array[i].compareTo(element) > 0) //if array[i] is larger than the element, end the loop
                    break;
            }
            clear();
            for(int j = 0; j < count; j++){
                add(element);
            }
        } else {
            for (int i = 0; i < size; i++) {

                if (array[i].equals(element)) {
                    continue;
                } else {
                    remove(i); // remove the elements that is not equal
                    i -= 1;
                }
            }
            isSorted = true;
        }

    }

    @Override
    public void reverse() {
        if(size < 2){
            return;
        }
        T temp;
        for(int i=0; i<size/2; i++){ // switch half of the elements in the array
            temp = array[i];
            array[i] = array[size-1-i];
            array[size-1-i]= temp;
        }

        isSorted = true;
            if (size > 1) {
                for (int i = 0; i < size - 1; i++) {
                    if (array[i].compareTo(array[i + 1]) > 0) {
                        isSorted = false;
                    }
            }

        }


    }

    @Override
    public void intersect(List<T> otherList) {
        // Check if otherList is null
        if (otherList == null) {
            return;
        }

        ArrayList<T> other = (ArrayList<T>) otherList;

        sort();

        // Create a new list to store the intersection
        ArrayList<T> intersection = new ArrayList<>();


        for (int i = 0; i < other.size(); i++) {
            T element = other.get(i);

            // Check if each element is present in the current list
            if (indexOf(element) != -1) {
                intersection.add(element);
            }
        }

        //Clear the current list and add all elements from the intersection list
        clear();
        for(int i = 0; i < intersection.size(); i++){
            add(intersection.get(i));
        }


        isSorted = true;
    }


    @Override
    public T getMin() {
        T min = array[0];
        for(int i = 0; i < size; i++){
            if (array[i].compareTo(min) < 0){
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public T getMax() {
        T max = array[0];
        for(int i = 0; i < size; i++){
            if (array[i].compareTo(max) > 0){
                max = array[i];
            }
        }
        return max;
    }

    @Override
    public boolean isSorted() {
        return isSorted;
    }

    public String toString(){
        String output = "";
        sort();
        for (int i = 0; i < size(); i++){
            output += array[i] + " ";
        }
        return output;
    }

}
