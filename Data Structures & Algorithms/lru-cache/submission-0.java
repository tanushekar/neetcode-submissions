//lru--> left of ll--> tail
//most recently used--> right of ll--> head

public class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key=key;
        this.value= value;
        this.prev= null;
        this.next= null;
    }
}
class LRUCache {

    //only inside of this cls--> can't modify--> private
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap= capacity;
        this.cache= new HashMap<>();

        this.left= new Node(0, 0); // tail
        this.right= new Node(0, 0); // head

        this.left.next= this.right;
        this.right.prev= this.left;
        
    }
    
    public void remove(Node node){
        Node prev=node.prev;
        Node nxt= node.next;
        prev.next= nxt;
        nxt.prev= prev;
    }

    public void insert(Node node) {
        Node prev= this.right.prev;
        prev.next= node;
        node.prev= prev;
        node.next= this.right;
        this.right.prev= node;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node= cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node newNode= new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if(cache.size() > cap) {
            Node lru= this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
