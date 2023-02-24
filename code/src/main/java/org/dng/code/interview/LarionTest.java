package org.dng.code.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LarionTest {

public static void main(String[] args) {
	//
	
}

static class PhoneBook {
	
	// A -> 123 1
	// B -> 456
	// A -> 789 2
	
	// 1 -> 123
	// 2 -> 789
	
	// [_, _, _, _]
	// BST
	// .equal()
	// key 123 -> 1 val1-123
	// key 245 -> 1 val2-245
	
	// BST 123 -> 1
	//
	
	private AtomicInteger index = new AtomicInteger(1);
	private Map<String, List<Integer>> nameToID = new HashMap<>();
	private Map<Integer, String> idToPhone = new HashMap<>();
	
	public List<String> getPhone(String user) {
		List<String> list = new ArrayList<>();
		nameToID.get(user).forEach(i -> list.add(idToPhone.get(i)));
		return list;
	}
	
	public void addPhone(String user, String phone) {
		int newId = index.getAndIncrement();
		if (nameToID.containsKey(user)) {
			nameToID.get(user).add(newId);
			idToPhone.put(newId, phone);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(newId);
			nameToID.put(user, list);
		}
		idToPhone.put(newId, phone);
	}
}

}
