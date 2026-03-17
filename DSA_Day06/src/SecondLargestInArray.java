import java.util.Arrays;

public class SecondLargestInArray {
    public static void main(String[] args) {
        int[] arr = {-1,-6,-4,-3,-9,-2};
        System.out.println("Orginal Array:"+ Arrays.toString(arr));
  
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

            if(arr.length<=2) {
            	secondLargest = Math.min(arr[0], arr[1]);
            }else {
            	for (int i = 1; i < arr.length; i++) {
            		if(arr[i]>largest) {
            			secondLargest = largest;
            			largest = arr[i];
            		} 
             
            		else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }}

        System.out.println(secondLargest);
    }
}