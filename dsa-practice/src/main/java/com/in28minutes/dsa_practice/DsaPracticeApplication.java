package com.in28minutes.dsa_practice;

import com.in28minutes.dsa_practice.binary_search.A04_Median_Of_Two_Sorted_Array;
import com.in28minutes.dsa_practice.binary_search.A153_Find_Minimun_In_Rotated_Sorted_Array;
import com.in28minutes.dsa_practice.binary_search.A33_Search_In_Rotated_Sorted_Array;
import com.in28minutes.dsa_practice.binary_search.A704_Binary_Search;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DsaPracticeApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DsaPracticeApplication.class, args);

        int[] nums1 = {1, 3, 8, 12, 15};
        int[] nums2 = {7, 9, 10};
        A04_Median_Of_Two_Sorted_Array medianOfTwoSortedArray = new A04_Median_Of_Two_Sorted_Array();
        double median = medianOfTwoSortedArray.findMedianSortedArrays(nums1, nums2);
        System.out.println("04. Median of two sorted array " + median);

        int[] nums3 = {4,5,6,7,0,1,2};
        int target = 0;
        A33_Search_In_Rotated_Sorted_Array searchInRotatedSortedArray = new A33_Search_In_Rotated_Sorted_Array();
        int pos = searchInRotatedSortedArray.search(nums3, target);
        System.out.println("33. Search in rotated sorted array:");
        System.out.println("Target "+ target +" is present at position " + pos + " in array {4,5,6,7,0,1,2}");

        System.out.println("153. Find minimum in rotated sorted array:");
        A153_Find_Minimun_In_Rotated_Sorted_Array findMinimunInRotatedSortedArray = new A153_Find_Minimun_In_Rotated_Sorted_Array();
        int[] nums4 = {4,5,6,7,0,1,2};
        int minimum = findMinimunInRotatedSortedArray.findMin(nums4);
        System.out.println("Minimun from {4,5,6,7,0,1,2} rotated sorted array : " + minimum);

//        nums = [-1,0,3,5,9,12], target = 9
        System.out.println("704. Binary Search:");
        int[] nums5 = {-1,0,3,5,9,12};
        int target2 = 9;
        A704_Binary_Search binarySearch = new A704_Binary_Search();
        int pos2 = binarySearch.search(nums5, target2);
        System.out.println("Element " + target2 + " is present at position " + pos2 + " in array {-1,0,3,5,9,12}");
	}

}
