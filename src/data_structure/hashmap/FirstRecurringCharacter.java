package data_structure.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class FirstRecurringCharacter  {

	public static int getFirstRecurringChar(List<Integer> list) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer element: list) {
			Integer currentElementCount = map.get(element);
			if (currentElementCount == null) {
				currentElementCount = new Integer(1); 
			} else {
				currentElementCount += 1;
			}
			map.put(element, currentElementCount);
			
			if (currentElementCount > 1) {
				return element;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		List list = new ArrayList<>();
		list.add(2);
		list.add(5);
		list.add(5);
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(1);
		System.out.println(FirstRecurringCharacter.getFirstRecurringChar(list));
		
		
		
	}
	
	
	
	
}
