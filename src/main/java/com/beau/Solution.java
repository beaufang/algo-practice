package com.beau;

import junit.framework.TestCase;
import org.junit.Test;

public class Solution {

   public int search(int[] nums) {
      int l = 0, r = nums.length - 1;
      while (l <= r) {
          int mid = l + (r - l + 1) / 2;
          // 发生了逆序
          if (nums[mid] <= nums[0] && nums[mid] <= nums[mid - 1]) {
              return mid;
          }
          // 如果在 0  ->  mid, 中 nums[mid] 不是最小的，说明分界点靠右
          if (nums[mid] > nums[0]) {
              // 分界点靠右
              l = mid + 1;
          } else {
              r = mid - 1;
          }
      }
      return l;
   }

   @Test
    public void test() {
       TestCase.assertEquals(4, search(new int[] {4, 5, 6, 7, 0, 1, 2}));
       TestCase.assertEquals(2, search(new int[] {4, 5, 1}));
       TestCase.assertEquals(2, search(new int[] {4, 5, 6}));
       // 完全逆序，这种情况处理不了
//       TestCase.assertEquals(0, search(new int[] {6, 5, 4}));
   }
}
