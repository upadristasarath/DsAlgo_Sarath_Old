package data_structure.hashmap;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
	ArrayList<KeyValue> data[];
	int currentIndex = 0;
	
	public MyHashMap(int size) {
		data = new ArrayList[size];
		currentIndex = 0;
	}
	
	public Integer _hashCode(String key) {
		int hash = 0;
		for (int i = 0; i < key.length(); i++) {
			hash = (hash + key.codePointAt(i) * i) % data.length;
			System.out.println(hash);
		}
		return hash;
	}

	// No collision O(1)
	// else with collision O(n)
	public Integer get(String key) {
		Integer index = _hashCode(key);
		ArrayList<KeyValue> list = data[index];
		if (list != null) {
			for (KeyValue keyValue: list) {
				if (keyValue.getKey().equals(key)) {
					return keyValue.getValue();
				}
			}
		}
		return null;
	}
	
	// O(1)
	public void put(String key, Integer value) {
		Integer index = _hashCode(key);
		if (data[index] == null) {
			KeyValue keyValue= new KeyValue(key, value);
			ArrayList<KeyValue> list = new ArrayList<>();
			list.add(keyValue);
			data[index] = list;
			currentIndex++;
		} else {
			ArrayList<KeyValue> list = data[index];
			KeyValue keyValue= new KeyValue(key, value);
			list.add(keyValue);
		}
	}
	
	@Override
	public String toString() {
		for (ArrayList l: data) {
			return l.get(0).toString();
		}
		return null;
	}
	
	public String[] keys() {
		String[] keys = new String[currentIndex];
		int count = 0;
		for (ArrayList<KeyValue> list: data) {
			if (null != list) {
				keys[count++] = list.get(0).getKey();
			}
		}
		return keys;
	}

	public static void main(String[] args) {
		MyHashMap mHashMap = new MyHashMap(50);
		mHashMap.put("sarath", 100);
		mHashMap.put("vinodh", 200);
		System.out.println(mHashMap.get("vinodh"));
		System.out.println(mHashMap.keys());
	}
}
