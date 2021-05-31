package Activities;

import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
		int[] Array1 = {10, 5, 10,   6,10, 11};
		
		System.out.println(Arrays.toString(Array1));

		int Searchnum = 10;
		int sum = 30;
		
		System.out.println("Result " + result(Array1, Searchnum, sum));

	}

	public static int result(int[] Array1, int Searchnum, int sum) {
		int temp = 0;
		
		
		System.out.println("Fixed Sum : "+ sum);
		System.out.println(Arrays.toString(Array1));
		
		for (int num : Array1) {
			if (num == Searchnum) {
				temp += Searchnum;
			}
				
			System.out.println(temp);
			
			if (temp > Searchnum) {
				break;
			}	
		}
		return temp ;
		
	}
	
}
