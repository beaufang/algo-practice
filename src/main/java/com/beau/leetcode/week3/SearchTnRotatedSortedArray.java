package com.beau.leetcode.week3;

/**
 * @author BeauFang
 * Date: 2020/7/29
 * 33 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class SearchTnRotatedSortedArray {


    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左区间单调
            if (nums[mid] >= nums[l]) {
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 这中方法格式不够统一，改写成了格式更统一的办法
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {

            int mid = left + (right - left + 1) / 2;
            // 如果右区间有序
            if (nums[mid] < nums[right]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            } else {
                // 这里故意缩小区间到 [left, mid - 1]，是为了方便统一取中值
                if (nums[left] <= target && target <= nums[mid - 1]) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }


    public static void main(String[] args) {
        SearchTnRotatedSortedArray solution = new SearchTnRotatedSortedArray();
        System.out.println(solution.search(new int[]{1,  3}, 1));
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 1));
        System.out.println(solution.search(new int[]{4,3,2,1}, 2));
        System.out.println(solution.search(new int[]{3, 1}, 1));
        System.out.println(solution.search(new int[]{3, 1}, 0));
    }
}
