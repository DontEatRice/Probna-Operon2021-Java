package bin;

import java.util.ArrayList;

public class luckyNumbers {
	private int[] nums; 
	
	public luckyNumbers() {
		ArrayList<Integer> numbers= new ArrayList<>();
		
		int counter = 1;
		while (counter <= 10000) {
			numbers.add(counter++);
		}
		for(int i = 0; i<numbers.size(); i++) {
			if (numbers.get(i) % 2 == 0) {
				numbers.remove(i);
			}
		}
		int luckyNumber = 3;
		int luckyIndex = 1;
		
		while(numbers.get(numbers.size()-1) != luckyNumber) {
			for (int i = luckyNumber-1; i < numbers.size(); i += luckyNumber) {
				numbers.set(i, null);
			}
			for (int i = 0; i < numbers.size(); i++) {
				if (numbers.get(i) == null) {
					numbers.remove(i);
				}
			}
			luckyNumber = numbers.get(++luckyIndex);
		}
		this.nums = new int[numbers.size()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numbers.get(i);
		}
	}
	
	public int[] toArray() {
		return nums;
	}
}
