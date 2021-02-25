package Day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
10
1 1 1 2 2 3 3 4 4 4
9
[1, 1, 3, 4]
[1, 2, 2, 4]
[1, 2, 3, 3]
*/
public class FindAllFourSumNumbers {
    
	public static ArrayList<List<Integer>> fourSum(int n, int nums[], int target) {
		ArrayList<List<Integer>> res = new ArrayList<>();
		if( nums == null || nums.length == 0 ) {
			return res;
		}
		n = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < n - 3; i++) {
			for (int j = i + 1; j < n - 2; j++) {
				int target_2 = target - nums[i] - nums[j];
				int left = j + 1;
				int right = n - 1;
				while (left < right) {
					int twoSum = nums[left] + nums[right];
					if (twoSum < target_2) {
						left++;
					} else if (twoSum > target_2) {
						right--;
					} else {
						List<Integer> fourSum = new ArrayList<>();
						fourSum.add(nums[i]);
						fourSum.add(nums[j]);
						fourSum.add(nums[left]);
						fourSum.add(nums[right]);
						res.add(fourSum);

//						System.out.println("["+nums[i]+","+nums[j]+","+nums[left]+","+nums[right]+"]");
						// Jump over the duplicates of number 3
						while (left < right && nums[left] == fourSum.get(2)) {
							++left;
						}
						// Jump over the duplicates of number 4
						while (left < right && nums[right] == fourSum.get(3)) {
							--right;
						}
					}

					while (j + 1 < n && nums[j + 1] == nums[j]) {
						++j;
					}
				}
				while (i + 1 < n && nums[i + 1] == nums[i]) {
					++i;
				}

			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		ArrayList<List<Integer>> ans = fourSum(n,arr,target);
		
		for(List<Integer> lis : ans ) {
			System.out.println(lis);
		}
		sc.close();
	}
}
