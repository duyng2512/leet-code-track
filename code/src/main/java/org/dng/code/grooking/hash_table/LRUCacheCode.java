package org.dng.code.grooking.hash_table;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author duyntc 01/2023
 */
public class LRUCacheCode {
     
     /**
      * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
      * <p>
      * Implement the LRUCacheCode class:
      * <p>
      * LRUCacheCode(int capacity) Initialize the LRU cache with positive size capacity.
      * int get(int key) Return the value of the key if the key exists, otherwise return -1.
      * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
      * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
      * The functions get and put must each run in O(1) average time complexity.
      * <p>
      * <p>
      * <p>
      * Example 1:
      * <p>
      * Input
      * ["LRUCacheCode", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
      * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
      * Output
      * [null, null, null, 1, null, -1, null, -1, 3, 4]
      * <p>
      * Explanation
      * LRUCacheCode lRUCache = new LRUCacheCode(2);
      * lRUCache.put(1, 1); // cache is {1=1}
      * lRUCache.put(2, 2); // cache is {1=1, 2=2}
      * lRUCache.get(1);    // return 1
      * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
      * lRUCache.get(2);    // returns -1 (not found)
      * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
      * lRUCache.get(1);    // return -1 (not found)
      * lRUCache.get(3);    // return 3
      * lRUCache.get(4);    // return 4
      */
     
     // Using Linked Hash Map
     static class LRUCache {
	
	LinkedHashMap<Integer, Integer> map;
	// Linked List remain order of list
	int cap;
	
	public LRUCache(int capacity) {
	     this.cap = capacity;
	     map = new LinkedHashMap<>();
	}
	
	public int get(int key) {
	     
	     if (!map.containsKey(key)) {
		return -1;
	     }
	     
	     int value = map.get(key);
	     map.remove(key);
	     map.put(key, value);
	     return value;
	}
	
	public void put(int key, int value) {
	     if (map.containsKey(key)) {
		map.remove(key);
		map.put(key, value);
	     } else {
		map.put(key, value);
		if (map.size() > cap) {
		     // Remove first element
		     map.remove(map.keySet().iterator().next());
		}
	     }
	}
     }
     
     public static void main(String[] args) {
	LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
	map.put(1, 1);
	map.put(1, 2);
	System.out.println(map.get(1));
	System.out.println(map.size());
     }
     
     // Using DD
     static class LRUCacheDD {
	
	static class Dnode {
	     public int val;
	     public Dnode prev;
	     public Dnode next;
	     
	     public Dnode(int val, Dnode prev, Dnode next) {
		this.val = val;
		this.prev = prev;
		this.next = next;
	     }
	}
	
	Map<Integer, Dnode> map;
	int size;
	int capacity;
	Dnode lastNode;
	Dnode firstNode;
	
	public LRUCacheDD(int capacity) {
	     this.capacity = capacity;
	     this.size = 0;
	     this.map = new HashMap<>();
	}
	
	public int get(int key) {
	     Dnode node = map.get(key);
	     int result = node.val;
	     Dnode prev = node.prev;
	     Dnode next = node.next;
	     
	     prev.next = next;
	     next.prev = prev;
	     node.next = null;
	     node.prev = lastNode;
	     lastNode.next = node;
	     lastNode = node;
	     
	     return result;
	}
	
	public void put(int key, int value) {
	     Dnode newNode = new Dnode(key, null, null);
	     size++;
	     map.put(key, newNode);
	     
	     if (firstNode == null || lastNode == null) {
		firstNode = newNode;
		lastNode = newNode;
	     } else {
		
		// Link new node
		newNode.prev = lastNode;
		lastNode.next = newNode;
		lastNode = newNode;
		
		// If size is larger
		if (size > capacity) {
		     // remove first node
		     int oldestKey = firstNode.val;
		     map.remove(oldestKey);
		     firstNode.prev = null;
		     firstNode = firstNode.next;
		     size--;
		}
	     }
	}
     }
     
}
