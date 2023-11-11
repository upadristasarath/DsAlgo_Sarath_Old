package data_structure.arrays;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum.twoSum(new int[] {2, 5, 5, 11}, 10);
	}
	
	
	public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i< nums.length; i++) {
        	for (int j = i + 1; j< nums.length; j++) {
        		if (nums[i] + nums[j] == target) {
        			System.out.println(i + "" + j);
        			return new int[] {i, j};
        		}
        	}
        }
        return null;
    }

}
