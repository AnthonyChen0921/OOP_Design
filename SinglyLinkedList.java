import java.util.*;

public class SinglyLinkedList{
    // keep track of first and last node
    private Node first;
    private Node last;
    private int size;

    // default constructor
    public SinglyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // data constructor
    public SinglyLinkedList(int data) {
        this.first = new Node(data);
        this.last = this.first;
        this.size = 1;
    }

    // member function
    /**
     * @breif: addFirst() adds a node to the beginning of the list using first pointer
     * @param data
     */
    public void addFirst(int data){
        Node newNode = new Node(data);
        if (this.size == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            newNode.next = this.first;
            this.first = newNode;
        }
        this.size++;
    }

    /**
     * @breif: addLast() adds a node to the end of the list with O(1) using last pointer
     * @param data
     */
    public void addLast(int data){
        Node newNode = new Node(data);
        if (this.size == 0) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.size++;
    }
    

    /**
     * @breif: size() returns the size of the list
     * @return size
     */
    public int size(){
        return this.size;
    }

    /**
     * @breif: getFirst() returns the first element of the list
     */
    public int getFirst(){
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.first.data;
    }

    /**
     * @breif: getLast() returns the last element of the list with O(1)
     */
    public int getLast(){
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.last.data;
    }

    /**
     * @breif: deleteNode() deletes a node from the list given the value
     * @param data
     */
    public void deleteNode(int data){
        Node current = this.first;
        Node previous = null;
        while (current != null){
            if (current.data == data){
                if (previous == null){
                    this.first = current.next;
                } else {
                    previous.next = current.next;
                }
                this.size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    /**
     * @breif: printList() prints the list
     */
    public void printList(){
        Node current = this.first;
        while (current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // declare a new singly linked list
        SinglyLinkedList list = new SinglyLinkedList();
        // test addFirst()
        System.out.println("Test addFirst() with data 1, 2, 3");
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.printList();
        // test addLast()
        System.out.println("Test addLast() with data 4, 5, 6");
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.printList();
        // test size()
        System.out.println("list size(): " + list.size());
        // test getFirst()
        System.out.println("list getFirst(): " + list.getFirst());
        // test getLast()
        System.out.println("list getLast(): " + list.getLast());
        // test deleteNode()
        System.out.println("delete node 3");
        list.deleteNode(3);
        list.printList();

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.getFirst();
        try{
            list2.getFirst();
        } catch (NoSuchElementException e){
            System.out.println("list2 is empty");
        }

        // for each c in string s
        String s = "hello";
        for (char c : s.toCharArray()){
            System.out.println(c);
        }

    }
}