
import java.util.*;

public class LRUCache {
    // implement the LRU cache 
    // using a doubly linked list and a hash map
    // the head of the list is the least recently used item
    // the tail of the list is the most recently used item
    // the hash map is used to store the key and the node in the list
    
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    // map is used to store the key and the node in the list
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            setHead(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            setHead(node);
            map.put(key, node);
        }
    }

    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void setHead(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));
        cache.set(3, 3);
        System.out.println(cache.get(2));
        cache.set(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
    
}
