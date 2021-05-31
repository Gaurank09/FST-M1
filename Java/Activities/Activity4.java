package Activities;

import java.util.Arrays;

class Activity4 {
    static void ascendingSort(int array[]) {
        int size = array.length, i;
        
        for (i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }
            array[j + 1] = key;
        }
    }
    
    static void descendingSort(int array2[]) {
    	int size = array2.length, i;
    	
    	for (i=1;i<size;i++) {
    		int key = array2[i];
    		int j = i-1;
    		
    		while (j >= 0 && key > array2[j]) {
    			array2[j+1] = array2[j];
    			--j;
    		}
    	array2[j+1] = key;
    	}   	
    }
    
    
    public static void main(String args[]) {
        int[] data = {5, 1, 23, 4, 3, 10, 71, 2};
        ascendingSort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
        
        System.out.println("----------------------------------");
        
        descendingSort(data);
        System.out.println("Sorted Array in Descending Order: ");
        System.out.println(Arrays.toString(data));
        
        
    }
}