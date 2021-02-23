package Day8;

public class FindMaximumElementInBitonicArray {

	public static void main(String[] args) {
		int arr[] = { 5, 10, 20, 15 };
		System.out.println( "Bitonic maximum element in array : "+peakValue(arr, arr.length));

	}
	private static int peakValue(int[] arr, int length) {
		int start = 0, end = length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			
			if (mid > 0 && mid < length - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					return arr[mid];
				} else if (arr[mid - 1] > arr[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			
			} else if( mid == 0 ) {
				if( arr[0] > arr[1] ) {
					return 0;
				} else {
					return 1;
				}
			
			} else if( mid == length -1 ) {
				if( arr[length - 1] > arr[length - 2]) {
					return length - 1;
				} else {
					return length - 2;
				}
			}
		}
		return -1;
	}
}
