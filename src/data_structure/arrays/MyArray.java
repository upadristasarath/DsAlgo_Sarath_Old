package data_structure.arrays;

import java.util.Arrays;

public class MyArray {
	Object[] data;
	int capacity = 0;
	int length = 0;
	
	public MyArray() {
		capacity = 1;
		data = new Object[capacity];  
		length = 0; 
	}
	
	public void push(Object value) {
		if (capacity == length) {
			data = Arrays.copyOf(data, capacity * 2);
			capacity *= 2;
		}
		data[length] = value;
		length++;
	}
	
	// O(1)
	public Object pop() {
		//LIFO
		Object value = data[length-1];
		data[length-1] = null;
		length--;
		return value;
	}
	
	// O(n)
	public Object delete(int index) {
		// delete any thing in the middle and do the shifts
		Object deletedValue = data[index];
		shiftValue(index);
		return deletedValue;
	}
	
	
	private void shiftValue(int index) {
		for (int i = index; i < data.length - 1; i++) {
			data[i] = data[i+1];
		}
		data[length - 1] = null;
		length--;
	}
	
	@Override
	public String toString() {
		return "MyArray [data=" + Arrays.toString(data) + ", capacity=" + capacity + ", length=" + length + "]";
	}

	public static void main(String[] args) {
		MyArray myArray = new MyArray();
		myArray.push("sarath");
		myArray.push("shreya");
		myArray.push("3");
		System.out.println(myArray);
		
		myArray.pop();
		System.out.println(myArray);
		myArray.push("vinodh");
		System.out.println(myArray);
		myArray.delete(1);
		System.out.println(myArray);
	}
	
}
