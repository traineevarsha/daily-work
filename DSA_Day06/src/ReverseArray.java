
public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = {2,9,2,7,1};
		for(int i=arr.length-1;i>=0;i--) {
			System.out.println(arr[i]);
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println();
		}
	}
}