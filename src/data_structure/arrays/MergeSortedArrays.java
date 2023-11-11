package data_structure.arrays;

public class MergeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MergeSortedArrays.mergeSortedArr(new int[] {1, 3, 5}, new int[] {2, 4, 7}));
	}
	
	private static int[] mergeSortedArr(int[] arr1, int[] arr2 ) {
		
		int firstElement1 = arr1[0];
		int firstElement2 = arr2[0];
		int point1 = 0;
		int point2 = 0;
		int[] arr3 = new int[(arr1.length + arr2.length)];
		int i = 0;
		for(i = 0; i < arr3.length; i++) {
			if (firstElement1 < firstElement2) {
				arr3[i] = firstElement1;
				++point1;
				if (point1 < arr1.length) {
					firstElement1 = arr1[point1];
				} else {
					break;
				}
				
			} else {
				arr3[i] = firstElement2;
				++point2;
				if (point2 < arr2.length) {
					firstElement2 = arr2[point2];
				} else {
					break;
				}
			}
		}
		
		if (point1 >= arr1.length) {
			// add remaining arr2 elements into the arr3 from point2
			for (int j = point2; j < arr2.length; j++) {
				arr3[++i] = arr2[j];
			}
		} 
		if (point2 >= arr2.length) {
			// add remaining arr1 elements into the arr3 from point1
			for (int j = point1; j < arr1.length; j++) {
				arr3[++i] = arr1[j];
			}
		}
		return arr3;
	}

}
