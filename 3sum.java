//  Problem Statement:
// Given an integer array `nums`, return all triplets [nums[i], nums[j], nums[k]] such that:
// - i != j, i != k, and j != k
// - nums[i] + nums[j] + nums[k] == 0
// - No duplicate triplets allowed

//  Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation:
// Triplets are:
// - (-1) + 0 + 1 = 0
// - (-1) + (-1) + 2 = 0

//  Example 2:
// Input: nums = [0,1,1]
// Output: []
// No triplet sums to 0.

//  Example 3:
// Input: nums = [0,0,0]
// Output: [[0,0,0]]

//  Approach (Sorting + Two Pointers):
// 1. Sort the array first.
// 2. Fix one element (nums[i]) and then use two pointers (`left` and `right`) to find two numbers such that:
//    - nums[i] + nums[left] + nums[right] == 0
// 3. Skip duplicates for the fixed element and while moving left and right pointers to avoid duplicate triplets.
// 4. If sum == 0, add the triplet to the result.
// 5. If sum < 0: move `left++`
// 6. If sum > 0: move `right--`

//  Why Sort First?
// - It helps easily skip duplicates
// - It allows using the two-pointer technique efficiently

//  Time Complexity: O(n^2)
//  Space Complexity: O(1) extra space (ignoring output list)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                }
                else if (sum < 0) {
                    left++; 
                }
                else {
                    right--; 
                }
            }
        }
        
        return result;
    }
}
