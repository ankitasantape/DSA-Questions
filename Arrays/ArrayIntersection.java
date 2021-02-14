Intersection of arrays arr1[] and arr2[]

To find intersection of 2 sorted arrays, follow the below approach : 
 
1) Use two index variables i and j, initial values i = 0, j = 0 
2) If arr1[i] is smaller than arr2[j] then increment i. 
3) If arr1[i] is greater than arr2[j] then increment j. 
4) If both are same then print any of them and increment both i and j.

Below is the implementation of the above approach :
// Java program to find intersection of 
// two sorted arrays 
  
class FindIntersection { 
    /* Function prints Intersection of arr1[] and arr2[] 
       m is the number of elements in arr1[] 
       n is the number of elements in arr2[] */
    static void printIntersection(int arr1[], int arr2[], int m, int n) 
    { 
        int i = 0, j = 0; 
        while (i < m && j < n) { 
            if (arr1[i] < arr2[j]) 
                i++; 
            else if (arr2[j] < arr1[i]) 
                j++; 
            else { 
                System.out.print(arr2[j++] + " "); 
                i++; 
            } 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        int arr1[] = { 1, 2, 4, 5, 6 }; 
        int arr2[] = { 2, 3, 5, 7 }; 
        int m = arr1.length; 
        int n = arr2.length; 
        printIntersection(arr1, arr2, m, n); 
    } 
} 
Output: 
 

2 5
Time Complexity : O(m + n)

Intersection Of Two Array
public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int top = 0;
        int bottom = 0;
        List<Integer> h = new ArrayList<>();

        while (true){
            if (top >= nums1.length || bottom >= nums2.length){
                break;
            }
            if (nums1[top] == nums2[bottom]){
                h.add(nums1[top]);
                top ++;
                bottom ++;
            }
            else if (nums1[top] < nums2[bottom]){
                top ++;
            }
            else if (nums1[top] > nums2[bottom]){
                bottom ++;
            }
        }

        int[] g = new int[h.size()];
        for (int i = 0; i < h.size(); i++) {
            g[i] = h.get(i);
        }
        return g;
    }

============================================== Approach 2 =============================================================================================================================

Handling duplicate in Arrays :
Above code does not handle duplicate elements in arrays. The intersection should not count duplicate elements. 
To handle duplicates just check whether current element is already present in intersection list. Below is the implementation of this approach.

public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set = new HashSet<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        // Map that stores the array elements
        for(int i=0; i< nums1.length;i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i], 1);
            }else{
                map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
            }
        }
        //compare and add it to the set
        for(int i =0;i< nums2.length;i++){
            if(map.containsKey(nums2[i])){
                set.add(nums2[i]);
            }
        }
        
		//from the set form an array and return it.
        Iterator it = set.iterator();
        int[] res = new int[set.size()];
        for(int i=0; i< set.size();i++){
            res[i] = (Integer)it.next();
        }
        return res;
    }

