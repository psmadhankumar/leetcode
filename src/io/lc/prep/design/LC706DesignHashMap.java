package io.lc.prep.design;

/**
 * Design a HashMap without using any built-in hash table libraries.
 * To be specific, your design should include these functions:
 * 	• put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * 	• get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * 	• remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Example:
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Note:
 * 	• All keys and values will be in the range of [0, 1000000].
 * 	• The number of operations will be in the range of [1, 10000].
 * 	• Please do not use the built-in HashMap library.
 *
 *
 * TIPS: If without extending via loadFactor/rehahsing when extending, the solution should be straight forward.
 * If not, then rehashing along needs quite concentration.
 */
public class LC706DesignHashMap {

    Node[] buckets = null;
    int capacity = 100;
    int size = 0;
    double loadfactor = 0.75;

    /** Initialize your data structure here. */
    public LC706DesignHashMap() {
        buckets = new Node[capacity];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(isAlmostFull()) {
            //extend();
            //System.out.println("completed extension");
        }

        int hash = hash(key);

        //1. first check if bucket is empty or not
        if(buckets[hash] != null) {
            Node node = buckets[hash];
            Node prev = null;
            //2. if bucket not empty then check if element is already present then update value
            while(node != null) {
                if(node.key == key) { node.val = value; return;}
                else {prev = node; node = node.next;}
            }
            //3. if element not found then add as last node in that bucket
            Node newNode = new Node(key, value);
            prev.next = newNode;
            size++;
        } else {
            //4. If bucket is emoty then just put the node there
            Node newNode = new Node(key, value);
            buckets[hash] = newNode;
            size++;
        }
    }

    private void extend() {
        capacity = capacity * 2;
        Node[] newbuckets = new Node[capacity];

        for(Node oldNode: buckets) {
            if(oldNode == null) continue;
            //System.out.println("taversing " + n.key);

            while(oldNode != null) {
                int rehash = hash(oldNode.key);
                //System.out.println("rehash key: " + n.key + " to " + rehash);
                Node newBucketNode = newbuckets[rehash];
                Node newBucketPrevious = newBucketNode;
                while(newBucketNode != null) {
                    newBucketPrevious = newBucketNode;
                    newBucketNode = newBucketNode.next;
                }

                Node newNode = new Node(oldNode.key, oldNode.val);
                if(newBucketPrevious == null) {
                    newbuckets[rehash] = newNode;
                } else {
                    newBucketPrevious.next = newNode;
                }

                oldNode = oldNode.next;
            }
        }

        //reset the old bucket to new bucket
        buckets = newbuckets;
    }
    private boolean isAlmostFull() {
        return size >= capacity * loadfactor;
    }

    private int hash(int key) {
        return key % capacity;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        //1. If bucket is not empty then check for key in that bucket
        if(buckets[hash] != null) {
            Node node = buckets[hash];
            while(node != null) {
                if(node.key == key) return node.val;
                else node = node.next;
            }
        } else {
            //2. If bucket is empty then key not found return -1.
            return -1;
        }

        //3. If element not found in the bucket then return -1
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);

        //1. When bucket is not null then search for key in the bucket.
        if(buckets[hash] != null) {
            Node node = buckets[hash];
            Node prev = null;
            while(node != null) {
                //2. if key is found then
                if(node.key == key) {
                    size--;
                    //3. if previous is null then element is in first node in the bucket, so, get node.next and place in that bucket as first element
                    if(prev == null) {
                        buckets[hash] = node.next; break;
                    } else {
                        //4. if previous is not null then element is in middle or last, just move the pointers
                        prev.next = node.next; break;}
                }
                else {
                    //5. If not, assign node to previous and move the node
                    prev = node; node = node.next; }
            }
        }
    }

    private class Node {
        int key;
        int val;
        Node next;

        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }
}
