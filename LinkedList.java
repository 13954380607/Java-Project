// Written by David Qi, qi00154 and Dongnan Liu
public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> start;
    private int num;
    private boolean isSorted;

    public LinkedList() {
        boolean isSorted = true;
        start = null;
        num = 0;
    }

    public boolean add(T element) {
        if (element == null) {
            return false;
        } else {
            if (start == null) {
                start = new Node<>(element, start); // make the start be the first node
            } else {
                Node<T> temp = start;
                while (temp.getNext() != null) { // keep track of the node to find the last node in the list
                    temp = temp.getNext();
                }
                temp.setNext(new Node<>(element, null));// set the next node of the last node to the added one
            }
        }
        isSorted = this.sortTrue();
        num++;
        return true;
    }

    public boolean add(int index, T element) {
        if (element == null || index < 0 || index >= this.size()) { // check if it is the wrong situation
            return false;
        } else {
            Node<T> newNode = new Node<>(element, null); //create a new node which first node's data is element.
            if (index == 0) {
                newNode.setNext(start);// directly add it if the size of the list is 0 at first.
                start = newNode;
            } else {
                Node<T> ptr = start;
                for (int i = 0; i < index - 1; i++) {// keep track of the node to find the previous node of the index one.
                    ptr = ptr.getNext();
                }
                newNode.setNext(ptr.getNext());
                ptr.setNext(newNode);
            }
        }
        isSorted = this.sortTrue();
        num++;
        return true;
    }

    public void clear() {
        if (start != null) {
            start = null;// set the start to null so the node after the node are all null
            isSorted = true;
        }
    }

    public T get(int index) {
        int num = 0;
        if (index < 0 || index > size()) {
            return null;
        } else {
            Node<T> temp = start;
            while (temp != null && num < index) { // use temp to keep track of the node to the index one
                temp = temp.getNext();
                num++;
            }
            if (temp != null) {
                return temp.getData();// make the pointer to the next one
            } else {
                return null;
            }
        }
    }

    public int indexOf(T element) {
        if (element == null) {
            return -1;
        } else {
            Node<T> temp = start;
            int index = 0;
            while (temp != null) {
                if (isSorted && temp.getData().compareTo(element) > 0) { // since the list is already sorted and the start data is greater than the element so there will not exist a data equal to the element
                    return -1;
                }
                if (temp.getData().compareTo(element) == 0) {
                    return index;
                }
                temp = temp.getNext();
                index++;
            }
        }
        return -1;
    }


    public boolean isEmpty() {
        if (size() == 0) {
            isSorted = true;
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        int count = 0;
        Node<T> current = start;
        while (current != null) {//loop through the whole list to the end to count
            current = current.getNext();
            count++;
        }
        return count;
    }

    public void sort() {
        if (isSorted || num == 0) {
            return;
        }
        Node<T> pre = start;
        Node<T> cur = start.getNext();
        if (cur == null) {
            isSorted = true;
        }
        for (pre = start; pre != null; pre = pre.getNext()) { // keep track of the start to the end of the list
            for (cur = pre.getNext(); cur != null; cur = cur.getNext()) { // keep track of the node after the pre none to compare these two data
                if (pre.getData().compareTo(cur.getData()) > 0) {
                    T item = pre.getData();
                    pre.setData(cur.getData());
                    cur.setData(item);
                }
            }
        }
        isSorted = true;
    }

    public T remove(int index) {
        if (index < 0 || index >= num) {
            return null; // Index out of bounds
        } else {
            if (index == 0) {
                T element = start.getData();
                start = start.getNext();
                num--;
                if (this.sortTrue()) {
                    isSorted = true;
                }
                return element;
            } else {
                Node<T> temp = start;
                int num1 = 1;
                while (num1 < index) { // keep track of the num1 to find the node before the index
                    temp = temp.getNext();
                    num1++;
                }
                T elementToRemove = temp.getNext().getData(); // find the element to remove
                temp.setNext(temp.getNext().getNext());
                num--;
                isSorted = this.sortTrue();
                return elementToRemove;
            }
        }
    }

    public void equalTo(T element) {
        if (element == null) {
            return;
        } else {
            int count = 0;
            Node<T> temp = start;
            if (start != null) {
                Node<T> trailer = null;//create a new node
                while (temp != null) {
                    if (isSorted && temp.getData().compareTo(element) > 0) {// if isSorted and the data greater than element, just return.
                        num = count;
                        temp = null;
                        return;
                    }
                    if (temp.getData().compareTo(element) != 0) {
                        temp = temp.getNext();// if the data is not equal to the element, point to the next node directly
                        if (trailer != null) {
                            trailer.setNext(temp);// set the next node of the trailor to be temp
                        } else {
                            start = temp;
                        }
                        count++;
                    } else {
                        trailer = temp;
                        temp = temp.getNext();
                    }
                }
            }
            num = count;
        }
        isSorted = true;
    }

    public void reverse() {
        if (start == null || start.getNext() == null) {
            return;
        }
        Node<T> reversedFirst = null;
        Node<T> current = start;
        while (current != null) {
            Node<T> temp = current.getNext();
            current.setNext(reversedFirst);// change the current pointer to the first
            reversedFirst = current; // move the first to the current one
            current = temp; // move the current to th temp
        }
        start = reversedFirst;
        if (this.sortTrue()) {
            isSorted = true;
        }
    }

    public void intersect(List<T> otherList) {
        if (otherList != null) {
            LinkedList<T> other = (LinkedList<T>) otherList;
            this.sort();// sort the original one
            other.sort(); // sort the other list
            Node<T> ptrOther = other.start;
            Node<T> temp = this.start;
            Node<T> newHead = null; // create the first node of the new list.
            Node<T> trailor = newHead;
            while (temp != null && ptrOther != null) {
                if (temp.getData().compareTo(ptrOther.getData()) == 0) {//elements are equal
                    T element = temp.getData();
                    Node<T> ptr = new Node<>(element); // create a new node that contains the first same element
                    if (newHead == null) {
                        newHead = ptr;
                        trailor = newHead;// use trailor to keep track of the node.
                    } else {
                        trailor.setNext(ptr);
                        trailor = ptr;// move trailor to the next
                    }
                    ptrOther = ptrOther.getNext();
                    temp = temp.getNext();
                } else if (temp.getData().compareTo(ptrOther.getData()) < 0) {// elements in temp is smaller than in ptrOther
                    temp = temp.getNext(); // just move the temp
                } else {
                    ptrOther = ptrOther.getNext();
                }
            }
            this.start = newHead;
            isSorted = true;
        }
    }

    public T getMin() {
        if (this.size() == 0) {// check whether the size of the node is 0, if it is 0, return nothing.
            return null;
        }
        Node<T> temp = start;
        T minNode = start.getData();// set the min one is the data in start.
        if (this.isSorted == true) {// check whether it is sorted or not
            return start.getData();
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
                if (temp.getData().compareTo(minNode) < 0) {//loop through the list to see if there exist a data smaller than the min one.
                    minNode = temp.getData();
                }
            }
            return minNode;
        }
    }

    public T getMax() {
        if (this.size() == 0) { // check whether the size of the node is 0, if it is 0, return nothing.
            return null;
        }
        Node<T> temp = start;
        T maxNode = start.getData();// set the max one is the data in start.
        if (this.isSorted == true) { // check whether it is sorted or not
            return start.getData();
        } else {
            while (temp.getNext() != null) {//loop through the list to see if there exist a data greater than the max one.
                temp = temp.getNext();
                if (temp.getData().compareTo(maxNode) > 0) {
                    maxNode = temp.getData();
                }
            }
            return maxNode;
        }
    }

    public String toString() { // print each node to help us to check the data.
        String output = "";
        Node<T> temp = start;
        while (temp != null) {
            output += temp.getData();
            temp = temp.getNext();
        }
        return output;
    }

    public boolean isSorted() {//return isSorted since it is created at the beginning of the class.
        return isSorted;
    }

    public boolean sortTrue() { // create a helper function to help us check whether the linkedlist is sorted or not.
        if (start == null) {
            return true;
        }
        Node<T> temp = start;
        while (temp.getNext() != null) {
            if (temp.getData().compareTo(temp.getNext().getData()) > 0) {
                return false;
            }
            temp = temp.getNext();
        }
        return true;
    }
}